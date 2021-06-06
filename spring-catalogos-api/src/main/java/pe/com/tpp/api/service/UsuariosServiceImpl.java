package pe.com.tpp.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tpp.api.dao.IUsuariosDao;
import pe.com.tpp.api.entity.Login;
import pe.com.tpp.api.entity.Usuarios;

@Service
public class UsuariosServiceImpl implements IUsuariosService {

	@Autowired
	private IUsuariosDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public List<Usuarios> listarTodos() {
		return (List<Usuarios>) usuarioDao.findAll();
	}

	@Override
	@Transactional
	public Usuarios grabar(Usuarios usuario) {
		// TODO Auto-generated method stub
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuarios buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		usuarioDao.deleteById(id);
	}

	@Override
	public Usuarios buscarAccesos(Login accesos) {
		// TODO Auto-generated method stub
		return usuarioDao.findByUsuarioAndClave(accesos.getUsuario(), accesos.getClave());
	}

}
