package pe.com.tpp.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.tpp.api.entity.Historias;
import pe.com.tpp.api.entity.Login;
import pe.com.tpp.api.entity.Usuarios;
import pe.com.tpp.api.service.IUsuariosService;

import java.util.Map;

import javax.validation.Valid;

@Controller
public class AplicacionController {

	@Autowired
	private IUsuariosService usuarioService;
	
	@GetMapping({"/login", "/"})
	public String login(Model model) {
		model.addAttribute("titulo", "DEV");
		return "login";
	}
	
	@PostMapping("/login")
	public String verificarAccesos(@Valid Login login, Model model) {
		
		model.addAttribute("titulo","Listado de HUs");
		model.addAttribute("accesos", login);
		
		Usuarios usuarios = usuarioService.buscarAccesos(login);
		
		if (usuarios != null)
		{
			return "/historias/listar";
		}
		
		return "login";
	}
	
	@GetMapping("/registrar")
	public String HURegistrar(Map<String, Object> model) {
		
		Historias historias = new Historias();
		model.put("historia", historias);
		return "historias/registrar";
	}
	
}
