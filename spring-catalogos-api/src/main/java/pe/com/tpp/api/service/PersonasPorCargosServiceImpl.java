package pe.com.tpp.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tpp.api.dao.IPersonasPorCargosDao;
import pe.com.tpp.api.entity.dto.PersonasPorCargos;

@Service
public class PersonasPorCargosServiceImpl implements IPersonasPorCargosService {

	@Autowired
	private IPersonasPorCargosDao personasPorCargosDao;
	
	@Override
	public List<PersonasPorCargos> listarTodos() {
		// TODO Auto-generated method stub
		return (List<PersonasPorCargos>) personasPorCargosDao.findAll();
	}

}
