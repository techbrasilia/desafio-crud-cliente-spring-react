package br.com.desafio.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.desafio.enums.TipoTelefoneEnum;

public class TelefoneDTO {

	private Long id;
	
	@JsonIgnore
	private ClienteDTO cliente;
	
	private Integer numero;
	
	@JsonProperty(value="tipo_telefone")
	private Long tipoTelefone;
	
	@JsonIgnore
	private LocalDateTime criadoEm;
	
	@JsonIgnore
	private LocalDateTime atualizadoEm;
	
	private TipoTelefoneEnum descricaoTipoTelefone;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Long getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(Long tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
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
	
	public TipoTelefoneEnum getDescricaoTipoTelefone() {
		this.descricaoTipoTelefone = TipoTelefoneEnum.get(this.getTipoTelefone());
		return descricaoTipoTelefone;
	}
}
