package pe.com.tpp.api.service;

import java.util.List;

import pe.com.tpp.api.entity.Cargos;

public interface ICargosService {
	
	public List<Cargos> listarTodos();

	public Cargos grabar(Cargos cargo);

	public Cargos buscarPorId(Long id);

	public void eliminar(Long id);

}
