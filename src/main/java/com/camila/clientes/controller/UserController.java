package com.camila.clientes.controller;

import com.camila.clientes.dtos.UserDTO;
import com.camila.clientes.mapper.ClienteMapper;
import com.camila.clientes.mapper.UserMapper;
import com.camila.clientes.model.entity.User;
import com.camila.clientes.model.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity< UserDTO > saveUser( @Valid @RequestBody UserDTO userDTO ) {
        final User user = userService.saveUser(userDTO);
        System.out.println(String.format("Client saved: %s", user.toString()));
        return new ResponseEntity( UserMapper.toUserDTO( user ), HttpStatus.CREATED );

    }
}
