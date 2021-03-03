package com.camila.clientes.controller;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ExemploLinkedList {

    public static void main( String[] args ) {
        Queue<String> filaBanco = new LinkedList<>();

        filaBanco.add( "Pamela" );
        filaBanco.add( "Patricia" );
        filaBanco.add( "Roberto" );
        filaBanco.add( "Fabio" );
        filaBanco.add( "Anderson" );

        System.out.println(filaBanco);

        String clienteAtendido = filaBanco.poll();
        System.out.println(clienteAtendido);
        System.out.println(filaBanco);

        String primeiroCliente = filaBanco.peek();
        String f = filaBanco.element();

        System.out.println(primeiroCliente);
        System.out.println(filaBanco);

    }
}
