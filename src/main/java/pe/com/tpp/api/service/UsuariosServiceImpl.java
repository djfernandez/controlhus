package pe.com.tpp.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tpp.api.dao.IUsuariosDao;
import pe.com.tpp.api.entity.Login;
import pe.com.tpp.api.entity.Usuario;

@Service
public class UsuariosServiceImpl implements IUsuariosService {

	@Autowired
	private IUsuariosDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listarTodos() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional
	public Usuario grabar(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario buscarPorId(Long id) {
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
	public Usuario buscarAccesos(Login accesos) {
		// TODO Auto-generated method stub
		return usuarioDao.findByUsernameAndPassword(accesos.getUsername(), accesos.getPassword());
	}

	@Override
	public Usuario buscarUsuario(String usuario) {
		// TODO Auto-generated method stub
		return usuarioDao.findByUsername(usuario);
	}
}
