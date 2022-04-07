/*
 */
package com.utp.ejercicio1;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 * version 2.0 2022.02.27
 * @authors
 * FERNANDEZ DELGADO, RODY ALBERTO (U21203959)
 * YARANGO VILLANUEVA, JORGE EDIXON (U20218896)
 * 
 */
public class Cola implements ICola<Cliente> {

    //Atributos
    private Nodo inicio;
    private Nodo fin;
    int size = 0;

    //Constructor
    public Cola() {
        inicio = null;
        fin = null;
    }

    @Override
    public boolean isEmpty() {
        return inicio == null;
    }

    @Override
    public void offer(int id, String nombre, String apellido, int dni, int telefono, String correo, String direcccion) {
        Nodo nodo = new Nodo();
        Cliente cliente = new Cliente(id, nombre, apellido, dni, telefono, correo, direcccion);
        nodo.objeto = cliente;
        nodo.siguiente = null;

        if (isEmpty()) {
            inicio = nodo;
            fin = nodo;
        } else {
            fin.siguiente = nodo;
            fin = nodo;
        }
        size++;
        JOptionPane.showMessageDialog(null, "Se ingreso un nuevo cliente: \n " + nodo.objeto.toString(), "NUEVO INGRESO", JOptionPane.INFORMATION_MESSAGE);
        //System.out.println("*** Se ingreso a la Cola el cliente con los siguientes atributos :\n" + nodo.objeto.toString() + " ***");
    }

    @Override
    public void peek() {
        if (isEmpty()) {
            // System.out.println("*** La Cola está vacia ***");
            JOptionPane.showMessageDialog(null, "La cola esta vacia", null, JOptionPane.ERROR_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "El primer cliente de la cola es: " + inicio.objeto.toString(), "PRIMERO DE LA COLA", JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("*** En el inicio de la Cola se encuentra el cliente con los siguientes datos :\n" + inicio.objeto.toString() + " ***");
        }
    }

    @Override
    public void poll() {
        Nodo nodo =  inicio;
        if (isEmpty()) {
            //System.out.println("*** La Cola está vacia ***");
            JOptionPane.showMessageDialog(null, "La cola esta vacia", null, JOptionPane.ERROR_MESSAGE);
        } else {
            if (inicio == fin) {
                inicio = null;
                fin = null;
            } else {
                inicio = inicio.siguiente;
            }
            JOptionPane.showMessageDialog(null, "Ha sido retirado del inicio de la Cola el cliente con los siguientes datos :\n " + nodo.objeto.toString(), "ELIMINAR ", JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("*** Ha sido retirado del inicio de la Cola el cliente con los siguientes datos :\n" + nodo.objeto.toString() + " ***");
            size--;
        }
    }

    @Override
    public void search(int id) {
        Nodo nodo=inicio;
        boolean encontrado = false;

        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "La cola esta vacia", null, JOptionPane.ERROR_MESSAGE);
            // System.out.println("*** La Cola está vacia ***");
        } else {
            while (nodo != fin.siguiente && encontrado != true) {
                if (nodo.objeto.getId() == id) {
                                        JOptionPane.showMessageDialog(null, "El cliente con nombre :\"" + id + "\" ha sido encontrado.\n Los datos del cliente son los siguientes :" + nodo.objeto.toString(), "CLIENTE ENCONTRADO ", JOptionPane.INFORMATION_MESSAGE);
                   // System.out.println("El cliente con id :\"" + id + "\" ha sido encontrado. Los datos del cliente son los siguientes :");
                    //System.out.println(nodo.objeto.toString());
                    encontrado = true;
                }
                nodo = nodo.siguiente;
            }
            if (encontrado != true) {
                                JOptionPane.showMessageDialog(null, "El cliente con nombre :\"" + id + "\" NO ha sido encontrado.", null, JOptionPane.ERROR_MESSAGE);
                //System.out.println("El cliente con id :\"" + id + "\" NO ha sido encontrado");
            }
        }

    }

