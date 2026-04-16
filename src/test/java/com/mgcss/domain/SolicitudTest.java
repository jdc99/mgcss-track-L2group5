package com.mgcss.domain;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class SolicitudTest {

    @Test
    void cierreSolicitudRequiereEstadoEnProceso() {
        Solicitud solicitud = new Solicitud(1L,
                new Cliente(1L, "", "@", TipoCliente.STANDARD),
                "",
                Date.from(Instant.now()),
                EstadoSolicitud.ABIERTA,
                null);
        assertThrows(IllegalStateException.class, solicitud::cerrar);
    }

    @Test
    void asignarTecnicoEstaPermitido() {
        Solicitud solicitud = new Solicitud(1L,
                new Cliente(1L, "", "@", TipoCliente.PREMIUM),
                "",
                Date.from(Instant.now()),
                EstadoSolicitud.ABIERTA,
                null);
        Tecnico tecnicoActivo = new Tecnico(1L, "", "", true);
        assertDoesNotThrow(() -> solicitud.asignar(tecnicoActivo));
    }

    @Test
    void asignarTecnicoInactivoNoEstaPermitido() {
        Solicitud solicitud = new Solicitud(1L,
                new Cliente(1L, "", "@", TipoCliente.PREMIUM),
                "",
                Date.from(Instant.now()),
                EstadoSolicitud.ABIERTA,
                null);
        Tecnico tecnicoInactivo = new Tecnico(2L, "", "", false);
        assertThrows(IllegalArgumentException.class, () -> solicitud.asignar(tecnicoInactivo));
    }
}