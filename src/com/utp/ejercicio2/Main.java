/*
 */
package com.utp.ejercicio2;


import java.util.Scanner;

/**
 * version 2.0 2022.02.27
 * @authors
 * FERNANDEZ DELGADO, RODY ALBERTO (U21203959)
 * YARANGO VILLANUEVA, JORGE EDIXON (U20218896)
 * 
 */
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        int tamano = 0;
        
        do {
            System.out.print("Ingrese la cantidad de pacientes de la Pila :");
            tamano = teclado.nextInt();
        } while (tamano <= 0);
        
        Pila pila = new Pila(tamano);
        
        
        do {            
        System.out.println("\n\n+-----------------------------------------+----------------------------------------+\n" +
                            "| MENU PILA ESTATICA DE PACIENTES                                                   |\n" +
                            "+-----------------------------------------+-----------------------------------------+\n" +
                            "| 1.Ingresar nuevo paciente a Pila (PUSH) | 5.Mostrar tamano de la Pila             |\n" +
                            "| 2.Mostrar paciente en la cima (PEEK)    | 6.Buscar paciente en Pila               |\n" +
                            "| 3.Retirar paciente de la cima (POP)     | 7.Salir                                 |\n" +
                            "| 4.Imprimir objetos de la Pila           |                                         |\n" +
                            "+-----------------------------------------+-----------------------------------------+\n");
        System.out.print("Ingrese la opcion elegida :");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("\nIngrese el id del cliente :");
                    int id = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Ingrese el nombre del cliente :");
                    String nombre = teclado.nextLine();
                    teclado.nextLine();
                    System.out.print("Ingrese el apellido del cliente :");
                    String apellido = teclado.nextLine();
                    teclado.nextLine();
                    System.out.print("Ingrese el correo del cliente :");
                    String correo = teclado.next();
                    System.out.print("\nIngrese el DNI del cliente :");
                    int dni = teclado.nextInt();
                    System.out.print("\nIngrese el id Historia del cliente :");
                    int id_historia = teclado.nextInt();
                    System.out.print("\nIngrese el telefono del cliente :");
                    int telefono = teclado.nextInt();
                    teclado.nextLine();
                    pila.push(id, nombre, apellido, correo, dni, id_historia, telefono);
                    break;
                case 2:
                    pila.peek();
                    break;
                case 3:
                    pila.pop();
                    break;
                case 4:
                    pila.print();
                    break;
                case 5:
                    System.out.println("\nLa Pila tiene un total de " + pila.size() + " pacientes");
                    break;
                case 6:
                    System.out.println("Ingrese DNI: ");
                    int dniAux = teclado.nextInt();
                    pila.search(dniAux);
                    break;
                case 7:
                    System.out.println("\n*** Gracias por utilizar la aplicacion ***");
                    break;
                default:
                    System.out.println("¡Opcion incorrecta!");
                    break;
            }
        } while (opcion != 7);
    }
}
