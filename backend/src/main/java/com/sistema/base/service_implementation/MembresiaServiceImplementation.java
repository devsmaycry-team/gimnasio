package com.sistema.base.service_implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.base.DTO.Request.MembresiaRequest;
import com.sistema.base.DTO.Response.MembresiaResponse;
import com.sistema.base.DTO.Response.PagosResponse;
import com.sistema.base.model.Membresia;
import com.sistema.base.model.Pagos;
import com.sistema.base.model.Plan;
import com.sistema.base.model.Socio;
import com.sistema.base.repository.MembresiaRepository;
import com.sistema.base.repository.PlanRepository;
import com.sistema.base.repository.SocioRepository;
import com.sistema.base.service.MembresiaService;

@Service
public class MembresiaServiceImplementation implements MembresiaService {

    @Autowired
    private MembresiaRepository membresiaRepository;

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private PlanRepository planRepository;

    // 🔹 Obtener todos
    @Override
    public List<MembresiaResponse> obtenertodos() {
        return membresiaRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    // 🔹 Obtener por ID
    @Override
    public MembresiaResponse obtenerPorId(Long id) {
        Membresia membresia = membresiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membresia no encontrada"));

        return convertirAResponse(membresia);
    }

    // 🔹 Guardar
    @Override
    public MembresiaResponse guardar(MembresiaRequest dto) {

        Socio socio = socioRepository.findById(dto.getSocio_id())
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        Plan plan = planRepository.findById(dto.getPlan_id())
                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));

        Membresia membresia = new Membresia();
        membresia.setSocio(socio);
        membresia.setPlan(plan);
        membresia.setFecha_inicio(dto.getFecha_inicio());
        membresia.setFecha_fin(dto.getFecha_fin());
        membresia.setEstado(dto.isEstado());

        Membresia guardada = membresiaRepository.save(membresia);

        return convertirAResponse(guardada);
    }

    // 🔹 Editar
    @Override
    public MembresiaResponse editar(Long id, MembresiaRequest dto) {

        Membresia membresia = membresiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membresia no encontrada"));

        Socio socio = socioRepository.findById(dto.getSocio_id())
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        Plan plan = planRepository.findById(dto.getPlan_id())
                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));

        membresia.setSocio(socio);
        membresia.setPlan(plan);
        membresia.setFecha_inicio(dto.getFecha_inicio());
        membresia.setFecha_fin(dto.getFecha_fin());
        membresia.setEstado(dto.isEstado());

        Membresia actualizada = membresiaRepository.save(membresia);

        return convertirAResponse(actualizada);
    }

    // 🔹 Eliminar
    @Override
    public void eliminar(Long id) {
        membresiaRepository.deleteById(id);
    }

    // 🔹 Converter Entity → Response
    private MembresiaResponse convertirAResponse(Membresia m) {

        List<PagosResponse> pagos = null;

        if (m.getPagos() != null) {
            pagos = m.getPagos().stream().map(this::convertirPago).collect(Collectors.toList());
        }

        return new MembresiaResponse(
                m.getId(),
                m.getSocio().getId(),
                m.getPlan().getId(),
                m.getFecha_inicio(),
                m.getFecha_fin(),
                m.isEstado(),
                pagos
        );
    }

    private PagosResponse convertirPago(Pagos p) {
        PagosResponse pr = new PagosResponse();
        pr.setId(p.getId());
        pr.setMonto(p.getMonto());
        pr.setFecha(p.getFecha());
        return pr;
    }
}
