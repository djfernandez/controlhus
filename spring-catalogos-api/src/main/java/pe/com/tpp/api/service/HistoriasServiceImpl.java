package pe.com.tpp.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tpp.api.dao.IHistoriasDao;
import pe.com.tpp.api.entity.Historias;

@Service
public class HistoriasServiceImpl implements IHistoriasService {

	@Autowired
	private IHistoriasDao historiasDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Historias> listarTodos() {
		// TODO Auto-generated method stub
		return (List<Historias>) historiasDao.findAll();
	}

	@Override
	@Transactional
	public Historias grabar(Historias t) {
		// TODO Auto-generated method stub
		return historiasDao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Historias buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return historiasDao.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		historiasDao.deleteById(id);
	}
	
}
