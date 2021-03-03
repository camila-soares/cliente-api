package com.camila.clientes.model.repository;

import com.camila.clientes.model.entity.ServiceRendered;
import com.camila.clientes.model.service.filter.ServiceFilter;
import com.camila.clientes.model.service.specification.ServiceRenderedSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


import static org.springframework.data.jpa.domain.Specification.where;

@Repository
public interface ServiceRenderedRepository extends JpaRepository< ServiceRendered, Long >, JpaSpecificationExecutor< ServiceRendered > {
    default Page< ServiceRendered > getAll( ServiceFilter filter, Pageable pageable ) {
        Specification spec = where( ServiceRenderedSpecification.description( filter.getDescription() )
        .and( ServiceRenderedSpecification.client( filter.getClient() ) ));
        return findAll( spec, pageable );
    }

}
