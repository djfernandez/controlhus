package pe.com.tpp.api.service;

import java.util.List;

import pe.com.tpp.api.dao.ICRUD;
import pe.com.tpp.api.entity.Historia;

public interface IHistoriasService extends ICRUD<Historia> {

	public List<Historia> listadoPersonasCargosUsuario(Integer estado);
	
}
