package pe.com.tpp.api.dao;

import org.springframework.data.repository.CrudRepository;

import pe.com.tpp.api.entity.Historia;

public interface IHistoriasDao extends CrudRepository<Historia, Long> {

}
