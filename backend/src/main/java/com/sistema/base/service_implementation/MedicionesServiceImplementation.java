package com.sistema.base.service_implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.base.DTO.Request.MedicionesRequest;
import com.sistema.base.DTO.Response.MedicionesResponse;
import com.sistema.base.model.Mediciones;
import com.sistema.base.model.Socio;
import com.sistema.base.repository.MedicionesRepository;
import com.sistema.base.repository.SocioRepository;
import com.sistema.base.service.MedicionesService;

@Service
public class MedicionesServiceImplementation implements MedicionesService {

    @Autowired
    private MedicionesRepository medicionesRepository;

    @Autowired
    private SocioRepository socioRepository;

    // =========================
    // GET ALL
    // =========================
    @Override
    public List<MedicionesResponse> obtenertodos() {
        return medicionesRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    // =========================
    // GET BY ID
    // =========================
    @Override
    public MedicionesResponse obtenerPorId(Long id) {
        Mediciones medicion = medicionesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medición no encontrada"));

        return toResponseDto(medicion);
    }

    // =========================
    // CREATE
    // =========================
    @Override
    public MedicionesResponse guardar(MedicionesRequest request) {

        Socio socio = socioRepository.findById(request.getSocio_id())
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        Mediciones medicion = new Mediciones();
        medicion.setSocio(socio);
        medicion.setFecha(request.getFecha());
        medicion.setPeso(request.getPeso());
        medicion.setGrasa_corporal(request.getGrasa_corporal());
        medicion.setPecho(request.getPecho());
        medicion.setBrazos(request.getBrazos());

        Mediciones guardado = medicionesRepository.save(medicion);

        return toResponseDto(guardado);
    }

    // =========================
    // UPDATE
    // =========================
    @Override
    public MedicionesResponse editar(Long id, MedicionesRequest request) {

        Mediciones medicion = medicionesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medición no encontrada"));

        if (request.getSocio_id() != null) {
            Socio socio = socioRepository.findById(request.getSocio_id())
                    .orElseThrow(() -> new RuntimeException("Socio no encontrado"));
            medicion.setSocio(socio);
        }

        medicion.setFecha(request.getFecha());
        medicion.setPeso(request.getPeso());
        medicion.setGrasa_corporal(request.getGrasa_corporal());
        medicion.setPecho(request.getPecho());
        medicion.setBrazos(request.getBrazos());

        Mediciones actualizado = medicionesRepository.save(medicion);

        return toResponseDto(actualizado);
    }

    // =========================
    // DELETE
    // =========================
    @Override
    public void eliminar(Long id) {
        if (!medicionesRepository.existsById(id)) {
            throw new RuntimeException("Medición no encontrada");
        }
        medicionesRepository.deleteById(id);
    }

    // =========================
    // MAPPER
    // =========================
    private MedicionesResponse toResponseDto(Mediciones medicion) {

        MedicionesResponse dto = new MedicionesResponse();

        dto.setId(medicion.getId());

        dto.setSocio_id(
                medicion.getSocio() != null ? medicion.getSocio().getId() : null
        );

        dto.setFecha(medicion.getFecha());
        dto.setPeso(medicion.getPeso());
        dto.setGrasa_corporal(medicion.getGrasa_corporal());
        dto.setPecho(medicion.getPecho());
        dto.setBrazos(medicion.getBrazos());

        return dto;
    }
}
