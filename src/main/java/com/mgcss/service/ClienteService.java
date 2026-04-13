package com.mgcss.service;

import com.mgcss.domain.model.Cliente;
import com.mgcss.domain.model.TipoCliente;
import com.mgcss.domain.repository.ClienteRepository;

import java.util.Optional;

public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void upgradeAPremium(Long clienteId) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(clienteId);

        if (clienteOpt.isEmpty()) {
            throw new IllegalArgumentException("No existe el cliente con id " + clienteId);
        }

        Cliente cliente = clienteOpt.get();

        if (cliente.getTipoCliente() == TipoCliente.PREMIUM) {
            throw new IllegalStateException("El cliente ya tiene categoría PREMIUM.");
        }


        cliente.modificarDatos(cliente.getNombre(), cliente.getEmail(), TipoCliente.PREMIUM);

        clienteRepository.save(cliente);
    }
}
