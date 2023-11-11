package com.example.livraria.repositories;

import com.example.livraria.domain.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

    List<Cliente> findByName(String name);

}
