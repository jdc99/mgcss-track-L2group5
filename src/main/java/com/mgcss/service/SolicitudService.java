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

    public void asignarTecnico(long l, long l1) {
        /* TODO: obtener instancias a traves de los repositorios por sus
            id's y llamar a asignar(tecnico) guardando finalmente el estado */
    }
}
