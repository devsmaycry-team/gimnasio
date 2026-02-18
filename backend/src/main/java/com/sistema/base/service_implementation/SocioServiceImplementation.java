package com.sistema.base.service_implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sistema.base.DTO.Request.SocioRequest;
import com.sistema.base.DTO.Response.SocioResponse;
import com.sistema.base.model.Socio;
import com.sistema.base.model.Usuario;
import com.sistema.base.repository.SocioRepository;
import com.sistema.base.repository.UsuarioRepository;
import com.sistema.base.service.SocioService;

@Service
public class SocioServiceImplementation implements SocioService {

    private final SocioRepository socioRepository;
    private final UsuarioRepository usuarioRepository;

    public SocioServiceImplementation(SocioRepository socioRepository, UsuarioRepository usuarioRepository) {
        this.socioRepository = socioRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<SocioResponse> obtenertodos() {
        return socioRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SocioResponse obtenerPorId(Long id) {
        Socio socio = socioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));
        return mapToResponse(socio);
    }

    @Override
    public SocioResponse guardar(SocioRequest dto) {
        Socio socio = new Socio();

        Usuario usuario = usuarioRepository.findById(dto.getUsuario_id())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        socio.setUsuario(usuario);
        socio.setNumero_socio(dto.getNumero_socio());
        socio.setObservacionMedica(dto.getObservacionMedica());

        Socio guardado = socioRepository.save(socio);
        return mapToResponse(guardado);
    }

    @Override
    public void eliminar(Long id) {
        if (!socioRepository.existsById(id)) {
            throw new RuntimeException("Socio no encontrado");
        }
        socioRepository.deleteById(id);
    }

    @Override
    public SocioResponse editar(Long id, SocioRequest dto) {
        Socio socio = socioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        Usuario usuario = usuarioRepository.findById(dto.getUsuario_id())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        socio.setUsuario(usuario);
        socio.setNumero_socio(dto.getNumero_socio());
        socio.setObservacionMedica(dto.getObservacionMedica());

        Socio actualizado = socioRepository.save(socio);
        return mapToResponse(actualizado);
    }

    private SocioResponse mapToResponse(Socio socio) {
        return new SocioResponse(
                socio.getId(),
                null, // mediciones
                null, // membresias
                null, // pagos
                null, // asistencias
                null, // inscripciones
                socio.getUsuario() != null ? socio.getUsuario().getId() : null,
                socio.getNumero_socio(),
                socio.getObservacionMedica()
        );
    }
}
