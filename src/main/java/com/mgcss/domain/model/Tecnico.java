package com.mgcss.domain.model;

public class Tecnico {

    private final Long id;
    private final String nombre;
    private final String especialidad;
    private Boolean activo;

    public Tecnico(String nombre, String email, Boolean activo) {
        this.nombre = nombre;
        this.especialidad = email;
        this.activo = activo;

        id = System.currentTimeMillis();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public Boolean getActivo() {
        return activo;
    }


    public void activar()
    {
        activo = !activo;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", activo=" + activo +
                '}';
    }
}
