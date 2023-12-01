package pe.com.tpp.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.tpp.api.service.ICargosService;

@RestController
@RequestMapping("/api/v1")
public class CargosController {
	
	@Autowired
	private ICargosService cargosService;
	
	@GetMapping("/cargos")
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(cargosService.listarTodos());
	}

}
