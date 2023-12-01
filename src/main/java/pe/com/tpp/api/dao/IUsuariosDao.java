package pe.com.tpp.api.dao;

import org.springframework.data.repository.CrudRepository;

import pe.com.tpp.api.entity.Usuario;

public interface IUsuariosDao extends CrudRepository<Usuario, Long> {

	public Usuario findByUsernameAndPassword(String username, String password);

	public Usuario findByUsername(String username);

}
