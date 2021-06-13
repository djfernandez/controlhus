package pe.com.tpp.api.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tpp.api.dao.IUsuariosDao;
import pe.com.tpp.api.entity.Role;
import pe.com.tpp.api.entity.Usuario;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private IUsuariosDao usuariosDao;

	private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = usuariosDao.findByUsername(username);

		if (usuario == null) {
			logger.error("Error en el Login: no existe el usuario '" + username + "' en el sistema!");
			throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
		}

		logger.info("Usuario valido. el usuario es: " + username);
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (Role role : usuario.getRoles()) {
			logger.info("Role: ".concat(role.getAuthority()));
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}

		if (authorities.isEmpty()) {
			logger.error("Error en el Login: Usuario '" + username + "' no tiene roles asignados!");
			throw new UsernameNotFoundException(
					"Error en el Login: usuario '" + username + "' no tiene roles asignados!");
		}

		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, authorities);
	}

}
