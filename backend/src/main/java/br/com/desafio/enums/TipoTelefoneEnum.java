package br.com.desafio.enums;

import java.util.concurrent.ConcurrentHashMap;

public enum TipoTelefoneEnum {

	RESIDENCIAL(1l, "Residencial"),
	COMERCIAL(2l, "Comercial"),
	CELULAR(3l, "Celular");

	private static final ConcurrentHashMap<Long, TipoTelefoneEnum> VALORES;

	private Long id;
	private String nome;

	static {
		VALORES = new ConcurrentHashMap<>();
		for (final TipoTelefoneEnum value : TipoTelefoneEnum.values()) {
			VALORES.put(value.getId(), value);
		}
	}

	private TipoTelefoneEnum(final Long id, final String nome) {
	        this.id = id;
	        this.nome = nome;
	    }

	public static TipoTelefoneEnum get(final Long codigo) {
		return VALORES.get(codigo);
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
}
