package br.com.desafio.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.desafio.enums.ERole;
import br.com.desafio.model.Role;
import br.com.desafio.model.Usuario;
import br.com.desafio.repository.RoleRepository;
import br.com.desafio.repository.UsuarioRepository;

@Configuration
public class CarregaBaseDeDados {

	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private UsuarioRepository userRepo;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Bean
	CommandLineRunner carregaBanco() {
		return args -> {
			roleRepo.save(new Role(ERole.ROLE_ADMIN));
			roleRepo.save(new Role(ERole.ROLE_USER));

			Usuario user = new Usuario("admin", passwordEncoder.encode("123456"));
			user.setRoles(new HashSet<>(Arrays.asList(roleRepo.findByName(ERole.ROLE_ADMIN).orElse(null))));

			userRepo.save(user);
			user = new Usuario("comum", passwordEncoder.encode("123456"));
			user.setRoles(new HashSet<>(Arrays.asList(roleRepo.findByName(ERole.ROLE_USER).orElse(null))));

			userRepo.save(user);
			
		};
	}
}
