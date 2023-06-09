package com.ifdevs.ace.model.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ifdevs.ace.exceptions.ResourceNotFoundException;
import com.ifdevs.ace.model.dtos.CustomUserDetailsDTO;
import com.ifdevs.ace.model.dtos.UserDTO;
import com.ifdevs.ace.model.entities.User;
import com.ifdevs.ace.model.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s);
        if (user == null)
            throw new ResourceNotFoundException("Usuário não encontrado com esse e-mail");
        return new CustomUserDetailsDTO(user);
    }
}