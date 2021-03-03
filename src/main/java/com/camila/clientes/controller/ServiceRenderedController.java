package com.camila.clientes.controller;


import com.camila.clientes.dtos.PageableDTO;
import com.camila.clientes.dtos.ServiceDTO;
import com.camila.clientes.mapper.ClienteMapper;
import com.camila.clientes.mapper.ServiceMapper;
import com.camila.clientes.model.entity.Client;
import com.camila.clientes.model.entity.ServiceRendered;
import com.camila.clientes.model.service.ServiceRenderedService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/service")
public class ServiceRenderedController {

    @Autowired
    private ServiceRenderedService service;


    @PostMapping
    public ResponseEntity< ServiceRendered > saveService(@RequestBody  @Valid ServiceDTO serviceDTO ) {
        final ServiceRendered serviceRendered = service.save( serviceDTO );
        return new ResponseEntity( serviceRendered, HttpStatus.CREATED );
    }


    @GetMapping
    public ResponseEntity findAllService ( @RequestParam( required = false ) String description,
                                                              @RequestParam(required = false ) String name,
                                                              PageableDTO pageableDTO ) {

        Pageable pageable = ServiceMapper.getPageable( pageableDTO );

        Page< ServiceRendered > pageService = service.findAllService(  description, name, pageable );
        return new ResponseEntity( pageService.getContent(), HttpStatus.OK ) ;
    }
}
