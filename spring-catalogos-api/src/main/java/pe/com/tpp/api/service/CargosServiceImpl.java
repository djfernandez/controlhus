package pe.com.tpp.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tpp.api.dao.ICargosDao;
import pe.com.tpp.api.entity.Cargo;

@Service
public class CargosServiceImpl implements ICargosService {

	@Autowired
	private ICargosDao cargosDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cargo> listarTodos() {
		// TODO Auto-generated method stub
		return (List<Cargo>) cargosDao.findAll();
	}

	@Override
	@Transactional
	public Cargo grabar(Cargo cargo) {
		// TODO Auto-generated method stub
		return cargosDao.save(cargo);
	}

	@Override
	@Transactional(readOnly = true)
	public Cargo buscarPorId(Long id) {
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
