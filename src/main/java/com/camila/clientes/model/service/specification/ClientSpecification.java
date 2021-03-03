package com.camila.clientes.model.service.specification;

import com.camila.clientes.model.entity.Client;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;
@UtilityClass
public class ClientSpecification {

        public Specification< Client > cpf( String cpf ) {
            return ( root, criteriaQuery, criteriaBuilder ) -> {
                if( Objects.isNull( cpf ) ) {
                    return criteriaBuilder.conjunction();
                }
                return criteriaBuilder.equal( root.get( "cpf" ), cpf );
            };
        }

        public Specification< Client > name( String name ) {
            return ( root, criteriaQuery, criteriaBuilder ) -> {
                if( Objects.isNull( name ) ) {
                    return criteriaBuilder.conjunction();
                }
                return criteriaBuilder.equal( root.get( "name" ), name );
            };
        }

}
