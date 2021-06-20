package br.com.desafio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.enums.ERole;
import br.com.desafio.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByName(ERole roleUser);

}
