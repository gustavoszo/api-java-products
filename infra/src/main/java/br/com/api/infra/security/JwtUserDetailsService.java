package br.com.api.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.api.infra.persistence.entities.UserEntity;
import br.com.api.infra.web.dto.mapper.UserMapper;
import br.com.api.usecases.user.FindUserByUsernameUseCase;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private FindUserByUsernameUseCase findUserByUsernameUseCase;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = UserMapper.toUserEntity(findUserByUsernameUseCase.execute(username));
        return new JwtUserDetails(userEntity);
    }
    
    public JwtToken getToken(String username) {
        return new JwtToken(JwtUtils.generateToken(username));
    }

}
