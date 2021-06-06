package pe.com.tpp.api.dao;

import java.util.List;

public interface ICrud<T> {

	public List<T> listarTodos();
	
	public T grabar(T t);

	public T buscarPorId(Long id);

	public void eliminar(Long id);
	
}
