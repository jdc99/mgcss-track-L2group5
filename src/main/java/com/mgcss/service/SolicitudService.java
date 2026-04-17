package com.mgcss.service;

import com.mgcss.domain.repository.SolicitudRepository;
import com.mgcss.domain.repository.TecnicoRepository;

public class SolicitudService {
    private final SolicitudRepository solicitudRepository;
    private final TecnicoRepository tecnicoRepository;

    public SolicitudService(SolicitudRepository solicitud, TecnicoRepository tecnicoRepository) {
        this.solicitudRepository = solicitud;
        this.tecnicoRepository = tecnicoRepository;
    }
}
