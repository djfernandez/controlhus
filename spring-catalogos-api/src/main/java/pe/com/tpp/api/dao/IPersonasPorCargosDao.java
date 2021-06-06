package pe.com.tpp.api.dao;

import org.springframework.data.repository.CrudRepository;

import pe.com.tpp.api.entity.dto.PersonasPorCargos;

public interface IPersonasPorCargosDao extends CrudRepository<PersonasPorCargos, Long> {

}
