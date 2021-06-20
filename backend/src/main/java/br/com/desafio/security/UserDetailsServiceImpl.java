package br.com.desafio.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.desafio.model.Usuario;
import br.com.desafio.repository.UsuarioRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = userRepository
				.findByUsername(username)
				      	.orElseThrow(() -> new UsernameNotFoundException(
				"Usuário não encontrado"));
		
		return UserDetailsImpl.build(user);
	}

}
