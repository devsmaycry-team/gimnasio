package com.sistema.base.service_implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.base.DTO.Request.AsistenciaRequest;
import com.sistema.base.DTO.Response.AsistenciaResponse;
import com.sistema.base.model.Asistencias;
import com.sistema.base.model.Socio;
import com.sistema.base.repository.AsistenciaRepository;
import com.sistema.base.repository.SocioRepository;
import com.sistema.base.service.AsistenciasService;


//===================
//aca se usan metodos de respuesta y guardado usando DTO request y DTO response, juntos a la entidad
//===================
@Service
public class AsistenciaServiceImplementation implements AsistenciasService{
    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @Autowired
    private SocioRepository socioRepository;

    // -------------------------
    // GET ALL
    // -------------------------
    @Override
    public List<AsistenciaResponse> obtenerTodos() {
        return asistenciaRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    // -------------------------
    // GET BY ID
    // -------------------------
    @Override
    public AsistenciaResponse obtenerPorId(Long id) {
        Asistencias asistencia = asistenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asistencia no encontrada"));
        return toResponseDto(asistencia);
    }

    // -------------------------
    // CREATE
    // -------------------------
    @Override
    public AsistenciaResponse guardar(AsistenciaRequest dto) {

        Socio socio = socioRepository.findById(dto.getSocio_id())
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        Asistencias asistencia = new Asistencias();
        asistencia.setSocio(socio);
        asistencia.setTipo(dto.getTipo());

        // LocalDate → LocalDateTime
        asistencia.setFecha_hora(dto.getFecha_hora().atStartOfDay());

        Asistencias guardada = asistenciaRepository.save(asistencia);
        return toResponseDto(guardada);
    }

    // -------------------------
    // UPDATE
    // -------------------------
    @Override
    public AsistenciaResponse editar(Long id, AsistenciaRequest dto) {

        Asistencias asistencia = asistenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asistencia no encontrada"));

        Socio socio = socioRepository.findById(dto.getSocio_id())
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        asistencia.setSocio(socio);
        asistencia.setTipo(dto.getTipo());
        asistencia.setFecha_hora(dto.getFecha_hora().atStartOfDay());

        Asistencias actualizada = asistenciaRepository.save(asistencia);
        return toResponseDto(actualizada);
    }

    // -------------------------
    // DELETE
    // -------------------------
    @Override
    public void eliminar(Long id) {
        asistenciaRepository.deleteById(id);
    }

    // =========================
    // MAPPERS
    // =========================

    private AsistenciaResponse toResponseDto(Asistencias asistencia) {
        AsistenciaResponse dto = new AsistenciaResponse();
        dto.setId(asistencia.getId());
        dto.setSocioId(asistencia.getSocio().getId());
        dto.setTipo(asistencia.getTipo());
        dto.setFechaHora(asistencia.getFecha_hora());
        return dto;
    }
}
