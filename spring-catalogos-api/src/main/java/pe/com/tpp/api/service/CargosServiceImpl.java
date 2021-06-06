package pe.com.tpp.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tpp.api.dao.ICargosDao;
import pe.com.tpp.api.entity.Cargos;

@Service
public class CargosServiceImpl implements ICargosService {

	@Autowired
	private ICargosDao cargosDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cargos> listarTodos() {
		// TODO Auto-generated method stub
		return (List<Cargos>) cargosDao.findAll();
	}

	@Override
	@Transactional
	public Cargos grabar(Cargos cargo) {
		// TODO Auto-generated method stub
		return cargosDao.save(cargo);
	}

	@Override
	@Transactional(readOnly = true)
	public Cargos buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return cargosDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		cargosDao.deleteById(id);
	}

}
