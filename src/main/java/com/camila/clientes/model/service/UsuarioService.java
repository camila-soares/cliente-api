package com.camila.clientes.model.service;

import com.camila.clientes.model.entity.User;
import com.camila.clientes.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
        User user = userRepository.findByUsername( username )
                .orElseThrow( () -> new UsernameNotFoundException( "Login não encontrado." )  );

        return org.springframework.security.core.userdetails.User
                .builder()
                .username( user.getUsername() )
                .password( user.getPassword() )
                .roles( "USER" )
                .build();
    }
}
