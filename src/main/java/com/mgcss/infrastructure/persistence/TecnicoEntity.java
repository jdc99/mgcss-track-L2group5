package com.mgcss.infrastructure.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "Tecnico")
public class TecnicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String especialidad;
    private Boolean activo;

    public TecnicoEntity() {
    }

    public TecnicoEntity(String nombre, String especialidad, Boolean activo)
    {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.activo = activo;
    }

    public Long getId()
    {
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

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setEspecialidad(String especialidad)
    {
        this.especialidad = especialidad;
    }

    public void setActivo(Boolean activo)
    {
        this.activo = activo;
    }
}
