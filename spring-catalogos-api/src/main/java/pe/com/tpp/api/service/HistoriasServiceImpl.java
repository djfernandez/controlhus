package pe.com.tpp.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tpp.api.dao.IHistoriasDao;
import pe.com.tpp.api.entity.Historia;

@Service
public class HistoriasServiceImpl implements IHistoriasService {

	@Autowired
	private IHistoriasDao historiasDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Historia> listarTodos() {
		// TODO Auto-generated method stub
		return (List<Historia>) historiasDao.findAll();
	}

	@Override
	@Transactional
	public Historia grabar(Historia t) {
		// TODO Auto-generated method stub
		return historiasDao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Historia buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return historiasDao.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		historiasDao.deleteById(id);
	}

	@Override
	public List<Historia> listadoPersonasCargosUsuario(Integer estado) {
		// TODO Auto-generated method stub
		return (List<Historia>) historiasDao.listadoPersonasCargosUsuario(estado);
	}
	
}
