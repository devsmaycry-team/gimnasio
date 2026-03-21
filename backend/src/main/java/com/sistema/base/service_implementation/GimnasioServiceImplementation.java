package com.sistema.base.service_implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.base.DTO.Request.GimnasioRequest;
import com.sistema.base.DTO.Response.GimnasioResponse;
import com.sistema.base.model.Gimnasio;
import com.sistema.base.repository.GimnasioRepository;
import com.sistema.base.service.GimnasioService;

@Service
public class GimnasioServiceImplementation implements GimnasioService {

    @Autowired
    private GimnasioRepository gimnasioRepository;

    // =========================
    // GET ALL
    // =========================
    @Override
    public List<GimnasioResponse> obtenerTodos() {
        return gimnasioRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    // =========================
    // GET BY ID
    // =========================
    @Override
    public GimnasioResponse obtenerPorId(Long id) {

        Gimnasio gimnasio = gimnasioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gimnasio no encontrado"));

        return toResponseDto(gimnasio);
    }

    // =========================
    // CREATE
    // =========================
    @Override
    public GimnasioResponse guardar(GimnasioRequest request) {

        Gimnasio gimnasio = new Gimnasio();

        gimnasio.setNombre(request.getNombre());
        gimnasio.setDireccion(request.getDireccion());
        gimnasio.setTelefono(request.getTelefono());
        gimnasio.setEmail(request.getEmail());
        gimnasio.setCodigo_gym(request.getCodigoGym());

        Gimnasio guardado = gimnasioRepository.save(gimnasio);

        return toResponseDto(guardado);
    }

    // =========================
    // UPDATE
    // =========================
    @Override
    public GimnasioResponse editar(Long id, GimnasioRequest request) {

        Gimnasio gimnasio = gimnasioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gimnasio no encontrado"));

        gimnasio.setNombre(request.getNombre());
        gimnasio.setDireccion(request.getDireccion());
        gimnasio.setTelefono(request.getTelefono());
        gimnasio.setEmail(request.getEmail());
        gimnasio.setCodigo_gym(request.getCodigoGym());

        Gimnasio actualizado = gimnasioRepository.save(gimnasio);

        return toResponseDto(actualizado);
    }

    // =========================
    // DELETE
    // =========================
    @Override
    public void eliminar(Long id) {

        if (!gimnasioRepository.existsById(id)) {
            throw new RuntimeException("Gimnasio no encontrado");
        }

        gimnasioRepository.deleteById(id);
    }

    // =========================
    // MAPPER
    // =========================
    private GimnasioResponse toResponseDto(Gimnasio gimnasio) {

        GimnasioResponse dto = new GimnasioResponse();

        dto.setId(gimnasio.getId());
        dto.setNombre(gimnasio.getNombre());
        dto.setDireccion(gimnasio.getDireccion());
        dto.setTelefono(gimnasio.getTelefono());
        dto.setEmail(gimnasio.getEmail());
        dto.setCodigoGym(gimnasio.getCodigo_gym());

        return dto;
    }
}