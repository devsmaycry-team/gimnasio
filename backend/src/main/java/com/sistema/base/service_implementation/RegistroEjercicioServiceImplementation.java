package com.sistema.base.service_implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.base.DTO.Request.RegistroEjercicioRequest;
import com.sistema.base.DTO.Response.RegistroEjercicioResponse;
import com.sistema.base.model.Ejercicio;
import com.sistema.base.model.RegistroEjercicio;
import com.sistema.base.model.Rutina;
import com.sistema.base.repository.EjercicioRepository;
import com.sistema.base.repository.RegistroEjercicioRepository;
import com.sistema.base.repository.RutinaRepository;
import com.sistema.base.service.RegistroEjercicioService;

@Service
public class RegistroEjercicioServiceImplementation implements RegistroEjercicioService {

    @Autowired
    private RegistroEjercicioRepository registroRepository;

    @Autowired
    private RutinaRepository rutinaRepository;

    @Autowired
    private EjercicioRepository ejercicioRepository;

    @Override
    public List<RegistroEjercicioResponse> obtenertodos() {
        return registroRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RegistroEjercicioResponse obtenerPorId(Long id) {
        RegistroEjercicio registro = registroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));

        return convertirAResponse(registro);
    }

    @Override
    public RegistroEjercicioResponse guardar(RegistroEjercicioRequest dto) {

        Rutina rutina = rutinaRepository.findById(dto.getRutina_id())
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada"));

        Ejercicio ejercicio = ejercicioRepository.findById(dto.getEjercicio_id())
                .orElseThrow(() -> new RuntimeException("Ejercicio no encontrado"));

        RegistroEjercicio registro = new RegistroEjercicio();
        registro.setRutina(rutina);
        registro.setEjercicio(ejercicio);
        registro.setSeries_hechas(dto.getSeries_hechas());
        registro.setRepeticiones_hechas(dto.getRepeticiones_hechas());
        registro.setPeso_real(dto.getPeso_real());
        registro.setObservacion(dto.getObservacion());

        RegistroEjercicio guardado = registroRepository.save(registro);

        return convertirAResponse(guardado);
    }

    @Override
    public RegistroEjercicioResponse editar(Long id, RegistroEjercicioRequest dto) {

        RegistroEjercicio registro = registroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));

        Rutina rutina = rutinaRepository.findById(dto.getRutina_id())
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada"));

        Ejercicio ejercicio = ejercicioRepository.findById(dto.getEjercicio_id())
                .orElseThrow(() -> new RuntimeException("Ejercicio no encontrado"));

        registro.setRutina(rutina);
        registro.setEjercicio(ejercicio);
        registro.setSeries_hechas(dto.getSeries_hechas());
        registro.setRepeticiones_hechas(dto.getRepeticiones_hechas());
        registro.setPeso_real(dto.getPeso_real());
        registro.setObservacion(dto.getObservacion());

        RegistroEjercicio actualizado = registroRepository.save(registro);

        return convertirAResponse(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        registroRepository.deleteById(id);
    }

    private RegistroEjercicioResponse convertirAResponse(RegistroEjercicio registro) {
        return new RegistroEjercicioResponse(
                registro.getId(),
                registro.getRutina() != null ? registro.getRutina().getId() : null,
                registro.getEjercicio() != null ? registro.getEjercicio().getId() : null,
                registro.getSeries_hechas(),
                registro.getRepeticiones_hechas(),
                registro.getPeso_real(),
                registro.getObservacion()
        );
    }
}