    @Override
    public void search(String nombre) {
        Nodo nodo = inicio;
        boolean encontrado = false;

        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "La cola esta vacia", null, JOptionPane.ERROR_MESSAGE);
            //System.out.println("*** La Cola está vacia ***");
        } else {
            while (nodo != fin.siguiente && encontrado != true) {
                if (nodo.objeto.getNombre().equals(nombre)) {
                    JOptionPane.showMessageDialog(null, "El cliente con nombre :\"" + nombre + "\" ha sido encontrado.\n Los datos del cliente son los siguientes :" + nodo.objeto.toString(), "CLIENTE ENCONTRADO ", JOptionPane.INFORMATION_MESSAGE);
                    //System.out.println("El cliente con nombre :\"" + nombre + "\" ha sido encontrado. Los datos del cliente son los siguientes :");
                    //System.out.println(nodo.objeto.toString());
                    encontrado = true;
                }
                nodo = nodo.siguiente;
            }
            if (encontrado != true) {
                JOptionPane.showMessageDialog(null, "El cliente con nombre :\"" + nombre + "\" NO ha sido encontrado.", null, JOptionPane.ERROR_MESSAGE);
                // System.out.println("El cliente con nombre :\"" + nombre + "\" NO ha sido encontrado");
            }
        }
    }

    public String print() {
        Nodo nodo =inicio;
        String elementos = " ";
        String imprimir = "";

        if (isEmpty()) {
            imprimir += "*** La Cola está vacia ***";
        } else {
            while (nodo != null) {
                elementos += nodo.objeto.toString() + " =>\n ";
                nodo = nodo.siguiente;
            }
            imprimir += "*** En la Cola se encuentran los siguienes clientes : ***\n";
            imprimir += elementos + "\n";
        }
        return imprimir;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void pollSpecial(int id) {
        Nodo nodo =  inicio;
        Nodo anterior = null;
        boolean encontrado = false;

        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "La cola esta vacia", null, JOptionPane.ERROR_MESSAGE);
            //System.out.println("*** La Cola está vacía ***");
        } else {
            while (nodo != null && encontrado != true) {
                if (nodo.objeto.getId() == id) {
                    if (nodo == inicio) {
                        inicio = inicio.siguiente;
                    } else if (nodo == fin) {
                        anterior.siguiente = null;
                        fin = anterior;
                    } else {
                        anterior.siguiente = nodo.siguiente;
                    }
                    System.out.println("*** El cliente con id :\"" + id + "\" ha sido retirado de la Cola. Los clientes restantes mantienen su posicion sin alterar el orden ***");
                    encontrado = true;
                    size--;
                }
                anterior = nodo;
                nodo = nodo.siguiente;
            }
            if (!encontrado) {
                System.out.println("*** El cliente con id :\"" + id + "\" NO ha sido encontrado ***");
            }
        }
    }
    
    //para TableModel
      public void lista(DefaultTableModel dtm){
          Nodo nodo = inicio;
        while(nodo!=null){
            dtm.addRow(nodo.objeto.elementos());
            nodo=nodo.siguiente;
        }
        
    }

    @Override
    public void pollSpecial(String nombre) {
        Nodo nodo =inicio;
        Nodo anterior = null;
        boolean encontrado = false;

        if (isEmpty()) {
            System.out.println("*** La Cola está vacía ***");
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
                    JOptionPane.showMessageDialog(null, "El cliente con nombre :\"" + nombre + "\" ha sido eliminado.\n Los datos del cliente son los siguientes :" + nodo.objeto.toString(), "CLIENTE ELIMINADO ", JOptionPane.INFORMATION_MESSAGE);
                    //System.out.println("*** El cliente de nombre :\"" + nombre + "\" ha sido retirado de la Cola. Los clientes restantes mantienen su posición sin alterar el orden ***");
                    encontrado = true;
                    size--;
                }
                anterior = nodo;
                nodo = nodo.siguiente;
            }
            if (!encontrado) {
                System.out.println("*** El cliente de nombre :\"" + nombre + "\" NO ha sido encontrado ***");
            }
        }
    }

}
