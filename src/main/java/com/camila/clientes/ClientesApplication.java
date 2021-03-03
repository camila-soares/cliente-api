package com.camila.clientes;

import com.camila.clientes.model.entity.Client;
import com.camila.clientes.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ClientesApplication {

    @Bean
    public CommandLineRunner run( @Autowired ClientRepository repository ) {
        return args -> {
            Client cliente1 = Client.builder().cpf( "08146639402" ).name( "CAMILA" ).build();
            Client cliente2 = Client.builder().cpf( "99765147007" ).name( "FULANO" ).build();
            Client cliente3 = Client.builder().cpf( "30071081011" ).name( "FULANO" ).build();
            Client cliente4 = Client.builder().cpf( "04070878009" ).name( "FULANO" ).build();
            Client cliente5 = Client.builder().cpf( "19603299014" ).name( "FULANO" ).build();
            Client cliente6 = Client.builder().cpf( "71290298033" ).name( "FULANO" ).build();
            Client cliente7 = Client.builder().cpf( "36085029047" ).name( "FULANO" ).build();
            Client cliente8 = Client.builder().cpf( "31134652062" ).name( "FULANO" ).build();
            Client cliente9 = Client.builder().cpf( "15023947076" ).name( "FULANO" ).build();
            Client cliente10 = Client.builder().cpf( "30293318069" ).name( "FULANO" ).build();
            //Client cliente11 = Client.builder().cpf( "98267690026" ).name( "FULANO" ).build();

            //Client cliente12 = Client.builder().cpf( "42028952075" ).name( "FULANO" ).build();
            //Client cliente13 = Client.builder().cpf( "24445032018" ).name( "FULANO" ).build();
            //Client cliente14 = Client.builder().cpf( "09310492023" ).name( "FULANO" ).build();
            //Client cliente15 = Client.builder().cpf( "15697674082" ).name( "FULANO" ).build();
            //Client cliente16 = Client.builder().cpf( "59931729082" ).name( "FULANO" ).build();
            //Client cliente17 = Client.builder().cpf( "67950826010" ).name( "FULANO" ).build();
            //Client cliente18 = Client.builder().cpf( "33613661004" ).name( "FULANO" ).build();
            //Client cliente19 = Client.builder().cpf( "75084384004" ).name( "FULANO" ).build();
            // Client cliente20 = Client.builder().cpf( "69908376080" ).name( "FULANO" ).build();
            //Client cliente21 = Client.builder().cpf( "68874785011" ).name( "FULANO" ).build();



            List<Client> list = new ArrayList<Client>();
            list.add( cliente1 );
            list.add( cliente2 );
            list.add( cliente3 );
            list.add( cliente4 );
            list.add( cliente5 );
            list.add( cliente6 );
            list.add( cliente7 );
            list.add( cliente8 );
            list.add( cliente9 );
            list.add( cliente10 );
            //list.add( cliente11 );


            //list.add( cliente12 );

            //list.add( cliente13 );

            //list.add( cliente14 );

            //list.add( cliente15 );

            //list.add( cliente16 );

            //list.add( cliente17 );

            //list.add( cliente18 );

            //list.add( cliente19 );

            //list.add( cliente20 );

            //list.add( cliente21 );
            repository.saveAll( list );




        };
    }

    public static void main( String[] args ) {
        SpringApplication.run( ClientesApplication.class, args );
    }
}
