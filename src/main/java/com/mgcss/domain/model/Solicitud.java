package com.mgcss.domain.model;

import java.util.Date;

public class Solicitud {

    private final Long id;
    private Cliente cliente;
    private String descripcion;
    private Date fechaCreacion;
    private EstadoSolicitud estadoSolicitud;
    private Date fechaCierre;
    private Tecnico tecnicoAsignado;

    public Solicitud(Long id, Cliente cliente, String descripcion, Date fechaCreacion, EstadoSolicitud estadoSolicitud, Date fechaCierre) {
        this.id = id;
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.estadoSolicitud = estadoSolicitud;
        this.fechaCierre = fechaCierre;
        tecnicoAsignado = null;
    }

    public void cerrar() {
        if (estadoSolicitud != EstadoSolicitud.EN_PROCESO) {
            throw new IllegalStateException("No se puede cerrar si no esta en proceso.");
        }
        estadoSolicitud = EstadoSolicitud.CERRADA;
    }

    public void asignar(Tecnico tecnicoAsignado) {
        if (!tecnicoAsignado.estaActivo()) {
            throw new IllegalArgumentException("No se puede asignar un tecnico inactivo.");
        }
        this.tecnicoAsignado = tecnicoAsignado;
    }

    public boolean tieneTecnicoAsignado() {
        return false;
    }
}
