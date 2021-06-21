package pe.com.tpp.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.com.tpp.api.dao.IPersonasDao;
import pe.com.tpp.api.dao.IUsuariosDao;
import pe.com.tpp.api.entity.*;
import pe.com.tpp.api.service.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@Controller
public class AplicacionController {

	@Autowired
	private IHistoriasService historiasService;

	@Autowired
	private IUsuariosDao usuarioDao;

	@Autowired
	private IPersonasDao personasDao;

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

	@GetMapping({ "/hu/listado", "/" })
	public String gethuListado(Model model) {
		List<Historia> historias = historiasService.listadoPersonasCargosUsuario(1);
		model.addAttribute("titulo", "DEV");
		model.addAttribute("historias", historias);
		return "/historias/listar";
	}

	@GetMapping("/hu/registrar")
	public String gethuRegistrar(Map<String, Object> model) {

		Historia historias = new Historia();
		historias.setFechaRegistro(new Date());

		List<Persona> listado = (List<Persona>) personasDao.findAll();

		model.put("listado", listado);
		model.put("historias", historias);
		return "historias/registrar";
	}

	@PostMapping("/hu/registrar")
	public String posthuRegistrar(@Valid Historia historia, BindingResult result, Model model, RedirectAttributes flash,
			Principal principal) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", messageSource.getMessage("Error en historias", null, null));
			return "redirect:listado";
		}
		/*
		if (historia.getId() > 0) {
			model.addAttribute("titulo", messageSource.getMessage("Editar historia", null, null));
		}
*/
		Usuario usuario = usuarioDao.findByUsername(principal.getName());
		// historias.setId((long) 0);
		historia.setUsuario(usuario);
		historiasService.grabar(historia);
		return "redirect:listado";
	}

	@GetMapping(value = "/hu/ver/{id}")
	public String huVer(@PathVariable(value = "id") Long id, Model model) {
		Historia historia = historiasService.buscarPorId(id);
		model.addAttribute("historia", historia);
		return "/historias/ver";
	}

	@GetMapping(value = "/hu/editar/{id}")
	public String huEditar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Historia historias = null;
		if (id > 0) {
			historias = historiasService.buscarPorId(id);
			if (historias == null) {
				flash.addFlashAttribute("error", messageSource.getMessage("No se encontro historia.", null, null));
				return "redirect:/hu/listado";
			}
		} else {
			flash.addFlashAttribute("error", messageSource.getMessage("Id no es valido.", null, null));
			return "redirect:/hu/listado";
		}

		List<Persona> listado = (List<Persona>) personasDao.findAll();

		model.put("listado", listado);
		model.put("historias", historias);
		return "historias/registrar";
	}

}
