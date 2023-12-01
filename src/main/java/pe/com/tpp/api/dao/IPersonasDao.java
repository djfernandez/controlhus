package pe.com.tpp.api.dao;

import org.springframework.data.repository.CrudRepository;

import pe.com.tpp.api.entity.Persona;

public interface IPersonasDao extends CrudRepository<Persona, Long> {
	
}
