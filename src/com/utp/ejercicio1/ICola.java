/*
 */
package com.utp.ejercicio1;

/**
 * version 2.0 2022.02.27
 * @authors
 * FERNANDEZ DELGADO, RODY ALBERTO (U21203959)
 * YARANGO VILLANUEVA, JORGE EDIXON (U20218896)
 * 
 */
public interface ICola <Cliente> {
    
    public abstract boolean isEmpty();
    public abstract void offer(int id, String nombre, String apellido, int dni, int telefono, String correo, String direcccion);
    public abstract void peek();
    public abstract void poll();
    public abstract void search(int id);
    public abstract void search(String nombre);
    public abstract String print();
    public abstract int size();
    public abstract void pollSpecial(int id); // Retira cliente de cualquier posición y mantiene el orden de la cola
    public abstract void pollSpecial(String name); // Retira cliente de cualquier posición y mantiene el orden de la cola
}
