package com.farol.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity 
@Table(name="item")
public class Item implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	@NotNull
	private Long id;
	
	@Column(name = "codigo", unique = true, nullable = false)
	@NotNull
	@Size(min=1,max=7,message="Cógido deve ter no máximo 7 caracteres. Você digitou: ${validatedValue}")
	private String codigo;
	
	@Column(name = "serie", unique = true, nullable = false)
	private String serie;
	
	@Column(name = "disponibilidade")
	private char disponibilidade = DisponibilidadeEnum.DISPONIVEL.getDisponibilidade();
	
	@Column(name = "status")
	private char status = StatusEnum.ATIVO.getStatus();
	
	@Column(name = "descricao", nullable = false)
	@NotNull
	@Size(min=1,max=100,message="Cógido deve ter no máximo 100 caracteres. Você digitou: ${validatedValue}")
	private String descricao;
	
	@Column(name = "localizacao", nullable = false)
	@NotNull
	@Size(min=3,max=250,message="Cógido deve ter no máximo 250 caracteres e no minimo 3. Você digitou: ${validatedValue}")
	private String localizacao;
	
	@Column(name = "dataMoviment")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataMoviment = new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public char getDisponibilidade() {
		return disponibilidade;
	}
	
	public void setDisponibilidade(char disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public char getStatus() {
		return status;
	}
	
	public void setStatus(char status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public Date getDataMoviment() {
		return dataMoviment;
	}

	public void setDataMoviment(Date dataMoviment) {
		this.dataMoviment = dataMoviment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((dataMoviment == null) ? 0 : dataMoviment.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + disponibilidade;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((localizacao == null) ? 0 : localizacao.hashCode());
		result = prime * result + ((serie == null) ? 0 : serie.hashCode());
		result = prime * result + status;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataMoviment == null) {
			if (other.dataMoviment != null)
				return false;
		} else if (!dataMoviment.equals(other.dataMoviment))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (disponibilidade != other.disponibilidade)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (localizacao == null) {
			if (other.localizacao != null)
				return false;
		} else if (!localizacao.equals(other.localizacao))
			return false;
		if (serie == null) {
			if (other.serie != null)
				return false;
		} else if (!serie.equals(other.serie))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	
	
	
}
