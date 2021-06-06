package pe.com.tpp.api.dao;

import org.springframework.data.repository.CrudRepository;

import pe.com.tpp.api.entity.Personas;

public interface IPersonasDao extends CrudRepository<Personas, Long> {
	
}
