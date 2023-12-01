package pe.com.tpp.api.service;

import pe.com.tpp.api.dao.ICRUD;
import pe.com.tpp.api.entity.Login;
import pe.com.tpp.api.entity.Usuario;

public interface IUsuariosService extends ICRUD<Usuario> {
	
	public Usuario buscarAccesos(Login accesos);
	
	public Usuario buscarUsuario(String usuario);
	
}
