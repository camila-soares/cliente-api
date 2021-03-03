package com.camila.clientes.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( nullable = false, length = 150 )
    private String name;

    @Column( nullable = false, length = 11 )
    private String cpf;

    @Column( name = "DT_CADASTRO" )
    private LocalDate dateRegistration;

    @OneToMany
    private List< ServiceRendered> service;

    @PrePersist
    @JsonFormat(pattern="dd/MM/yyyy")
    public void prePersist(){
        setDateRegistration( LocalDate.now() );
    }

}
