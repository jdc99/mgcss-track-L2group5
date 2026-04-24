package com.mgcss.unit.domain.model;

import com.mgcss.domain.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void modificarDatosClienteActualizaCampos() {
        Cliente cliente = new Cliente(1L, "Original", "original@mail.com", TipoCliente.STANDARD);

        cliente.modificarDatosCliente("Modificado", "modificado@mail.com", TipoCliente.PREMIUM);

        String resultado = cliente.consultarCliente();
        assertTrue(resultado.contains("nombre='Modificado'"));
        assertTrue(resultado.contains("email='modificado@mail.com'"));
        assertTrue(resultado.contains("tipoCliente=PREMIUM"));
    }

    @Test
    void consultarClienteDevuelveTodosLosDatos() {
        Cliente cliente = new Cliente(1L, "Carlos Ruiz", "carlos@mail.com", TipoCliente.STANDARD);

        String resultado = cliente.consultarCliente();

        assertNotNull(resultado);
        assertTrue(resultado.startsWith("Cliente{"));
        assertTrue(resultado.endsWith("}"));
    }

    @Test
    void modificarDatosClienteMantieneIdOriginal() {
        Cliente cliente = new Cliente(99L, "Original", "original@mail.com", TipoCliente.STANDARD);

        String antes = cliente.consultarCliente();
        cliente.modificarDatosCliente("Nuevo", "nuevo@mail.com", TipoCliente.PREMIUM);
        String despues = cliente.consultarCliente();

        assertTrue(antes.contains("id=99"));
        assertTrue(despues.contains("id=99"));
    }
}