package com.sistema.base.service_implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.base.DTO.Request.DiaRutinaRequest;
import com.sistema.base.DTO.Response.DiaRutinaResponse;
import com.sistema.base.DTO.Response.RutinaEjercicioResponse;
import com.sistema.base.model.DiasRutina;
import com.sistema.base.model.Rutina;
import com.sistema.base.model.RutinaEjercicio;
import com.sistema.base.repository.DiasRutinaRepository;
import com.sistema.base.repository.RutinaRepository;
import com.sistema.base.service.DiasRutinaService;

@Service
public class DiasRutinaServiceImplementation implements DiasRutinaService {

    @Autowired
    private DiasRutinaRepository diasRutinaRepository;

    @Autowired
    private RutinaRepository rutinaRepository;

    // -------------------------
    // GET ALL
    // -------------------------
    @Override
    public List<DiaRutinaResponse> obtenertodos() {
        return diasRutinaRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    // -------------------------
    // GET BY ID
    // -------------------------
    @Override
    public DiaRutinaResponse obtenerPorId(Long id) {
        DiasRutina dia = diasRutinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DiaRutina no encontrado"));
        return toResponseDto(dia);
    }

    // -------------------------
    // CREATE
    // -------------------------
    @Override
    public DiaRutinaResponse guardar(DiaRutinaRequest dto) {

        Rutina rutina = rutinaRepository.findById(dto.getRutina_id())
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada"));

        DiasRutina dia = new DiasRutina();
        dia.setRutina(rutina);
        dia.setDiaSemana(dto.getDia_semana());
        dia.setOrden(dto.getOrden());

        DiasRutina guardado = diasRutinaRepository.save(dia);
        return toResponseDto(guardado);
    }

    // -------------------------
    // UPDATE
    // -------------------------
    @Override
    public DiaRutinaResponse editar(Long id, DiaRutinaRequest dto) {

        DiasRutina dia = diasRutinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DiaRutina no encontrado"));

        Rutina rutina = rutinaRepository.findById(dto.getRutina_id())
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada"));

        dia.setRutina(rutina);
        dia.setDiaSemana(dto.getDia_semana());
        dia.setOrden(dto.getOrden());

        DiasRutina actualizado = diasRutinaRepository.save(dia);
        return toResponseDto(actualizado);
    }

    // -------------------------
    // DELETE
    // -------------------------
    @Override
    public void eliminar(Long id) {
        diasRutinaRepository.deleteById(id);
    }

    // =========================
    // MAPPER
    // =========================
    private DiaRutinaResponse toResponseDto(DiasRutina dia) {

        DiaRutinaResponse dto = new DiaRutinaResponse();
        dto.setId(dia.getId());
        dto.setRutina_id(dia.getRutina().getId());
        dto.setDia_semana(dia.getDiaSemana()); // 🔥 CAMBIO
        dto.setOrden(dia.getOrden()); // 🔥 NUEVO

        // Mapear RutinaEjercicios
        if (dia.getRutinaEjercicios() != null) { // 🔥 CAMBIO
            List<RutinaEjercicioResponse> ejercicios = dia.getRutinaEjercicios()
                    .stream()
                    .map(this::toRutinaEjercicioResponse)
                    .toList();

            dto.setRutinaEjercicios(ejercicios);
        }

        return dto;
    }

    private RutinaEjercicioResponse toRutinaEjercicioResponse(RutinaEjercicio re) {
        RutinaEjercicioResponse dto = new RutinaEjercicioResponse();

        dto.setId(re.getId());
        dto.setDias_rutina_id(re.getDiasRutina().getId());
        dto.setEjercicio_id(re.getEjercicio().getId());
        dto.setSeries(re.getSeries());
        dto.setRepeticiones(re.getRepeticiones());
        dto.setPeso_objetivo(re.getPeso_objetivo());
        dto.setDescanso_seg(re.getDescanso_seg());

        return dto;
    }
}
