package com.example.spring_security.service;

import com.example.spring_security.model.UserEntity;
import com.example.spring_security.repository.UserEntityRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author ogbozoyan
 * @date 25.05.2023
 */
@Data
@NoArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserEntityRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserEntity user = repository.findByUsername(username);
            return new MyUserDetails(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException(e.getClass().getSimpleName() + " User not found " + e.getMessage());
        }
    }

}
