package pe.com.tpp.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.tpp.api.service.IHistoriasService;

@RestController
@Controller
@RequestMapping("/api/v1")
public class HistoriasController {
	
	@Autowired
	private IHistoriasService historiasService;
	
	@GetMapping("/historias")
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(historiasService.listarTodos());
	}

}
