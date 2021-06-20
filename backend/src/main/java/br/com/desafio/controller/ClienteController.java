package br.com.desafio.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.dto.ClienteDTO;
import br.com.desafio.model.Cliente;
import br.com.desafio.service.ClienteService;

@RestController
@RequestMapping("/clientes")
@Validated
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	public List<ClienteDTO> listar(){
		
		List<Cliente> clientes = clienteService.listar();
		
		List<ClienteDTO> response = clientes.stream()
				.map((cliente)-> {
					return mapper.map(cliente, ClienteDTO.class);
				}).collect(Collectors.toList());
		return response;
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteDTO salvar(@RequestBody @Valid ClienteDTO clienteDTO) {
		Cliente cliente = mapper.map(clienteDTO, Cliente.class);
		Cliente entidade = clienteService.salvar(cliente);
		ClienteDTO response = mapper.map(entidade, ClienteDTO.class);
		
		return response;
	}
	
	@GetMapping("{id}")
	public ClienteDTO getCurso(@PathVariable Long id) {
		Cliente cliente =  clienteService.getCliente(id);
		return mapper.map(cliente, ClienteDTO.class);
	}
	
	@PutMapping(path = "{id}")
	public ClienteDTO alterar(@PathVariable Long id, @RequestBody @Valid ClienteDTO clienteDTO) {
		
		Cliente cliente = mapper.map(clienteDTO, Cliente.class);
		
		Cliente cursoAlterado = clienteService.alterar(id, cliente);
		return mapper.map(cursoAlterado, ClienteDTO.class);
	}
}
