package com.camila.clientes.model.service.filter;

import com.camila.clientes.dtos.ServiceDTO;

import com.camila.clientes.model.entity.Client;
import com.camila.clientes.model.entity.ServiceRendered;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class ServiceFilter {

    private String description;
    private String client;

    public static ServiceFilter of( ServiceDTO serviceDTO ) {
        return ServiceFilter.builder()
                .description( serviceDTO.getDescription() )
                .client( serviceDTO.getClient() )
                .build();
    }
}
