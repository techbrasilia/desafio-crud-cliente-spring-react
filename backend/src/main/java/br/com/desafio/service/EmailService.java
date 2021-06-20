package br.com.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.model.Email;
import br.com.desafio.repository.EmailRepository;

@Service
public class EmailService {

	@Autowired
	private EmailRepository emailRepository;
	
	public List<Email> listar(){
		return emailRepository.findAll();
	}

	public Email salvar(Email email) {
		return emailRepository.save(email);
	}
	
}
