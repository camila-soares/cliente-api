package com.camila.clientes.model.service;

import com.camila.clientes.config.AmqpConfig;
import com.camila.clientes.dtos.UserDTO;
import com.camila.clientes.mapper.ClienteMapper;
import com.camila.clientes.mapper.UserMapper;
import com.camila.clientes.model.entity.Client;
import com.camila.clientes.model.entity.User;
import com.camila.clientes.model.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public User saveUser( UserDTO userDTO ) {
        User user;
        if( userRepository.findByUsername( userDTO.getUsername()).isPresent() ){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST , "Esse username "  + userDTO.getUsername() + " já está sendo usado." );
        }
        user = userRepository.save( UserMapper.toUser( userDTO ) );
        sendClientToRabbit( user );
        return user;
    }

    public void sendClientToRabbit( User user) {
        try {
            String json = new ObjectMapper().writeValueAsString( user );
            rabbitTemplate.convertAndSend( AmqpConfig.EXCHANGE_NAME, "", json );
        } catch( JsonProcessingException e ) {
            e.printStackTrace();
        }
    }
}
