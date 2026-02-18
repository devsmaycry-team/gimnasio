package com.sistema.base.service_implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.base.DTO.Request.HorariosClasesRequest;
import com.sistema.base.DTO.Response.HorariosClasesResponse;
import com.sistema.base.model.Clase;
import com.sistema.base.model.HorariosClases;
import com.sistema.base.repository.ClaseRepository;
import com.sistema.base.repository.HorariosClasesRepository;
import com.sistema.base.service.HorariosClasesService;

@Service
public class HorariosClasesServiceImplementation implements HorariosClasesService {

    @Autowired
    private HorariosClasesRepository horariosClasesRepository;

    @Autowired
    private ClaseRepository claseRepository;

    // ===============================
    // Obtener todos
    // ===============================
    @Override
    public List<HorariosClasesResponse> obtenertodos() {
        return horariosClasesRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ===============================
    // Obtener por ID
    // ===============================
    @Override
    public HorariosClasesResponse obtenerPorId(Long id) {
        HorariosClases horario = horariosClasesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Horario no encontrado"));

        return mapToResponse(horario);
    }

    // ===============================
    // Guardar
    // ===============================
    @Override
    public HorariosClasesResponse guardar(HorariosClasesRequest dto) {

        Clase clase = claseRepository.findById(dto.getClase_id())
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));

        HorariosClases horario = new HorariosClases();
        horario.setClase(clase);
        horario.setDia_semana(dto.getDia_semana());
        horario.setHoraInicio(dto.getHoraInicio());
        horario.setHoraFin(dto.getHoraFin());

        horariosClasesRepository.save(horario);

        return mapToResponse(horario);
    }

    // ===============================
    // Eliminar
    // ===============================
    @Override
    public void eliminar(Long id) {
        if (!horariosClasesRepository.existsById(id)) {
            throw new RuntimeException("Horario no encontrado");
        }
        horariosClasesRepository.deleteById(id);
    }

    // ===============================
    // Editar
    // ===============================
    @Override
    public HorariosClasesResponse editar(Long id, HorariosClasesRequest dto) {

        HorariosClases horario = horariosClasesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Horario no encontrado"));

        Clase clase = claseRepository.findById(dto.getClase_id())
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));

        horario.setClase(clase);
        horario.setDia_semana(dto.getDia_semana());
        horario.setHoraInicio(dto.getHoraInicio());
        horario.setHoraFin(dto.getHoraFin());

        horariosClasesRepository.save(horario);

        return mapToResponse(horario);
    }

    // ===============================
    // Mapper
    // ===============================
    private HorariosClasesResponse mapToResponse(HorariosClases horario) {
        return new HorariosClasesResponse(
                horario.getId(),
                horario.getClase().getId(),
                horario.getDia_semana(),
                horario.getHoraInicio(),
                horario.getHoraFin()
        );
    }
}
