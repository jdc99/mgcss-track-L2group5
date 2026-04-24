package com.mgcss.domain.repository;

import com.mgcss.domain.model.Cliente;

import java.util.Optional;

public interface ClienteRepository {
    Cliente save(Cliente cliente);
    Optional<Cliente> findById(Long id);
}
