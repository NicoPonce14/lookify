package com.nicolas.lookify.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cancion")
public class Cancion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 5, message = "titulo debe ser mayor a 5 caracteres")
	private String titulo;
	@NotBlank
	@Size(min = 5, message = "artista debe ser mayor a 5 caracteres")
	private String artista;

	@Min(1)
	private Integer clasificacion;

	// Esto no permitirá que el campo createdAt sea modificado después de su
	// creación.
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	public Cancion() {
	}

	public Cancion(String titulo, String artista, Integer clasificacion) {
		this.titulo = titulo;
		this.artista = artista;
		this.clasificacion = clasificacion;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
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

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public Integer getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Integer clasificacion) {
		this.clasificacion = clasificacion;
	}

	
	

}
