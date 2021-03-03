package com.camila.clientes.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private Long id;

    @NotEmpty( message = "{MSG001}")
    private String name;

    @NotNull( message = "{MSG001}")
    @CPF(message = "{MSG003}")
    private String cpf;


    @DateTimeFormat( pattern = "dd/MM/yyyy")
    private LocalDate dateRegistration;
}
