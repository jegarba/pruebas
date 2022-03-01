package com.jg.octans.prueba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jg.octans.prueba.models.RolModel;
import com.jg.octans.prueba.repositories.RolRepository;

@Service
public class RolService {

	@Autowired
	private RolRepository rolRepository;
	
	public List<RolModel> getAll() {
		return rolRepository.findAll();
	}
}
