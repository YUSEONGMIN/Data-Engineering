package com.example.securitybasic.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.securitybasic.model.dto.UserDto;
import com.example.securitybasic.model.repository.UserRepository;


@Service
public class AuthUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        UserDto userDto = userRepository.getUserDtoByName(name);

        // username의 데이터가 database에 존재함(가입함)!!
        if(userDto != null) {
            return new AuthUserDto(userDto);
        }
        

        // 존재하지 않음
        return null;
    }
    
}
