package com.sistema.base.service_implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.base.DTO.Request.PagosRequest;
import com.sistema.base.DTO.Response.PagosResponse;
import com.sistema.base.model.Membresia;
import com.sistema.base.model.Pagos;
import com.sistema.base.model.Socio;
import com.sistema.base.repository.MembresiaRepository;
import com.sistema.base.repository.PagosRepository;
import com.sistema.base.repository.SocioRepository;
import com.sistema.base.service.PagosService;

@Service
public class PagosServiceImplementation implements PagosService {

    @Autowired
    private PagosRepository pagosRepository;

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private MembresiaRepository membresiaRepository;

    @Override
    public List<PagosResponse> obtenertodos() {
        return pagosRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PagosResponse obtenerPorId(Long id) {
        Pagos pago = pagosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));

        return convertirAResponse(pago);
    }

    @Override
    public PagosResponse guardar(PagosRequest dto) {

        Socio socio = socioRepository.findById(dto.getSocio_id())
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        Membresia membresia = membresiaRepository.findById(dto.getMembresia_id())
                .orElseThrow(() -> new RuntimeException("Membresia no encontrada"));

        Pagos pago = new Pagos();
        pago.setSocio(socio);
        pago.setMembresia(membresia);
        pago.setMonto(dto.getMonto());
        pago.setMetodo_pago(dto.getMetodo_pago());
        pago.setFecha(dto.getFecha());
        pago.setReferencia(dto.getReferencia());

        Pagos guardado = pagosRepository.save(pago);

        return convertirAResponse(guardado);
    }

    @Override
    public PagosResponse editar(Long id, PagosRequest dto) {

        Pagos pago = pagosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));

        Socio socio = socioRepository.findById(dto.getSocio_id())
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        Membresia membresia = membresiaRepository.findById(dto.getMembresia_id())
                .orElseThrow(() -> new RuntimeException("Membresia no encontrada"));

        pago.setSocio(socio);
        pago.setMembresia(membresia);
        pago.setMonto(dto.getMonto());
        pago.setMetodo_pago(dto.getMetodo_pago());
        pago.setFecha(dto.getFecha());
        pago.setReferencia(dto.getReferencia());

        Pagos actualizado = pagosRepository.save(pago);

        return convertirAResponse(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        pagosRepository.deleteById(id);
    }

    private PagosResponse convertirAResponse(Pagos p) {
        return new PagosResponse(
                p.getId(),
                p.getSocio().getId(),
                p.getMembresia().getId(),
                p.getMonto(),
                p.getMetodo_pago(),
                p.getFecha(),
                p.getReferencia()
        );
    }
}
