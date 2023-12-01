package pe.com.tpp.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.com.tpp.api.entity.Usuario;
import pe.com.tpp.api.service.IUsuariosService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

	@Autowired
	private IUsuariosService usuarioService;

	@GetMapping("/usuarios")
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(usuarioService.listarTodos());
	}

	@GetMapping("/usuarios/{id}")
	public ResponseEntity<?> listarUno(@PathVariable Long id) {
		return ResponseEntity.ok(usuarioService.buscarPorId(id));
	}

	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario grabar(@RequestBody Usuario usuario) {
		return usuarioService.grabar(usuario);
	}

	@PutMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario modificar(@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario usuarioActual = usuarioService.buscarPorId(id);
/*
		usuarioActual.setNombre(usuario.getNombre());
		usuarioActual.setLinea(usuario.getLinea());
		usuarioActual.setCorreo(usuario.getCorreo());
		usuarioActual.setWeb(usuario.getWeb());
		usuarioActual.setCaduca(usuario.getCaduca());
		usuarioActual.setCambio(usuario.getCambio());
		usuarioActual.setEmpresa(usuario.getEmpresa());
		*/
		return usuarioService.grabar(usuarioActual);
		
	}

	@DeleteMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		usuarioService.eliminar(id);
	}

}