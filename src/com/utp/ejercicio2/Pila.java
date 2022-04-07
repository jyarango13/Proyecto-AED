/*
 */
package com.utp.ejercicio2;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * version 2.0 2022.02.27
 *
 * @authors FERNANDEZ DELGADO, RODY ALBERTO (U21203959) YARANGO VILLANUEVA,
 * JORGE EDIXON (U20218896)
 *
 */
public class Pila implements IPila {

    // Atributos
    private Paciente[] pacientes;
    private int cantidadPacientes;
    private int cima;

    //Constructor
    public Pila(int cantidadNumeros) {
        this.cantidadPacientes = cantidadNumeros;
        pacientes = new Paciente[cantidadNumeros];
        cima = -1;
    }

    @Override
    public boolean isEmpty() {
        return cima == -1;
    }

    @Override
    public void push(int id, String nombre, String apellido, String correo, int dni, int id_historia, int telefono) {
        if (cima < cantidadPacientes - 1) {
            cima++;
            Paciente paciente = new Paciente(id, nombre, apellido, correo, dni, id_historia, telefono);
            pacientes[cima] = paciente;
            JOptionPane.showMessageDialog(null, "Se ingreso el paciente :" + pacientes[cima].toString(), "INGRESO PACIENTE", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "La pila ya se encuentra llena. No se pudo ingresar al paciente.", "ERROR", JOptionPane.ERROR_MESSAGE);
            //System.out.println("La pila ya se encuentra llena. No se pudo ingresar al paciente\n");
        }
    }

    @Override
    public void peek() {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "La Pila se encuentra vacia", "ERROR", JOptionPane.ERROR_MESSAGE);
            //System.out.println("La Pila se encuentra vacia");
        } else {
            JOptionPane.showMessageDialog(null, "El paciente que se encuentra en la cima de la Pila es :" + pacientes[cima].toString(), "PRIMER PACIENTE", JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("El paciente que se encuentra en la cima de la Pila es :" + pacientes[cima].toString());
        }
    }

    @Override
    public void pop() {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "La Pila se encuentra vacia", "ERROR", JOptionPane.ERROR_MESSAGE);
            //System.out.println("La Pila se encuentra vacia");
        } else {
            Paciente aux = pacientes[cima];
            pacientes[cima] = null;
            cima--;
            JOptionPane.showMessageDialog(null, "El paciente :" + aux.toString() + " ha sido retirado de la Pila", "ELIMINAR PACIENTE", JOptionPane.INFORMATION_MESSAGE);
            // System.out.println("El paciente :" + aux.toString() + " ha sido retirado de la Pila");
        }
    }

    @Override
    public void search(int dni) {
        boolean encontrado = false;
        if (isEmpty()) {
            System.out.println("La Pila se encuentra vacia");
        } else {
            for (int i = 0; i < cima + 1; i++) {
                if (pacientes[i].getDni() == dni) {
                    JOptionPane.showMessageDialog(null, "Paciente encontrado. Datos :" + pacientes[i].toString(), "BUSQUEDA PACIENTE", JOptionPane.INFORMATION_MESSAGE);
                    //System.out.println("Paciente encontrado. Datos :" + pacientes[i].toString());
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "Paciente con DNI :" + dni + " NO ha sido encontrado en la Pila", "ERROR", JOptionPane.ERROR_MESSAGE);
                //System.out.println("Paciente con DNI :" + dni + " NO ha sido encontrado en la Pila");
            }
        }
    }

    @Override
    public String print() {
        String imprimir = "";
        if (isEmpty()) {
            imprimir += "La Pila se encuentra vacia";
        } else {
            imprimir += "Los elementos de la Pila son los siguientes :\n";
            for (int i = cima; i > -1; i--) {
                imprimir += "• " + pacientes[i].toString() + "\n";
            }
        }
        return imprimir;
    }

    @Override
    public int size() {
        return (cima + 1);
    }

    public void lista(DefaultTableModel dtm) {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pila vacia", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            for (int i = cima; i > -1; i--) {
                dtm.addRow(pacientes[i].elementos());
            }
        }

    }
}
