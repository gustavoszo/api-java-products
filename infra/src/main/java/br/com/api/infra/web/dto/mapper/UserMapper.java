package br.com.api.infra.web.dto.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import br.com.api.entities.User;
import br.com.api.infra.persistence.entities.UserEntity;
import br.com.api.infra.web.dto.UserCreateDto;
import br.com.api.infra.web.dto.UserResponseDto;

public class UserMapper {
    
    public static UserEntity toUserEntity(User user) {
        return new ModelMapper().map(user, UserEntity.class);
    }
    
    public static User toUserDomain(UserEntity userEntity) {
        return new ModelMapper().map(userEntity, User.class);
    }
    
    public static User toUserDomain(UserCreateDto userCreateDto) {
        return new ModelMapper().map(userCreateDto, User.class);
    }
    
    public static UserResponseDto toUserResponseDto(User user) {
        String role = user.getRole().getRole();
        // Classe anônima da ModelMapper, a partir do objeto PropertyMap
        PropertyMap<User, UserResponseDto> props = new PropertyMap<User, UserResponseDto>() {
            @Override
            protected void configure() {
                // A partir do método map, é feito o acesso aos campos presentes em UsuarioResponseDto
                map().setRole(role);
            }  
        };

        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(props);
        return new ModelMapper().map(user, UserResponseDto.class);
    }

}
