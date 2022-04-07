/*
 */
package com.utp.ejercicio3;

import java.util.Scanner;

/**
 * version 2.0 2022.02.27
 * @authors
 * FERNANDEZ DELGADO, RODY ALBERTO (U21203959)
 * YARANGO VILLANUEVA, JORGE EDIXON (U20218896)
 * 
 */
public class MainMenu {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Cola3 cola = new Cola3();
        int opcion = 0;
        int tipo = 0;
        int horas = 0;

        do {
            System.out.println("\n\n+-------------------------------------------+-------------------------------------------+\n"
                    + "| MENU COLA DINAMICA DE OBJETOS                                                         |\n"
                    + "+-------------------------------------------+-------------------------------------------+\n"
                    + "| 1.Ingresar nuevo trabajador a Cola (OFFER)| 5.Imprimir trabajadores en la Cola        |\n"
                    + "| 2.Mostrar trabajador inicial Cola (PEEK)  | 6.Mostrar tamano de la Cola               |\n"
                    + "| 3.Retirar trabajador atendido (POLL)      | 7.Retirar trabjador especifico de la Cola |\n"
                    + "| 4.Buscar trabajador por \"nombre\"          | 8.Trabajador con MAYOR SUELDO             |\n"
                    + "|                                           | 9.Salir                                   |\n"
                    + "+-------------------------------------------+-------------------------------------------+\n");
            System.out.print("Ingrese la opcion elegida :");
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del trabajador :");
                    String nombre = teclado.nextLine();
                    do {
                        System.out.println("\nIngrese la opcion segun el tipo de trabajador :\n 1. Auxiliar\n 2. Obstetra\n 3. Medico\n 4. Cirujano");
                        tipo = teclado.nextInt();
                    } while (tipo < 1 || tipo > 4);
                    do {
                        System.out.print("\nIngrese las horas que trabajo durante la semana :");
                        horas = teclado.nextInt();
                    } while (horas < 10 || horas > 60);
                    cola.offer(nombre, tipo, horas);
                    break;
                case 2:
                    cola.peek();
                    break;
                case 3:
                    cola.poll();
                    break;
                case 4:
                    System.out.print("\nIngrese el nombre del trabajador :");
                    String nameAux = teclado.nextLine();
                    teclado.nextLine();
                    cola.search(nameAux);
                    break;
                case 5:
                    cola.print();
                    break;
                case 6:
                    System.out.println("\nLa Cola tiene un total de " + cola.size() + " trabajadores esperando");
                    break;
                case 7:
                    System.out.print("\nIngrese el nombre del objeto a eliminar :");
                    String nameAuxSpecial = teclado.nextLine();
                    teclado.nextLine();
                    cola.pollSpecial(nameAuxSpecial);
                    break;
                case 8:
                    cola.mayorSueldo();
                    break;
                case 9:
                    System.out.println("\n*** Gracias por utilizar la aplicacion ***");
                    break;
                default:
                    System.out.println("¡Opcion incorrecta!");
                    break;
            }
        } while (opcion != 9);
    }
}
