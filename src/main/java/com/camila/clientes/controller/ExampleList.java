package com.camila.clientes.controller;

import net.bytebuddy.description.type.TypeList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ExampleList {

    public static void main( String[] args ) {
        List<String> nomes = new ArrayList<>();
        nomes.add("CAmila");
        nomes.add("Maria");
        nomes.add("Anderson");
        nomes.add("Joao");
        nomes.add("Pedro");

        System.out.println( nomes );
        nomes.set( 2, "Larissa" );

        System.out.println( nomes );

        Collections.sort(nomes);
        nomes.set( 2, "Wesley" );
        System.out.println( nomes );

        nomes.remove( "Wesley" );
        System.out.println( nomes );

        String nome = nomes.get(3);
        System.out.println( nome );


        int tamanho = nomes.size();
        System.out.println( tamanho );

        for (String nomeItem: nomes) {
            System.out.println("--->"+ nomeItem);
        }

        Iterator<String> itarator = nomes.iterator();
        while( itarator.hasNext() ) {
            System.out.println("******> " + itarator.next());
        }
        //recebe um inteiro e um elemento
        //nomes.set(  )
    }
}
