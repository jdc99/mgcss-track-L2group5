package com.mgcss.infrastructure.persistence;


import com.mgcss.domain.model.TipoCliente;
import jakarta.persistence.*;


@Entity
@Table(name = "Cliente")
public class ClienteEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente;


    public ClienteEntity()
    {

    }
    public ClienteEntity(String nombre, String email, TipoCliente tipoCliente)
    {
        this.nombre = nombre;
        this.email = email;
        this.tipoCliente = tipoCliente;
    }



    public Long getId()
    {
        return id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getEmail()
    {
        return email;
    }

    public TipoCliente getTipoCliente()
    {
        return tipoCliente;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setTipoCliente(TipoCliente tipoCliente)
    {
        this.tipoCliente = tipoCliente;
    }

    public void modificarDatos(String nombre, String email, TipoCliente tipoCliente)
    {
        this.nombre = nombre;
        this.email = email;
        this.tipoCliente = tipoCliente;
    }


    public ClienteEntity consultarCliente(Long id)
    {
        return this;
    }

    @Override
    public String toString()
    {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono=" + tipoCliente +
                '}';
    }
}
