package br.com.desafio.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import br.com.desafio.model.Cliente;
import br.com.desafio.model.Email;
import br.com.desafio.model.Endereco;
import br.com.desafio.model.Telefone;
import br.com.desafio.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private TelefoneService telefoneService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<Cliente> listar(){
		return clienteRepository.findAll();
	}

	public Cliente getCliente(Long id) {
		return clienteRepository.findById(id).orElseThrow(()-> new EntityNotFoundException());
	}
	
	public Cliente salvar(Cliente cliente) {
		Endereco endereco = mapper.map(cliente.getEndereco(), Endereco.class);
		
		cliente.setEndereco(null);
		Cliente entidade = clienteRepository.save(cliente);
		
		endereco.setCliente(entidade);
		enderecoService.salvar(endereco);
		entidade.setEndereco(endereco);
		
		salvarTelefone(entidade, cliente.getTelefones());
		salvarEmail(cliente, cliente.getEmails());
		return entidade;
	}
	
	private void salvarTelefone(Cliente cliente, List<Telefone> telefones) {
		if(!CollectionUtils.isEmpty(telefones)) {
			telefones.stream().forEach(telefone -> {
				telefone.setCliente(cliente);
				telefoneService.salvar(telefone);			
			});			
		}
		
	}
	
	private void salvarEmail(Cliente cliente, List<Email> emails) {
		if(!CollectionUtils.isEmpty(emails)) {
			emails.stream().forEach(email -> {
				email.setCliente(cliente);
				emailService.salvar(email);			
			});
		}
		
	}
	
	public Cliente alterar(Long id, Cliente cliente) {
		
		Cliente clienteAlterado = getCliente(id);
		if(clienteAlterado != null) {
//			cliente.setId(id);
			clienteAlterado = mapper.map(cliente, Cliente.class);
			return salvar(clienteAlterado);
		}
		return clienteRepository.save(cliente);
	}
	
}
