package pe.com.tpp.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.tpp.api.entity.*;
import pe.com.tpp.api.entity.dto.*;
import pe.com.tpp.api.service.*;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

@Controller
public class AplicacionController {

	@Autowired
	private IUsuariosService usuarioService;

	@Autowired
	private IPersonasPorCargosService personasPorCargosService;
	
	@Autowired
	private IHistoriasService historiasService;

	@GetMapping({ "/login", "/" })
	public String login(Model model) {
		model.addAttribute("titulo", "DEV");
		return "login";
	}

	@PostMapping("/login")
	public String verificarAccesos(@Valid Login login, Model model) {

		model.addAttribute("titulo", "Listado de HUs");
		model.addAttribute("accesos", login);

		Usuarios usuarios = usuarioService.buscarAccesos(login);

		if (usuarios != null) {
			return "/historias/listar";
		}

		return "login";
	}

	@GetMapping("/registrar")
	public String gethuRegistrar(Model model) {
		Historias historias = new Historias();
		List<PersonasPorCargos> listado = personasPorCargosService.listarTodos();
		model.addAttribute("listado", listado);
		model.addAttribute("historia", historias);
		return "historias/registrar";
	}
	
	@PostMapping("/registrar")
	public String posthuRegistrar(@Valid Historias historias, Model model) {
		
		historiasService.grabar(historias);
		return "/historias/listar";
	}

}
