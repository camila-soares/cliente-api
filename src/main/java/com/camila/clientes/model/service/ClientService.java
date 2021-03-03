package com.camila.clientes.model.service;

import com.camila.clientes.config.AmqpConfig;
import com.camila.clientes.dtos.ClientDTO;
import com.camila.clientes.mapper.ClienteMapper;
import com.camila.clientes.model.entity.Client;
import com.camila.clientes.model.repository.ClientRepository;
import com.camila.clientes.model.service.filter.ClientFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Client saveCliente( ClientDTO clientDTO ) {
        Client client;
        if( repository.findClientByCpf( clientDTO.getCpf() ).isPresent() ){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST , "CPF já cadastrado" );
        }

        client = repository.save( ClienteMapper.toClient( clientDTO ) );
        sendClientToRabbit( client );
        return client;
    }

    public void sendClientToRabbit( Client client) {
        try {
            String json = new ObjectMapper().writeValueAsString( client );
            rabbitTemplate.convertAndSend( AmqpConfig.EXCHANGE_NAME, "", json );
        } catch( JsonProcessingException e ) {
            e.printStackTrace();
        }
    }

    public Page< Client > findAllUser( String cpf, String name, Pageable pageable ) {
        Page < Client > clients = Optional.of( repository.getAll( ClientFilter.of( ClienteMapper.userDetailsDto( cpf, name ) ), pageable ) )
                .orElse( null );
        return new PageImpl( clients.map( f -> ClienteMapper.toClientDTO( f ) ).getContent(),
                pageable, clients.getTotalElements() );
    }


    public Client findClientById( Long id ) {
        return repository.findById( id )
                .orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND ) );
    }

    public void deleteClient( Long id ) {
        repository.findById( id ).map( client -> {
            repository.delete( client );
            return Void.TYPE;
        } ).orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND ) );
    }

    public void updateClient( Long id, ClientDTO clientDTO ) {

        repository.findById( id ).map( client -> {
            client.setCpf( clientDTO.getCpf() );
            client.setName( clientDTO.getName() );
            return repository.save( client );
        } ).orElseThrow( () -> new ResponseStatusException( HttpStatus.NO_CONTENT ) );
    }
}
