package pe.com.tpp.api.dao;

import org.springframework.data.repository.CrudRepository;

import pe.com.tpp.api.entity.Cargo;

public interface ICargosDao extends CrudRepository<Cargo, Long> {

}
