package com.camila.clientes.model.service.specification;

import com.camila.clientes.model.entity.Client;
import com.camila.clientes.model.entity.ServiceRendered;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import java.util.Objects;

@UtilityClass
public class ServiceRenderedSpecification {

    public Specification< ServiceRendered > description( String description ) {
        return ( root, criteriaQuery, criteriaBuilder ) -> {
            if( Objects.isNull( description ) ) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal( root.get( "description" ), description );
        };
    }

    public Specification< ServiceRendered > client( String name ) {
        return ( root, criteriaQuery, criteriaBuilder ) -> {
            if( Objects.isNull( name ) ) {
                return criteriaBuilder.conjunction();
            }
            Join< ServiceRendered, Client > joinServiceClient = root.join( "client" );

            return criteriaBuilder.equal( joinServiceClient.get( "name" ), name );
        };
    }


}
