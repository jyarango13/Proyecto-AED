/*
 */
package com.utp.ejercicio3;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * version 2.0 2022.02.27
 * @authors
 * FERNANDEZ DELGADO, RODY ALBERTO (U21203959)
 * YARANGO VILLANUEVA, JORGE EDIXON (U20218896)
 * 
 */
public class Cola3 implements ICola<Trabajador> {

    //Atributos
    private Nodo inicio;
    private Nodo fin;
    int size = 0;

    //Constructor
    public Cola3() {
        inicio = null;
        fin = null;
    }

    @Override
    public boolean isEmpty() {
        return inicio == null;
    }

    @Override
    public void offer(String nombre, int tipo, int horas) {
        Nodo nodo = new Nodo();
        Trabajador trabajador = new Trabajador(nombre, tipo, horas);
        nodo.objeto = trabajador;
        nodo.siguiente = null;

        if (isEmpty()) {
            inicio = nodo;
            fin = nodo;
        } else {
            fin.siguiente = nodo;
            fin = nodo;
        }
        size++;
        JOptionPane.showMessageDialog(null, "Se ingreso un nuevo trabajador: \n " + nodo.objeto.toString(), "NUEVO INGRESO", JOptionPane.INFORMATION_MESSAGE);
        //System.out.println("*** Se ingreso a la Cola3 el trabajador con los siguientes datos :\n" + nodo.objeto.toString() + " ***");
    }

    @Override
    public void peek() {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "La cola esta vacia", null, JOptionPane.ERROR_MESSAGE);
            //System.out.println("*** La Cola3 está vacia ***");
        } else {
            JOptionPane.showMessageDialog(null, "El primer trabajador de la cola es: " + inicio.objeto.toString(), "PRIMERO DE LA COLA", JOptionPane.INFORMATION_MESSAGE);
            // System.out.println("*** En el inicio de la Cola3 se encuentra el trabajador con los siguientes datos :\n" + inicio.objeto.toString() + " ***");
        }
    }

    //@Override
    public void poll() {
        Nodo nodo = inicio;
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "La cola esta vacia", null, JOptionPane.ERROR_MESSAGE);
            //System.out.println("*** La Cola3 está vacia ***");
        } else {
            if (inicio == fin) {
                inicio = null;
                fin = null;
            } else {
                inicio = inicio.siguiente;
            }
            JOptionPane.showMessageDialog(null, "Ha sido retirado del inicio de la Cola el trabajador con los siguientes datos :\n " + nodo.objeto.toString(), "ELIMINAR ", JOptionPane.INFORMATION_MESSAGE);
            // System.out.println("*** Ha sido retirado del inicio de la Cola3 el trabajador con los siguientes datos :\n" + nodo.objeto.toString() + " ***");
            size--;
        }
    }

    @Override
    public void search(String nombre) {
        Nodo nodo =  inicio;
        boolean encontrado = false;

        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "La cola esta vacia", null, JOptionPane.ERROR_MESSAGE);
            //System.out.println("*** La Cola3 está vacia ***");
        } else {
            while (nodo != fin.siguiente && encontrado != true) {
                if (nodo.objeto.getNombre().equals(nombre)) {
                    JOptionPane.showMessageDialog(null, "El trabajador con nombre :\"" + nombre + "\" ha sido encontrado.\n Los datos del trabajador son los siguientes :" + nodo.objeto.toString(), "TRABAJADOR ENCONTRADO ", JOptionPane.INFORMATION_MESSAGE);
                    //System.out.println("El trabajador con nombre :\"" + nombre + "\" ha sido encontrado. Los datos del trabajador son los siguientes :");
                    //System.out.println(nodo.objeto.toString());
                    encontrado = true;
                }
                nodo = nodo.siguiente;
            }
            if (encontrado != true) {
                JOptionPane.showMessageDialog(null, "El trabajador con nombre :\"" + nombre + "\" NO ha sido encontrado.", null, JOptionPane.ERROR_MESSAGE);
                //System.out.println("El trabajador con nombre :\"" + nombre + "\" NO ha sido encontrado");
            }
        }
    }

    public String print() {
        Nodo nodo =inicio;
        String elementos = " ";
        String imprimir = "";

        if (isEmpty()) {
            imprimir += "*** La Cola está vacia ***\n";
        } else {
            while (nodo != null) {
                elementos += nodo.objeto.toString() + " =>\n ";
                nodo = nodo.siguiente;
            }

            imprimir += "En la Cola se encuentran los siguienes trabajadores :\n";
            imprimir += elementos + "\n";
        }
        return imprimir;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void pollSpecial(String nombre) {
        Nodo nodo= inicio;
        Nodo anterior  = null;
        boolean encontrado = false;

        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "La cola esta vacia", null, JOptionPane.ERROR_MESSAGE);
            // System.out.println("*** La Cola3 está vacía ***");
        } else {
            while (nodo != null && encontrado != true) {
                if (nodo.objeto.getNombre().equals(nombre)) {
                    if (nodo == inicio) {
                        inicio = inicio.siguiente;
                    } else if (nodo == fin) {
                        anterior.siguiente = null;
                        fin = anterior;
                    } else {
                        anterior.siguiente = nodo.siguiente;
                    }
                    JOptionPane.showMessageDialog(null, "El trabajador con nombre :\"" + nombre + "\" ha sido retirado de la Cola.", "TRABAJADOR ELIMINADO ", JOptionPane.INFORMATION_MESSAGE);
                    //System.out.println("*** El trabajador de nombre :\"" + nombre + "\" ha sido retirado de la Cola3. Los trabajadores restantes permanecen sin alterar el orden ***");
                    encontrado = true;
                    size--;
                }
                anterior = nodo;
                nodo = nodo.siguiente;
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "El trabajador con nombre :\"" + nombre + "\" NO ha sido encontrado.", null, JOptionPane.ERROR_MESSAGE);
                //System.out.println("*** El trabajador de nombre :\"" + nombre + "\" NO ha sido encontrado ***");
            }
        }
    }

    public void mayorSueldo() {
        Nodo nodo = inicio;
        double mayor = 0.0;
        String auxNombre = "";

        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "La cola esta vacia", null, JOptionPane.ERROR_MESSAGE);
            //System.out.println("*** La Cola3 está vacia ***");
        } else {
            while (nodo != fin.siguiente) {
                if (nodo.objeto.getSueldoSemanal() > mayor) {
                    mayor = nodo.objeto.getSueldoSemanal();
                    auxNombre = nodo.objeto.getNombre();
                }
                nodo = nodo.siguiente;
            }
            JOptionPane.showMessageDialog(null, "El trabajador con mayor sueldo es:\"" + auxNombre + "\" con un sueldo semanal de : S/." + mayor, null, JOptionPane.INFORMATION_MESSAGE);
            // System.out.println("El trabajador con mayor sueldo es " + auxNombre + " con un sueldo semanal de :S/" + mayor);
        }
    }

      public  double gastoTrabajadores() {

        Nodo nodo =  inicio;
        double total = 0.0;
        if (isEmpty()) {
            
           // JOptionPane.showMessageDialog(null, "La cola esta vacia", null, JOptionPane.ERROR_MESSAGE);
            //System.out.println("*** La Cola está vacia ***");
        } else {
                while (nodo != fin.siguiente) {
                    total += nodo.objeto.getSueldoSemanal();
                    nodo = nodo.siguiente;
                }
        }
        return total;
    }
         public void lista(DefaultTableModel dtm){
          Nodo nodo = inicio;
        while(nodo!=null){
            dtm.addRow(nodo.objeto.elementos());
            nodo=nodo.siguiente;
        }
        
    }
}
