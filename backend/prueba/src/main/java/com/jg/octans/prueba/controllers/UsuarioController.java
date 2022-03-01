package com.jg.octans.prueba.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jg.octans.prueba.models.UsuarioModel;
import com.jg.octans.prueba.services.UsuarioService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<UsuarioModel>> listar() {
		List<UsuarioModel> usuarios = usuarioService.getAll();
		if (usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(usuarios);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Optional<UsuarioModel>> listarPorId(@PathVariable Long id) {
		Optional<UsuarioModel> usuario = usuarioService.getById(id);
		if (!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping("nombre/{nombre}")
	public ResponseEntity<Optional<UsuarioModel>> listarPorNombre(@PathVariable String nombre) {
		Optional<UsuarioModel> usuario = usuarioService.getBynombre(nombre);
		if (!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping
	public ResponseEntity<UsuarioModel> guardar(@Valid @RequestBody UsuarioModel usuario, BindingResult result) {

		Optional<UsuarioModel> existe = usuarioService.getBynombre(usuario.getNombre());
		if (!existe.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<UsuarioModel> actualizar(@Valid @PathVariable Long id, @RequestBody UsuarioModel usuario, BindingResult result) {

//		if (result.hasErrors()) {
//			throw new InvalidDataException(result);
//		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarioService.save(usuario));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<UsuarioModel> eliminar(@PathVariable Long id) {
		if(!usuarioService.deleteById(id)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}
}
