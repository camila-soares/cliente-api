package com.camila.clientes.model.service.filter;

import com.camila.clientes.dtos.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Builder
@AllArgsConstructor
@Getter
public class ClientFilter {

    private String cpf;
    private String name;

    public static ClientFilter of( ClientDTO clientDTO ) {
        return ClientFilter.builder()
                .cpf( clientDTO.getCpf() )
                .name( clientDTO.getName() )
                .build();
    }
}
