package com.psybot.Authentification;

import com.psybot.Models.User;
import com.psybot.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user != null){
            return new UserPrincipal(user.getUsername(),user.getPassword(),user.getRole());
        }
        else{
            throw new UsernameNotFoundException("Username Not Found");
        }
    }
    public UserDetails loadUserById(long id){
        User user = userRepository.getOne(id);
        if(user != null){
            return new UserPrincipal(user.getUsername(),user.getPassword(),user.getRole());
        }
        else{
            throw new UsernameNotFoundException("User Not found");
        }
    }
}
