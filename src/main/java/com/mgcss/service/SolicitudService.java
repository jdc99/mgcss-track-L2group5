package com.mgcss.service;

import com.mgcss.domain.model.Estado;
import com.mgcss.domain.model.Solicitud;
import com.mgcss.domain.repository.SolicitudRepository;
import com.mgcss.domain.model.Tecnico;

import java.util.Optional;

public class SolicitudService {


    private final SolicitudRepository solicitudRepository;
    //private final TecnicoRepository tecnicoRepository;

    public SolicitudService(SolicitudRepository solicitud)
    {
        this.solicitudRepository = solicitud;
    }

    public Solicitud crearSolicitud(Solicitud solicitud)
    {
        return solicitudRepository.save(solicitud);
    }

    public void cambiarEstado(Long solicitudId, Estado estado)
    {
        Optional<Solicitud> solicitud = solicitudRepository.findById(solicitudId);
        if (solicitud.isEmpty())
        {
            throw new IllegalArgumentException("No existe la solicitud con id " + solicitudId);
        }

        solicitud.get().setEstado(estado);     // lógica delegada al dominio
        solicitudRepository.save(solicitud.orElse(null));
    }

    public void asignarTecnico(Long solicitudId, Tecnico tecnico) {
        Solicitud solicitud = solicitudRepository.findById(solicitudId)
                .orElseThrow(() -> new IllegalArgumentException("No existe la solicitud con id " + solicitudId));
        solicitud.setTecnicoAsignado(tecnico);
        solicitudRepository.save(solicitud);
    }



}
