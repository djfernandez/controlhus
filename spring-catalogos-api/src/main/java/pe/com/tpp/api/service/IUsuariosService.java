package pe.com.tpp.api.service;

import pe.com.tpp.api.dao.ICRUD;
import pe.com.tpp.api.entity.Login;
import pe.com.tpp.api.entity.Usuarios;

public interface IUsuariosService extends ICRUD<Usuarios> {
	
	public Usuarios buscarAccesos(Login accesos);
	
}
