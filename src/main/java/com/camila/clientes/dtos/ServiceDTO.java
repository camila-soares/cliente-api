package com.camila.clientes.dtos;

import com.camila.clientes.model.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDTO {
    private Long id;
    @NotEmpty( message =  "{MSG004}" )
    private String description;
    @NotNull( message = "{MSG006}")
    private Long idCliente;
    private String client;
    @NotEmpty( message = "{MSG005}")
    private String value;
    private String date;
}
