package com.educaspring.EducaSpring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.educaspring.EducaSpring.model.entities.Pessoa;
import com.educaspring.EducaSpring.repository.PessoaRepository;




@RestController
@RequestMapping(path = "/api/educaciencia/pessoa")
public class PessoaController {

	private static final Pessoa Ok = null;
	
	
	// Injeção de Dependencia
	@Autowired
	private PessoaRepository pessoarepository; // para instanciar autowired - injeção dependencia
		
	
	//retornando Lista de Pessoa
	@GetMapping
	public @ResponseBody ResponseEntity<List<Pessoa>> findAll() {
		List<Pessoa> list = (List<Pessoa>) pessoarepository.findAll();
		return ResponseEntity.ok().body(list);
	}

	//retornando busca por ID de Pessoa
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Pessoa>> findById(@PathVariable Integer id) {
		Optional<Pessoa> obj = pessoarepository.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	public static Pessoa getOk() {
		return Ok;
	}
	
}
