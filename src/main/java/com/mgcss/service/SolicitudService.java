package com.mgcss.service;

import com.mgcss.domain.model.Solicitud;
import com.mgcss.domain.model.Tecnico;
import com.mgcss.domain.repository.SolicitudRepository;
import com.mgcss.domain.repository.TecnicoRepository;

public class SolicitudService {
    private final SolicitudRepository solicitudRepository;
    private final TecnicoRepository tecnicoRepository;

    public SolicitudService(SolicitudRepository solicitud, TecnicoRepository tecnicoRepository) {
        this.solicitudRepository = solicitud;
        this.tecnicoRepository = tecnicoRepository;
    }

    public void asignarTecnico(Long solicitudId, Long tecnicoId) {
        /* TODO: implementacion minima, debe contemplarse si no se encuentra el Id en el repo */
        Solicitud solicitud = solicitudRepository.findById(solicitudId).get();
        Tecnico  tecnico = tecnicoRepository.findById(tecnicoId).get();

        solicitud.asignar(tecnico);
        solicitudRepository.save(solicitud);
    }
}
