package br.com.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.model.Telefone;
import br.com.desafio.repository.TelefoneRepository;

@Service
public class TelefoneService {

	@Autowired
	private TelefoneRepository telefoneRepository;
	
	public List<Telefone> listar(){
		return telefoneRepository.findAll();
	}

	public Telefone salvar(Telefone telefone) {
		return telefoneRepository.save(telefone);
	}
	
}
