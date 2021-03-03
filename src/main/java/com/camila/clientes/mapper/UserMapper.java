package com.camila.clientes.mapper;


import com.camila.clientes.dtos.ClientDTO;
import com.camila.clientes.dtos.UserDTO;
import com.camila.clientes.model.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor( access = AccessLevel.PRIVATE )
public class UserMapper {

    public static User toUser( UserDTO userDTO ) {
        return User.builder()
                .id( userDTO.getId() )
                .username( userDTO.getUsername() )
                .password( userDTO.getPassword() )
                .build();
    }

    public static UserDTO toUserDTO( User user ) {
        return UserDTO.builder()
                .id( user.getId() )
                .username( user.getUsername() )
                .password( user.getPassword() )
                .build();
    }
}
