package com.camila.clientes.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    @NotEmpty( message = "{MSG007}")
    private String username;
    @NotEmpty( message = "{MSG008}")
    private String password;
}
