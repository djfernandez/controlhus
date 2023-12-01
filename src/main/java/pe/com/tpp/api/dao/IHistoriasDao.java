package pe.com.tpp.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pe.com.tpp.api.entity.Historia;

public interface IHistoriasDao extends CrudRepository<Historia, Long> {

	@Query(value = "select * from historias inner join personas on historias.persona_id_persona = personas.id_persona inner join cargos on personas.cargo_id_cargo = cargos.id_cargo inner join usuarios on historias.usuario_id_usuario = usuarios.id_usuario where historias.estado=?1", nativeQuery = true)
	public List<Historia> listadoPersonasCargosUsuario(Integer estado);

}
