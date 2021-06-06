package pe.com.tpp.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tpp.api.dao.IPersonasDao;
import pe.com.tpp.api.entity.Personas;

@Service
public class PersonasServiceImpl implements IPersonasService {
	
	@Autowired
	private IPersonasDao personasDao;

	@Override
	@Transactional(readOnly = true)
	public List<Personas> listarTodos() {
		// TODO Auto-generated method stub
		return (List<Personas>) personasDao.findAll();
	}

	@Override
	@Transactional
	public Personas grabar(Personas persona) {
		// TODO Auto-generated method stub
		return personasDao.save(persona);
	}

	@Override
	@Transactional(readOnly = true)
	public Personas buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return personasDao.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		personasDao.deleteById(id);
	}

}
