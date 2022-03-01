package com.jg.octans.prueba.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rol")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class RolModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_rol;

	@Column(unique = true, nullable = false)
	private String nombre;
	
}
