package br.com.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

}
