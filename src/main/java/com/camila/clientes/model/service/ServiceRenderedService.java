package com.camila.clientes.model.service;

import com.camila.clientes.dtos.ServiceDTO;
import com.camila.clientes.mapper.ClienteMapper;
import com.camila.clientes.mapper.ServiceMapper;
import com.camila.clientes.model.entity.Client;
import com.camila.clientes.model.entity.ServiceRendered;
import com.camila.clientes.model.repository.ClientRepository;
import com.camila.clientes.model.repository.ServiceRenderedRepository;
import com.camila.clientes.model.service.filter.ClientFilter;
import com.camila.clientes.model.service.filter.ServiceFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ServiceRenderedService {

    @Autowired
    private ServiceRenderedRepository renderedRepository;

    @Autowired
    private ClientRepository clientRepository;


    public ServiceRendered save( ServiceDTO serviceDTO) {
        Long idCliente = serviceDTO.getIdCliente();

        Client clientOptinal = clientRepository
                .findById( idCliente )
                .orElseThrow( () ->
                    new ResponseStatusException( HttpStatus.BAD_REQUEST, "Cliente não encontrado" ));

        ServiceRendered serviceRendered = new ServiceRendered();

       serviceRendered.setClient( clientOptinal );
        serviceRendered = renderedRepository.save( ServiceMapper.toService(  serviceDTO, clientOptinal ) );
        return serviceRendered;
    }

    public Page< ServiceRendered > findAllService( String description, String name, Pageable pageable ) {
        Page < ServiceRendered > services = Optional.of( renderedRepository.getAll( ServiceFilter.of( ServiceMapper.userDetailsDto( description, name ) ), pageable ) )
                .orElse( null );
        return new PageImpl( services.map( f -> f ).getContent(),
                pageable, services.getTotalElements() );
    }
}
