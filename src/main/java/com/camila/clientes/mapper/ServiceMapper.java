package com.camila.clientes.mapper;


import com.camila.clientes.dtos.ClientDTO;
import com.camila.clientes.dtos.PageableDTO;
import com.camila.clientes.dtos.ServiceDTO;
import com.camila.clientes.model.entity.Client;
import com.camila.clientes.model.entity.ServiceRendered;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;

@NoArgsConstructor( access = AccessLevel.PRIVATE )
public class ServiceMapper {

    public static ServiceDTO toServiceDTO( ServiceRendered service ) {
        return ServiceDTO.builder()
                .id( service.getId() )
                .description( service.getDescription() )
                .client( service.getClient().getName() )
                .value( service.getValue().toString() )
                .date( service.getDate().format( DateTimeFormatter.ofPattern( "dd/MM/yyyy" ) ) )
                .build();


    }


    public static ServiceRendered toService( ServiceDTO serviceDTO, Client cliente ) {

        LocalDate data = LocalDate.parse( serviceDTO.getDate(), DateTimeFormatter.ofPattern( "yyyy-MM-dd" ) );

        return ServiceRendered.builder()
                .id( serviceDTO.getId() )
                .description( serviceDTO.getDescription() )
                .value( converter( serviceDTO.getValue() ) )
                .client( cliente )
                .date( data )
                .build();


    }

    public static BigDecimal converter(String value) {
        if( Objects.isNull( value ) ) {
            return null;
        }
        value = value.replace( ".", "" ).replace( ",", "." );
        return new BigDecimal( value );
    }

    public static ServiceDTO userDetailsDto( String description, String client ) {
        return ServiceDTO.builder()
                .description( description )
                .client(  client )
                .build();
    }

    public static ServiceRendered userDetailsDtos( String description, Client client ) {
        return ServiceRendered.builder()
                .description( description )
                .client( client )
                .build();
    }


    public static Pageable getPageable( PageableDTO pageableDto ) {
        return PageRequest.of( pageableDto.getPageNumber(), pageableDto.getPageSize(),
                Sort.Direction.fromString( pageableDto.getSortDirection() ), pageableDto.getSortField() );
    }
}
