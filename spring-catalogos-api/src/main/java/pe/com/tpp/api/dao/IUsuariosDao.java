package pe.com.tpp.api.dao;

import org.springframework.data.repository.CrudRepository;

import pe.com.tpp.api.entity.Usuarios;

public interface IUsuariosDao extends CrudRepository<Usuarios, Long> {

	public Usuarios findByUsuarioAndClave(String usuario, String clave);
	
	//public Usuarios findByLoginAndDocumentoIdentidad(String login, String documentoIdentidad);

}
