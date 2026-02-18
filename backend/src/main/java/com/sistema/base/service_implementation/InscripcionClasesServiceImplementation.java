package com.sistema.base.service_implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.base.DTO.Request.InscripcionClasesRequest;
import com.sistema.base.DTO.Response.InscripcionClasesResponse;
import com.sistema.base.model.HorariosClases;
import com.sistema.base.model.InscripcionClases;
import com.sistema.base.model.Socio;
import com.sistema.base.repository.HorariosClasesRepository;
import com.sistema.base.repository.InscripcionClasesRepository;
import com.sistema.base.repository.SocioRepository;
import com.sistema.base.service.InscripcionClasesService;

@Service
public class InscripcionClasesServiceImplementation implements InscripcionClasesService {

    @Autowired
    private InscripcionClasesRepository repository;

    @Autowired
    private HorariosClasesRepository horariosRepository;

    @Autowired
    private SocioRepository socioRepository;

    // =========================
    // GET ALL
    // =========================
    @Override
    public List<InscripcionClasesResponse> obtenertodos() {
        return repository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    // =========================
    // GET BY ID
    // =========================
    @Override
    public InscripcionClasesResponse obtenerPorId(Long id) {
        InscripcionClases entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscripción no encontrada"));

        return toResponseDto(entity);
    }

    // =========================
    // CREATE
    // =========================
    @Override
    public InscripcionClasesResponse guardar(InscripcionClasesRequest request) {

        HorariosClases horarios = horariosRepository.findById(request.getHorariosClases_id())
                .orElseThrow(() -> new RuntimeException("Horario no encontrado"));

        Socio socio = socioRepository.findById(request.getSocio_id())
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        InscripcionClases entity = new InscripcionClases();
        entity.setHorariosClases(horarios);
        entity.setSocio(socio);

        InscripcionClases guardado = repository.save(entity);

        return toResponseDto(guardado);
    }

    // =========================
    // UPDATE
    // =========================
    @Override
    public InscripcionClasesResponse editar(Long id, InscripcionClasesRequest request) {

        InscripcionClases entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscripción no encontrada"));

        if (request.getHorariosClases_id() != null) {
            HorariosClases horarios = horariosRepository.findById(request.getHorariosClases_id())
                    .orElseThrow(() -> new RuntimeException("Horario no encontrado"));
            entity.setHorariosClases(horarios);
        }

        if (request.getSocio_id() != null) {
            Socio socio = socioRepository.findById(request.getSocio_id())
                    .orElseThrow(() -> new RuntimeException("Socio no encontrado"));
            entity.setSocio(socio);
        }

        InscripcionClases actualizado = repository.save(entity);

        return toResponseDto(actualizado);
    }

    // =========================
    // DELETE
    // =========================
    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Inscripción no encontrada");
        }
        repository.deleteById(id);
    }

    // =========================
    // MAPPER
    // =========================
    private InscripcionClasesResponse toResponseDto(InscripcionClases entity) {

        InscripcionClasesResponse dto = new InscripcionClasesResponse();

        dto.setId(entity.getId());

        dto.setHorariosClases_id(
                entity.getHorariosClases() != null ? entity.getHorariosClases().getId() : null
        );

        dto.setSocio_id(
                entity.getSocio() != null ? entity.getSocio().getId() : null
        );

        return dto;
    }
}
