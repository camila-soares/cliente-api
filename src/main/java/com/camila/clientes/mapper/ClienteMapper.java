package com.camila.clientes.mapper;


import com.camila.clientes.dtos.ClientDTO;
import com.camila.clientes.dtos.PageableDTO;
import com.camila.clientes.model.entity.Client;
import com.camila.clientes.model.entity.ServiceRendered;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@NoArgsConstructor( access = AccessLevel.PRIVATE )
public class ClienteMapper {

    public static ClientDTO toClientDTO( Client client ) {
        return ClientDTO.builder()
                .id( client.getId() )
                .cpf( client.getCpf() )
                .name( client.getName() )
                .dateRegistration( client.getDateRegistration() )
                .build();
    }

    public static Client toClient( ClientDTO clientDTO ) {
        return Client.builder()
                .id( clientDTO.getId() )
                .cpf( clientDTO.getCpf() )
                .name( clientDTO.getName() )
                .dateRegistration( clientDTO.getDateRegistration() )
                .build();
    }

    public static ClientDTO userDetailsDto( String cpf, String name ) {
        return ClientDTO.builder()
                .cpf(  cpf )
                .name( name )
                .build();
    }

    public static Pageable getPageable( PageableDTO pageableDto ) {
        return PageRequest.of( pageableDto.getPageNumber(), pageableDto.getPageSize(),
                Sort.Direction.fromString( pageableDto.getSortDirection() ), pageableDto.getSortField() );
    }
}
