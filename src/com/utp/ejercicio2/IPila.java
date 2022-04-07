/*
 */
package com.utp.ejercicio2;


/**
 * version 2.0 2022.02.27
 * @authors
 * FERNANDEZ DELGADO, RODY ALBERTO (U21203959)
 * YARANGO VILLANUEVA, JORGE EDIXON (U20218896)
 * 
 */
public interface IPila <Paciente> {
    
    public abstract boolean isEmpty();
    public abstract void push(int id, String nombre, String apellido, String correo, int dni, int id_historia, int telefono);
    public abstract void peek();
    public abstract void pop();
    public abstract void search(int dni);
    public abstract String print();
    public abstract int size();
    
}
