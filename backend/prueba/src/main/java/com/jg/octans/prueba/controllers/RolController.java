package com.jg.octans.prueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jg.octans.prueba.models.RolModel;
import com.jg.octans.prueba.services.RolService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/rol")
public class RolController {

	@Autowired
	private RolService rolService;
	
	@GetMapping
	public ResponseEntity<List<RolModel>> listar() {
		List<RolModel> roles = rolService.getAll();
		if (roles.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(roles);
	}
}
