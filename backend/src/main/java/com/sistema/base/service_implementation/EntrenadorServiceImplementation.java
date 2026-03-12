package com.sistema.base.service_implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.base.DTO.Request.EntrenadorRequest;
import com.sistema.base.DTO.Response.EntrenadorResponse;
import com.sistema.base.DTO.Response.RutinaResponse;
import com.sistema.base.model.Entrenador;
import com.sistema.base.model.Gimnasio;
import com.sistema.base.model.Rutina;
import com.sistema.base.model.Usuario;
import com.sistema.base.repository.EntrenadorRepository;
import com.sistema.base.repository.GimnasioRepository;
import com.sistema.base.repository.UsuarioRepository;
import com.sistema.base.service.EntrenadorService;

@Service
public class EntrenadorServiceImplementation implements EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private GimnasioRepository gimnasioRepository;
    // =========================
    // GET ALL
    // =========================
    @Override
    public List<EntrenadorResponse> obtenerTodos() {
        return entrenadorRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    // =========================
    // GET BY ID
    // =========================
    @Override
    public EntrenadorResponse obtenerPorId(Long id) {
        Entrenador entrenador = entrenadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));

        return toResponseDto(entrenador);
    }

    // =========================
    // CREATE
    // =========================
    @Override
    public EntrenadorResponse guardar(EntrenadorRequest request) {

        Usuario usuario = usuarioRepository.findById(request.getUsuario_id())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Gimnasio gimnasio = gimnasioRepository.findById(request.getGimnasio_id())
            .orElseThrow(() -> new RuntimeException("gimnasio no encontrado"));
        Entrenador entrenador = new Entrenador();
        entrenador.setUsuario(usuario);
        entrenador.setEspecialidad(request.getEspecialidad());
        entrenador.setMatricula(request.getMatricula());
        entrenador.setGimnasio(gimnasio);
        Entrenador guardado = entrenadorRepository.save(entrenador);

        return toResponseDto(guardado);
    }

    // =========================
    // UPDATE
    // =========================
    @Override
    public EntrenadorResponse editar(Long id, EntrenadorRequest request) {

        Entrenador entrenador = entrenadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));
        Gimnasio gimnasio = gimnasioRepository.findById(request.getGimnasio_id())
            .orElseThrow(() -> new RuntimeException("gimnasio no encontrado"));
        if (request.getUsuario_id() != null) {
            Usuario usuario = usuarioRepository.findById(request.getUsuario_id())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            entrenador.setUsuario(usuario);
        }
        entrenador.setGimnasio(gimnasio);
        entrenador.setEspecialidad(request.getEspecialidad());
        entrenador.setMatricula(request.getMatricula());

        Entrenador actualizado = entrenadorRepository.save(entrenador);

        return toResponseDto(actualizado);
    }

    // =========================
    // DELETE
    // =========================
    @Override
    public void eliminar(Long id) {
        if (!entrenadorRepository.existsById(id)) {
            throw new RuntimeException("Entrenador no encontrado");
        }
        entrenadorRepository.deleteById(id);
    }

    // =========================
    // MAPPER PRINCIPAL
    // =========================
    private EntrenadorResponse toResponseDto(Entrenador entrenador) {

        EntrenadorResponse dto = new EntrenadorResponse();

        dto.setId(entrenador.getId());

        dto.setUsuario_id(
                entrenador.getUsuario() != null ? entrenador.getUsuario().getId() : null
        );
        dto.setGimnasio_id(entrenador.getGimnasio().getId());
        dto.setEspecialidad(entrenador.getEspecialidad());
        dto.setMatricula(entrenador.getMatricula());

        // Rutinas
        if (entrenador.getRutinas() != null) {
            dto.setRutinas(
                entrenador.getRutinas()
                        .stream()
                        .map(this::toRutinaDto)
                        .collect(Collectors.toList())
            );
        }

        return dto;
    }

    private RutinaResponse toRutinaDto(Rutina rutina) {

        RutinaResponse dto = new RutinaResponse();

        dto.setId(rutina.getId());


        dto.setEntrenador_id(
            rutina.getEntrenador() != null
                ? rutina.getEntrenador().getId()
                : null
);

        dto.setNombre(rutina.getNombre());
        dto.setObjetivo(rutina.getObjetivo());
        dto.setNivel(rutina.getNivel());
        dto.setDuracion_semanas(rutina.getDuracion_semanas());
        dto.setEstado(rutina.isEstado());
        dto.setEditable(rutina.isEditable());
        
        return dto;
    }
}
