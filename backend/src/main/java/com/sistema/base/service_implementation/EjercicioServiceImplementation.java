package com.sistema.base.service_implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.base.DTO.Request.EjercicioRequest;
import com.sistema.base.DTO.Response.EjercicioResponse;
import com.sistema.base.DTO.Response.RegistroEjercicioResponse;
import com.sistema.base.DTO.Response.RutinaEjercicioResponse;
import com.sistema.base.model.Ejercicio;
import com.sistema.base.model.RegistroEjercicio;
import com.sistema.base.model.RutinaEjercicio;
import com.sistema.base.repository.EjercicioRepository;
import com.sistema.base.service.EjercicioService;

@Service
public class EjercicioServiceImplementation implements EjercicioService {

    @Autowired
    private EjercicioRepository ejercicioRepository;

    // =========================
    // GET ALL
    // =========================
    @Override
    public List<EjercicioResponse> obtenerTodos() {
        return ejercicioRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    // =========================
    // GET BY ID
    // =========================
    @Override
    public EjercicioResponse obtenerPorId(Long id) {
        Ejercicio ejercicio = ejercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ejercicio no encontrado"));

        return toResponseDto(ejercicio);
    }

    // =========================
    // CREATE
    // =========================
    @Override
    public EjercicioResponse guardar(EjercicioRequest request) {
        Ejercicio ejercicio = new Ejercicio();

        // ⚠️ si usas nombre, agregalo al DTO
        // ejercicio.setNombre(request.getNombre());

        ejercicio.setGrupo_muscular(request.getGrupo_muscular());
        ejercicio.setEquipo(request.getEquipo());
        ejercicio.setImagen_url(request.getImagen_url());
        ejercicio.setVideo_url(request.getVideo_url());

        Ejercicio guardado = ejercicioRepository.save(ejercicio);

        return toResponseDto(guardado);
    }

    // =========================
    // UPDATE
    // =========================
    @Override
    public EjercicioResponse editar(Long id, EjercicioRequest request) {
        Ejercicio ejercicio = ejercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ejercicio no encontrado"));

        // ejercicio.setNombre(request.getNombre());

        ejercicio.setGrupo_muscular(request.getGrupo_muscular());
        ejercicio.setEquipo(request.getEquipo());
        ejercicio.setImagen_url(request.getImagen_url());
        ejercicio.setVideo_url(request.getVideo_url());

        Ejercicio actualizado = ejercicioRepository.save(ejercicio);

        return toResponseDto(actualizado);
    }

    // =========================
    // DELETE
    // =========================
    @Override
    public void eliminar(Long id) {
        if (!ejercicioRepository.existsById(id)) {
            throw new RuntimeException("Ejercicio no encontrado");
        }
        ejercicioRepository.deleteById(id);
    }

    // =========================
    // MAPPER PRINCIPAL
    // =========================
    private EjercicioResponse toResponseDto(Ejercicio ejercicio) {
        EjercicioResponse dto = new EjercicioResponse();

        dto.setId(ejercicio.getId());

        // ⚠️ diferencia de nombres
        dto.setGrupo_mucular(ejercicio.getGrupo_muscular());

        dto.setEquipo(ejercicio.getEquipo());
        dto.setImagen_url(ejercicio.getImagen_url());
        dto.setVideo_url(ejercicio.getVideo_url());

        // =========================
        // RutinaEjercicios
        // =========================
        if (ejercicio.getRutinaEjercicios() != null) {
            dto.setRutinaEjercicios(
                    ejercicio.getRutinaEjercicios()
                            .stream()
                            .map(this::toRutinaEjercicioDto)
                            .collect(Collectors.toList())
            );
        }

        // =========================
        // RegistroEjercicios
        // =========================
        if (ejercicio.getRegistroEjercicios() != null) {
            dto.setRegistroEjercicios(
                    ejercicio.getRegistroEjercicios()
                            .stream()
                            .map(this::toRegistroEjercicioDto)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }

    // =========================
    // MAPPER RutinaEjercicio
    // =========================
    private RutinaEjercicioResponse toRutinaEjercicioDto(RutinaEjercicio re) {
        RutinaEjercicioResponse dto = new RutinaEjercicioResponse();

        dto.setId(re.getId());

        dto.setDias_rutina_id(
                re.getDiasRutina() != null ? re.getDiasRutina().getId() : null
        );

        dto.setEjercicio_id(
                re.getEjercicio() != null ? re.getEjercicio().getId() : null
        );

        dto.setSeries(re.getSeries());
        dto.setRepeticiones(re.getRepeticiones());
        dto.setPeso_objetivo(re.getPeso_objetivo());
        dto.setDescanso_seg(re.getDescanso_seg());

        return dto;
    }

    // =========================
    // MAPPER RegistroEjercicio
    // =========================
    private RegistroEjercicioResponse toRegistroEjercicioDto(RegistroEjercicio reg) {
        RegistroEjercicioResponse dto = new RegistroEjercicioResponse();

        dto.setId(reg.getId());

        dto.setRutina_id(
                reg.getRutina() != null ? reg.getRutina().getId() : null
        );

        dto.setEjercicio_id(
                reg.getEjercicio() != null ? reg.getEjercicio().getId() : null
        );

        dto.setSeries_hechas(reg.getSeries_hechas());


        dto.setRepeticiones_hechas(reg.getRepeticiones_hechas());

        dto.setPeso_real(reg.getPeso_real());
        dto.setObservacion(reg.getObservacion());

        return dto;
    }
}
