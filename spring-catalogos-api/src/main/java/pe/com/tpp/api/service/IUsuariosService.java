package pe.com.tpp.api.service;

import java.util.List;

import pe.com.tpp.api.entity.Login;
import pe.com.tpp.api.entity.Usuarios;

public interface IUsuariosService {

	public List<Usuarios> listarTodos();

	public Usuarios grabar(Usuarios usuario);

	public Usuarios buscarPorId(Long id);

	public Usuarios buscarAccesos(Login accesos);

	public void eliminar(Long id);

}
