package com.springboot.papajohns.config.auth;

import com.springboot.papajohns.domain.user.User;
import com.springboot.papajohns.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User entity = userRepository.loadUserByUsername(username);
        return entity == null ? null : new PrincipalDetails(entity);
    }
}
