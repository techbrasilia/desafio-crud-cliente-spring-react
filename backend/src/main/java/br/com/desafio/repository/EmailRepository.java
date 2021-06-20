package br.com.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.model.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {

}
