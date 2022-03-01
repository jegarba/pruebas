package com.jg.octans.prueba.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class UsuarioModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private RolModel rol;
	
	@NotEmpty(message = "el nombre no puede estar vacio!")
	@Column(unique = true, nullable = false)
	private String nombre;
	
	@NotEmpty(message = "el estado no puede estar vacio!")
	private String activo;
}
