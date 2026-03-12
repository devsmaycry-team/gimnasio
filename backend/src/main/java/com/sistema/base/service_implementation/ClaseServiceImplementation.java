package com.sistema.base.service_implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.base.DTO.Request.ClaseRequest;
import com.sistema.base.DTO.Response.ClaseResponse;
import com.sistema.base.model.Clase;
import com.sistema.base.model.Entrenador;
import com.sistema.base.model.Gimnasio;
import com.sistema.base.repository.ClaseRepository;
import com.sistema.base.repository.EntrenadorRepository;
import com.sistema.base.repository.GimnasioRepository;
import com.sistema.base.service.ClaseService;

@Service
public class ClaseServiceImplementation implements ClaseService {

    @Autowired
    private ClaseRepository claseRepository;

    @Autowired
    private EntrenadorRepository entrenadorRepository;
    @Autowired
    private GimnasioRepository gimnasioRepository;

    // -------------------------
    // GET ALL
    // -------------------------
    @Override
    public List<ClaseResponse> obtenertodos() {
        return claseRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    // -------------------------
    // GET BY ID
    // -------------------------
    @Override
    public ClaseResponse obtenerPorId(Long id) {
        Clase clase = claseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));
        return toResponseDto(clase);
    }

    // -------------------------
    // CREATE
    // -------------------------
    @Override
    public ClaseResponse guardar(ClaseRequest dto) {

        Entrenador entrenador = entrenadorRepository.findById(dto.getEntrenador_id())
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));

        Gimnasio gimnasio = gimnasioRepository.findById(dto.getGimnasio_id())
            .orElseThrow(() -> new RuntimeException("gimnasio no encontrado"));
        Clase clase = new Clase();
        clase.setEntrenador(entrenador);
        clase.setGimnasio(gimnasio);
        clase.setCupo_maximo(dto.getCupo_maximo());

        Clase guardada = claseRepository.save(clase);
        return toResponseDto(guardada);
    }

    // -------------------------
    // UPDATE
    // -------------------------
    @Override
    public ClaseResponse editar(Long id, ClaseRequest dto) {

        Clase clase = claseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));

        Entrenador entrenador = entrenadorRepository.findById(dto.getEntrenador_id())
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));

        Gimnasio gimnasio = gimnasioRepository.findById(dto.getGimnasio_id())
            .orElseThrow(() -> new RuntimeException("gimnasio no encontrado"));
        clase.setEntrenador(entrenador);
        clase.setCupo_maximo(dto.getCupo_maximo());
        clase.setGimnasio(gimnasio);
        Clase actualizada = claseRepository.save(clase);
        return toResponseDto(actualizada);
    }

    // -------------------------
    // DELETE
    // -------------------------
    @Override
    public void eliminar(Long id) {
        Clase clase = claseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));

        claseRepository.delete(clase);
    }

    // =========================
    // MAPPER
    // =========================
    private ClaseResponse toResponseDto(Clase clase) {
        ClaseResponse dto = new ClaseResponse();
        dto.setId(clase.getId());
        dto.setEntrenador_id(clase.getEntrenador().getId());
        dto.setGimnasio_id(clase.getGimnasio().getId());
        dto.setCupo_maximo(clase.getCupo_maximo());
        return dto;
    }
}
