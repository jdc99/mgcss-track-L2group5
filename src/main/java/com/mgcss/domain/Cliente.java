package com.mgcss.domain;

public class Cliente {

    private final Long id;
    private String nombre;
    private String email;
    private TipoCliente tipoCliente;

    public Cliente(String nombre, String email, TipoCliente tipoCliente) {
        this.nombre = nombre;
        this.email = email;
        this.tipoCliente = tipoCliente;

        id = System.currentTimeMillis();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void modificarDatos(String nombre, String email, TipoCliente telefono)
    {
        this.nombre = nombre;
        this.email = email;
        this.tipoCliente = telefono;
    }

    // @TODO
    public Cliente consultarCliente(Long id)
    {
        return this;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono=" + tipoCliente +
                '}';
    }
}
