package com.jg.octans.prueba.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jg.octans.prueba.models.UsuarioModel;
import com.jg.octans.prueba.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Optional<UsuarioModel> getById(Long id) {
		return usuarioRepository.findById(id);
	}

	public Optional<UsuarioModel> getBynombre(String nombre) {
		return usuarioRepository.findBynombre(nombre);
	}
	
	public List<UsuarioModel> getAll() {
		return usuarioRepository.findAll();
	}
	
	public UsuarioModel save(UsuarioModel usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public boolean deleteById(Long id) {
		try {
			usuarioRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
