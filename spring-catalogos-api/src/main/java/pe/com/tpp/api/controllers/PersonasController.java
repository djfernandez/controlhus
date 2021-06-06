package pe.com.tpp.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.tpp.api.service.IPersonasPorCargosService;
import pe.com.tpp.api.service.IPersonasService;

@RestController
@RequestMapping("/api/v1")
public class PersonasController {

	@Autowired
	private IPersonasService personasService;
	
	@Autowired
	private IPersonasPorCargosService personasPorCargosService;

	@GetMapping("/personas")
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(personasService.listarTodos());
	}

	@GetMapping("/personas/cargos")
	public ResponseEntity<?> listarCargos() {
		return ResponseEntity.ok().body(personasPorCargosService.listarTodos());
	}
}
