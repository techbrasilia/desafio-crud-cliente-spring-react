package br.com.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
