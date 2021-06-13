package pe.com.tpp.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tpp.api.dao.IPersonasDao;
import pe.com.tpp.api.entity.Persona;

@Service
public class PersonasServiceImpl implements IPersonasService {
	
	@Autowired
	private IPersonasDao personasDao;

	@Override
	@Transactional(readOnly = true)
	public List<Persona> listarTodos() {
		// TODO Auto-generated method stub
		return (List<Persona>) personasDao.findAll();
	}

	@Override
	@Transactional
	public Persona grabar(Persona persona) {
		// TODO Auto-generated method stub
		return personasDao.save(persona);
	}

	@Override
	@Transactional(readOnly = true)
	public Persona buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return personasDao.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		personasDao.deleteById(id);
	}

}
