package br.com.desafio.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ClienteDTO {

private Long id;
	
	private String nome;
	
	private String cpf;
	
	@JsonIgnore
	private LocalDateTime criadoEm;
	
	@JsonIgnore
	private LocalDateTime atualizadoEm;
	
	private EnderecoDTO endereco;
	
	private List<TelefoneDTO> telefones;
	
	private List<EmailDTO> emails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDateTime getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(LocalDateTime criadoEm) {
		this.criadoEm = criadoEm;
	}

	public LocalDateTime getAtualizadoEm() {
		return atualizadoEm;
	}

	public void setAtualizadoEm(LocalDateTime atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public List<TelefoneDTO> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneDTO> telefones) {
		this.telefones = telefones;
	}

	public List<EmailDTO> getEmails() {
		return emails;
	}

	public void setEmails(List<EmailDTO> emails) {
		this.emails = emails;
	}
	
}
