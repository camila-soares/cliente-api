package com.camila.clientes.controller;

import com.camila.clientes.dtos.ClientDTO;
import com.camila.clientes.dtos.PageableDTO;
import com.camila.clientes.mapper.ClienteMapper;
import com.camila.clientes.model.entity.Client;
import com.camila.clientes.model.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService service;


    @PostMapping
    @ResponseStatus( HttpStatus.CREATED )
    public ResponseEntity< ClientDTO > saveClient( @Valid @RequestBody ClientDTO clientDTO ) throws Exception {
    final Client client = service.saveCliente( clientDTO );
    System.out.println(String.format("Client saved: %s", client.toString()));
    return new ResponseEntity( ClienteMapper.toClientDTO( client ), HttpStatus.CREATED );

    }

    @GetMapping
    public ResponseEntity findAllClient ( @RequestParam( required = false ) String cpf,
                                          @RequestParam( required = false) String name, PageableDTO pageableDTO ) {

        Pageable pageable = ClienteMapper.getPageable( pageableDTO );

            Page< Client > pageClient = service.findAllUser(  cpf, name, pageable );
            return new ResponseEntity( pageClient.getContent(), HttpStatus.OK ) ;
    }


    @GetMapping("/{id}")
    public ResponseEntity < ClientDTO > findClientById( @PathVariable Long id ) {
        Client client = service.findClientById( id );
        ClientDTO clientDTO = ClienteMapper.toClientDTO( client );
        return new ResponseEntity( clientDTO, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public void deleteClient ( @PathVariable Long id) {
        service.deleteClient( id );
    }


    @PutMapping("/{id}")
    public void updateCliente( @PathVariable Long id, @RequestBody ClientDTO clientDTO ) {
        service.updateClient( id, clientDTO );

    }

}
