package br.com.desafio.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;


@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
    @JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;
	
	@Column(length = 8, nullable = false)
	@NotBlank(message = "CEP é obrigatório")
	private String cep;
	
	@Column(nullable = false)
	@NotBlank(message = "Logradouro é obrigatório")
	private String logradouro;

	@Column(nullable = false)
	@NotBlank(message = "Bairro é obrigatório")
	private String bairro;

	@Column(nullable = false)
	@NotBlank(message = "Cidade é obrigatório")
	private String cidade;

	@Column(length = 2 ,nullable = false)
	@NotBlank(message = "UF é obrigatório")
	private String uf;

	@Column(nullable = true)
	private String complemento;
	
	@Column(columnDefinition = "timestamp default current_timestamp", insertable = false, updatable = false)
	private LocalDateTime criadoEm;
	
	@Column(columnDefinition = "timestamp default current_timestamp", insertable = false, updatable = false)
	private LocalDateTime atualizadoEm;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
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
	
	
}
