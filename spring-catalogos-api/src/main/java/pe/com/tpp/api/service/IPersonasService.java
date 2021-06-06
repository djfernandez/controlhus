package pe.com.tpp.api.service;

import java.util.List;

import pe.com.tpp.api.entity.Personas;

public interface IPersonasService {

	public List<Personas> listarTodos();

	public Personas grabar(Personas persona);

	public Personas buscarPorId(Long id);

	public void eliminar(Long id);
	
}
