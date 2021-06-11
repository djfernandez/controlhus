package pe.com.tpp.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.com.tpp.api.entity.*;
import pe.com.tpp.api.entity.dto.*;
import pe.com.tpp.api.service.*;

import java.security.Principal;
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
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model, Principal principal,
			RedirectAttributes flash) {
		model.addAttribute("titulo", "DEV");

		if (principal != null) {
			flash.addFlashAttribute("info", "Ya ha inciado sesión anteriormente");
			return "redirect:/";
		}

		if (error != null) {
			model.addAttribute("error",
					"Error en el login: Nombre de usuario o contraseña incorrecta, por favor vuelva a intentarlo!");
		}

		if (logout != null) {
			model.addAttribute("success", "Ha cerrado sesión con éxito!");
		}

		return "login";
	}

	@PostMapping("/login")
	public String verificarAccesos(@Valid Login login, Model model) {

		model.addAttribute("titulo", "Listado de HUs");
		model.addAttribute("accesos", login);
		Usuarios usuarios = usuarioService.buscarAccesos(login);
		if (usuarios != null) {
			List<Historias> historias = historiasService.listarTodos();
			model.addAttribute("historias", historias);
			return "/historias/listar";
		}
		return "login";
	}

	@GetMapping("/registrar")
	public String gethuRegistrar(Model model) {

		Historias historias = new Historias();
		List<PersonasPorCargos> listado = personasPorCargosService.listarTodos();
		model.addAttribute("listado", listado);
		model.addAttribute("historias", historias);
		return "historias/registrar";
	}

	@PostMapping("/registrar")
	public String posthuRegistrar(@Valid Historias historias, Model model) {

		historias.setId((long) 0);
		historiasService.grabar(historias);
		return "/historias/listar";
	}

}
