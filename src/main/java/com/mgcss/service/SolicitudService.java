package com.mgcss.service;

import com.mgcss.domain.Estado;
import com.mgcss.domain.Solicitud;
import com.mgcss.domain.SolicitudRepository;
import com.mgcss.domain.Tecnico;

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
        Optional<Solicitud> solicitud = solicitudRepository.findById(solicitudId);
        solicitud.get().setTecnicoAsignado(tecnico);
        solicitudRepository.save(solicitud.orElse(null));
    }



}
