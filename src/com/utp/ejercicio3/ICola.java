/*
 */
package com.utp.ejercicio3;


/**
 * version 2.0 2022.02.27
 * @authors
 * FERNANDEZ DELGADO, RODY ALBERTO (U21203959)
 * YARANGO VILLANUEVA, JORGE EDIXON (U20218896)
 * 
 */
public interface ICola <Trabajador> {
    
    public abstract boolean isEmpty();
    public abstract void offer(String nombre, int tipo, int horas);
    public abstract void peek();
    public abstract void poll();
    public abstract void search(String nombre);
    public abstract String print();
    public abstract int size();
    public abstract void pollSpecial(String name); // Retira objeto de cualquier posición y mantiene el orden de la Cola
}
