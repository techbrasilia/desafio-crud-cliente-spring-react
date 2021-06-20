package br.com.desafio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.request.LoginRequest;
import br.com.desafio.request.SignupRequest;
import br.com.desafio.response.JwtResponse;
import br.com.desafio.service.UsuarioService;

@RestController
@RequestMapping("/api/auth")
public class UsuarioController {

	@Autowired
	private UsuarioService authService;

	@PostMapping("/signin")
	public ResponseEntity<?> signin(@Valid @RequestBody LoginRequest loginRequest) {
		JwtResponse jwtResponse = authService.authenticateUser(
				loginRequest.getUsername(), loginRequest.getPassword());

		return ResponseEntity.ok(jwtResponse);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest signupRequest) {
		
		authService.registerUser(signupRequest.getUsername(), signupRequest.getPassword(),
				signupRequest.getConfirmPassword(), signupRequest.getRoles());

		return ResponseEntity.ok("Usuário registrado com sucesso");
	}

}
