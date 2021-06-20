package br.com.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.model.Endereco;
import br.com.desafio.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Endereco> listar(){
		return enderecoRepository.findAll();
	}

	public Endereco salvar(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
}
