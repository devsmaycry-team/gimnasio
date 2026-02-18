package com.sistema.base.service_implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.base.DTO.Request.RutinaRequest;
import com.sistema.base.DTO.Response.DiaRutinaResponse;
import com.sistema.base.DTO.Response.RegistroEjercicioResponse;
import com.sistema.base.DTO.Response.RutinaResponse;
import com.sistema.base.model.Entrenador;
import com.sistema.base.model.Rutina;
import com.sistema.base.repository.EntrenadorRepository;
import com.sistema.base.repository.RutinaRepository;
import com.sistema.base.service.RutinaService;

@Service
public class RutinaServiceImplementation implements RutinaService {

    @Autowired
    private RutinaRepository rutinaRepository;

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    // =========================
    // GET ALL
    // =========================
    @Override
    public List<RutinaResponse> obtenerTodos() {
        return rutinaRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    // =========================
    // GET BY ID
    // =========================
    @Override
    public RutinaResponse obtenerPorId(Long id) {
        Rutina rutina = rutinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada"));

        return convertirAResponse(rutina);
    }

    // =========================
    // CREATE
    // =========================
    @Override
    public RutinaResponse guardar(RutinaRequest dto) {

        Entrenador entrenador = entrenadorRepository.findById(dto.getEntrenador_id())
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));

        Rutina rutina = new Rutina();
        rutina.setEntrenador(entrenador);
        rutina.setNombre(dto.getNombre());
        rutina.setObjetivo(dto.getObjetivo());
        rutina.setNivel(dto.getNivel());
        rutina.setDuracion_semanas(dto.getDuracion_semanas()); // ✔ STRING
        rutina.setEstado(dto.isEstado());
        rutina.setEditable(dto.isEditable());

        Rutina guardada = rutinaRepository.save(rutina);

        return convertirAResponse(guardada);
    }

    // =========================
    // UPDATE
    // =========================
    @Override
    public RutinaResponse editar(Long id, RutinaRequest dto) {

        Rutina rutina = rutinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada"));

        Entrenador entrenador = entrenadorRepository.findById(dto.getEntrenador_id())
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));

        rutina.setEntrenador(entrenador);
        rutina.setNombre(dto.getNombre());
        rutina.setObjetivo(dto.getObjetivo());
        rutina.setNivel(dto.getNivel());
        rutina.setDuracion_semanas(dto.getDuracion_semanas()); // ✔ STRING
        rutina.setEstado(dto.isEstado());
        rutina.setEditable(dto.isEditable());

        Rutina actualizada = rutinaRepository.save(rutina);

        return convertirAResponse(actualizada);
    }

    // =========================
    // DELETE
    // =========================
    @Override
    public void eliminar(Long id) {
        rutinaRepository.deleteById(id);
    }

    // =========================
    // MAPPER
    // =========================
    private RutinaResponse convertirAResponse(Rutina rutina) {

        // -------------------------
        // DIAS
        // -------------------------
        List<DiaRutinaResponse> dias = null;

        if (rutina.getDiasRutinas() != null) {
            dias = rutina.getDiasRutinas().stream()
                    .map(d -> {
                        DiaRutinaResponse dto = new DiaRutinaResponse();
                        dto.setId(d.getId());
                        dto.setRutina_id(rutina.getId());

                        // IMPORTANTE: usar getDiaSemana()
                        dto.setDia_semana(d.getDiaSemana());

                        // Si existe orden
                        dto.setOrden(d.getOrden());

                        return dto;
                    })
                    .collect(Collectors.toList());
        }

        // -------------------------
        // REGISTROS
        // -------------------------
        List<RegistroEjercicioResponse> registros = null;

        if (rutina.getRegistroEjercicios() != null) {
            registros = rutina.getRegistroEjercicios().stream()
                    .map(r -> {
                        RegistroEjercicioResponse dto = new RegistroEjercicioResponse();

                        dto.setId(r.getId());
                        dto.setRutina_id(rutina.getId());
                        dto.setEjercicio_id(r.getEjercicio() != null ? r.getEjercicio().getId() : null);
                        dto.setSeries_hechas(r.getSeries_hechas());
                        dto.setRepeticiones_hechas(r.getRepeticiones_hechas());
                        dto.setPeso_real(r.getPeso_real());
                        dto.setObservacion(r.getObservacion());

                        return dto;
                    })
                    .collect(Collectors.toList());
        }

        // -------------------------
        // RESPONSE FINAL
        // -------------------------
        RutinaResponse response = new RutinaResponse();

        response.setId(rutina.getId());
        response.setEntrenador_id(
                rutina.getEntrenador() != null ? rutina.getEntrenador().getId() : null
        );
        response.setNombre(rutina.getNombre());
        response.setObjetivo(rutina.getObjetivo());
        response.setNivel(rutina.getNivel());
        response.setDuracion_semanas(rutina.getDuracion_semanas()); // ✔ STRING
        response.setEstado(rutina.isEstado());
        response.setEditable(rutina.isEditable());
        response.setDiasRutinas(dias);
        response.setRegistroEjercicios(registros);

        return response;
    }
}
