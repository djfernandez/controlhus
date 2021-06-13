package pe.com.tpp.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.User;
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
	private IPersonasPorCargosService personasPorCargosService;

	@Autowired
	private IHistoriasService historiasService;

	@Autowired
	private MessageSource messageSource;

	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model, Principal principal,
			RedirectAttributes flash) {

		model.addAttribute("titulo", "DEV");

		if (principal != null) {
			flash.addFlashAttribute("info", messageSource.getMessage("text.login.already", null, null));
			return "redirect:/";
		}

		if (error != null) {
			model.addAttribute("error", messageSource.getMessage("text.login.error", null, null));
		}

		if (logout != null) {
			model.addAttribute("success", messageSource.getMessage("text.login.logout", null, null));
		}

		return "login";
	}

	@GetMapping("/registrar")
	public String gethuRegistrar(Model model) {

		Historia historias = new Historia();
		List<PersonasPorCargos> listado = personasPorCargosService.listarTodos();
		model.addAttribute("listado", listado);
		model.addAttribute("historias", historias);
		return "historias/registrar";
	}

	@PostMapping("/registrar")
	public String posthuRegistrar(@Valid Historia historias, Model model) {

		historias.setId((long) 0);
		historiasService.grabar(historias);
		return "redirect:listado";
	}

	@GetMapping({ "/listado", "/" })
	public String gethuListado(Model model) {

		List<Historia> historias = historiasService.listarTodos();
		model.addAttribute("titulo", "DEV");
		model.addAttribute("historias", historias);

		return "/historias/listar";
	}

}
