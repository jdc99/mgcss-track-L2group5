package com.mgcss.unit.domain.model;

import com.mgcss.domain.model.Tecnico;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TecnicoTest {

    @Test
    void crearTecnicoConDatosValidos() {
        Long id = 1L;
        String nombre = "Juan Tecnico";
        String especialidad = "Electricidad";
        boolean activo = true;

        Tecnico tecnico = new Tecnico(id, nombre, especialidad, activo);

        assertNotNull(tecnico);
        assertTrue(tecnico.estaActivo());
    }

    @Test
    void crearTecnicoInactivo() {
        Tecnico tecnico = new Tecnico(2L, "Maria Sanchez", "Plomeria", false);

        assertNotNull(tecnico);
        assertFalse(tecnico.estaActivo());
    }

    @Test
    void consultarTecnicoDevuelveFormatoCorrecto() {
        Tecnico tecnico = new Tecnico(1L, "Carlos Ruiz", "Carpinteria", true);

        String resultado = tecnico.consultarTecnico();

        assertTrue(resultado.contains("id=1"));
        assertTrue(resultado.contains("nombre='Carlos Ruiz'"));
        assertTrue(resultado.contains("especialidad='Carpinteria'"));
        assertTrue(resultado.contains("activo=true"));
        assertTrue(resultado.startsWith("Tecnico{"));
        assertTrue(resultado.endsWith("}"));
    }

    @Test
    void consultarTecnicoMuestraEstadoInactivo() {
        Tecnico tecnico = new Tecnico(2L, "Luis Perez", "Pintura", false);

        String resultado = tecnico.consultarTecnico();

        assertTrue(resultado.contains("activo=false"));
    }

    @Test
    void tecnicoActivoDevuelveTrue() {
        Tecnico tecnico = new Tecnico(1L, "Ana Gomez", "Soldadura", true);
        assertTrue(tecnico.estaActivo());
    }

    @Test
    void tecnicoInactivoDevuelveFalse() {
        Tecnico tecnico = new Tecnico(2L, "Pedro Diaz", "Albañileria", false);
        assertFalse(tecnico.estaActivo());
    }

    @Test
    void tecnicoConDiferentesEspecialidades() {
        Tecnico tecnico1 = new Tecnico(1L, "Juan", "Electricidad", true);
        Tecnico tecnico2 = new Tecnico(2L, "Maria", "Plomeria", true);
        Tecnico tecnico3 = new Tecnico(3L, "Carlos", "Carpinteria", true);

        assertTrue(tecnico1.consultarTecnico().contains("Electricidad"));
        assertTrue(tecnico2.consultarTecnico().contains("Plomeria"));
        assertTrue(tecnico3.consultarTecnico().contains("Carpinteria"));
    }

    @Test
    void tecnicoConIdUnico() {
        Tecnico tecnico1 = new Tecnico(1L, "Juan", "Electricidad", true);
        Tecnico tecnico2 = new Tecnico(2L, "Maria", "Plomeria", true);

        String resultado1 = tecnico1.consultarTecnico();
        String resultado2 = tecnico2.consultarTecnico();

        assertTrue(resultado1.contains("id=1"));
        assertTrue(resultado2.contains("id=2"));
        assertNotEquals(resultado1, resultado2);
    }
}