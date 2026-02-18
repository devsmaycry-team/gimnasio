package com.sistema.base.service_implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.base.DTO.Request.RutinaEjercicioRequest;
import com.sistema.base.DTO.Response.RutinaEjercicioResponse;
import com.sistema.base.model.DiasRutina;
import com.sistema.base.model.Ejercicio;
import com.sistema.base.model.RutinaEjercicio;
import com.sistema.base.repository.DiasRutinaRepository;
import com.sistema.base.repository.EjercicioRepository;
import com.sistema.base.repository.RutinaEjercicioRepository;
import com.sistema.base.service.RutinaEjercicioService;

@Service
public class RutinaEjercicioServiceImplementation implements RutinaEjercicioService {

    @Autowired
    private RutinaEjercicioRepository rutinaEjercicioRepository;

    @Autowired
    private DiasRutinaRepository diasRutinaRepository;

    @Autowired
    private EjercicioRepository ejercicioRepository;

    // =========================
    // GET ALL
    // =========================
    @Override
    public List<RutinaEjercicioResponse> obtenertodos() {
        return rutinaEjercicioRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // =========================
    // GET BY ID
    // =========================
    @Override
    public RutinaEjercicioResponse obtenerPorId(Long id) {
        RutinaEjercicio re = rutinaEjercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RutinaEjercicio no encontrado"));

        return toResponse(re);
    }

    // =========================
    // CREATE
    // =========================
    @Override
    public RutinaEjercicioResponse guardar(RutinaEjercicioRequest dto) {

        DiasRutina diasRutina = diasRutinaRepository.findById(dto.getDias_rutina_id())
                .orElseThrow(() -> new RuntimeException("DiasRutina no encontrado"));

        Ejercicio ejercicio = ejercicioRepository.findById(dto.getEjercicio_id())
                .orElseThrow(() -> new RuntimeException("Ejercicio no encontrado"));

        RutinaEjercicio re = new RutinaEjercicio();
        re.setDiasRutina(diasRutina);
        re.setEjercicio(ejercicio);
        re.setSeries(dto.getSeries());
        re.setRepeticiones(dto.getRepeticiones());
        re.setPeso_objetivo(dto.getPeso_objetivo());
        re.setDescanso_seg(dto.getDescanso_seg());

        RutinaEjercicio guardado = rutinaEjercicioRepository.save(re);

        return toResponse(guardado);
    }

    // =========================
    // UPDATE
    // =========================
    @Override
    public RutinaEjercicioResponse editar(Long id, RutinaEjercicioRequest dto) {

        RutinaEjercicio re = rutinaEjercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RutinaEjercicio no encontrado"));

        DiasRutina diasRutina = diasRutinaRepository.findById(dto.getDias_rutina_id())
                .orElseThrow(() -> new RuntimeException("DiasRutina no encontrado"));

        Ejercicio ejercicio = ejercicioRepository.findById(dto.getEjercicio_id())
                .orElseThrow(() -> new RuntimeException("Ejercicio no encontrado"));

        re.setDiasRutina(diasRutina);
        re.setEjercicio(ejercicio);
        re.setSeries(dto.getSeries());
        re.setRepeticiones(dto.getRepeticiones());
        re.setPeso_objetivo(dto.getPeso_objetivo());
        re.setDescanso_seg(dto.getDescanso_seg());

        RutinaEjercicio actualizado = rutinaEjercicioRepository.save(re);

        return toResponse(actualizado);
    }

    // =========================
    // DELETE
    // =========================
    @Override
    public void eliminar(Long id) {
        rutinaEjercicioRepository.deleteById(id);
    }

    // =========================
    // MAPPER
    // =========================
    private RutinaEjercicioResponse toResponse(RutinaEjercicio re) {

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
}
