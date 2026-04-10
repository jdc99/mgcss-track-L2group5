package com.mgcss.domain;

import java.util.Date;
import java.util.Random;

public class Solicitud {
    private final Long id;
    private Cliente cliente;
    private String descripcion;
    private Estado estado;
    private Tecnico tecnicoAsignado;
    private Date fechaCreacion;
    private Date fechaCierre;


    public Solicitud(Cliente cliente, String descripcion, Estado estado, Tecnico tecnicoAsignado, Date fechaCreacion, Date fechaCierre) {
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tecnicoAsignado = tecnicoAsignado;
        this.fechaCreacion = fechaCreacion;
        this.fechaCierre = fechaCierre;

        id = new Random().nextLong();
    }

    public Solicitud() {
        id = new Random().nextLong();
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Tecnico getTecnicoAsignado() {
        return tecnicoAsignado;
    }

    public Boolean setTecnicoAsignado(Tecnico tecnicoAsignado) {
        if(tecnicoAsignado.getActivo())
        {this.tecnicoAsignado = tecnicoAsignado;
        return true;}
        else {
            return false;
        }
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public static boolean differentIds(Solicitud solicitud1, Solicitud solicitud2) {
        return solicitud1.id.equals(solicitud2.id);
    }
    // este comentario no sirve para nada
}
