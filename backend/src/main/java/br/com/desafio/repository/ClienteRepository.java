package br.com.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
