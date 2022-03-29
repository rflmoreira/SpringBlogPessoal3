package org.generation.blogpessoal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_postagens") //NOMEIA A TABELA
public class Postagens {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) //AUTO INCREMENT
	private Long id;
	
	@NotNull
	private String titulo;
	
	@Size(min=4, max=50) //DEFINE TAMANHO MIN E MAX DE CARACTERES 
	private String texto;
	
	@UpdateTimestamp //FORMATA PARA A DATA DO COMPUTADOR EX:24/03/202022
	private LocalDateTime date; //PEGA A DATA DO COMPUTADOR 

	
	@ManyToOne
	@JsonIgnoreProperties("postagens")
	private Tema tema;
	
	
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	
}
