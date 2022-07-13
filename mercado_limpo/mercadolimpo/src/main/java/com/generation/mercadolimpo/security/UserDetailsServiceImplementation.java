package com.generation.mercadolimpo.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.generation.mercadolimpo.model.Usuario;
import com.generation.mercadolimpo.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> user = usuarioRepository.findByEmail(username);
		user.orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
		
		return user.map(UserDetailsImplementation::new).get();
	}
	
}
