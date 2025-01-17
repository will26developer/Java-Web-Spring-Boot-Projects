package com.api.rest.biblioteca.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "libros",uniqueConstraints = {@UniqueConstraint(columnNames = {"titulo"})})
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String titulo;
	@NotNull
	private String autor;
	@NotNull
	private Integer numeroPaginas; 
	@NotNull
	private Integer añoLanzamiento;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "biblioteca_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Biblioteca biblioteca;
	
	public Libro() {
		super();
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public Integer getAñoLanzamiento() {
		return añoLanzamiento;
	}

	public void setAñoLanzamiento(Integer añoLanzamiento) {
		this.añoLanzamiento = añoLanzamiento;
	}

	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	
	/*Los tipos de cargas que hay son lazy y eager, lazy significa que va a traer un dato cuando le indiquemos
	 * en cambio eager va traer todos los datos siempre, lo cual puede ocasionar colapso de memoria,lazy tambien
	 * puede provocar un error que se llama lazyinitializationexception para ello recurrimos a @JsonProperty con access writeonly
	 */
}
