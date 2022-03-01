package com.jg.octans.prueba.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jg.octans.prueba.models.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{

	Optional<UsuarioModel>findBynombre(String nombre);
}
