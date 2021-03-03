package com.camila.clientes.model.repository;

import com.camila.clientes.model.entity.Client;
import com.camila.clientes.model.service.filter.ClientFilter;
import com.camila.clientes.model.service.specification.ClientSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static org.springframework.data.jpa.domain.Specification.where;

@Repository
public interface ClientRepository extends JpaRepository< Client, Long >, JpaSpecificationExecutor< Client > {
    Optional< Client > findClientByCpf( String cpf );

    default Page< Client > getAll( ClientFilter filter, Pageable pageable ) {
        Specification spec = where( ClientSpecification.cpf( filter.getCpf() ) )
                .and( ClientSpecification.name( filter.getName() ) );
        return findAll( spec, pageable );
    }
}
