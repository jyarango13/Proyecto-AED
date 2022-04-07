/*
 */
package com.utp.ejercicio1;

import javax.swing.table.DefaultTableModel;

/**
 * version 2.0 2022.02.27
 * @authors
 * FERNANDEZ DELGADO, RODY ALBERTO (U21203959)
 * YARANGO VILLANUEVA, JORGE EDIXON (U20218896)
 * 
 */
public class Cliente {
    
    //Atributos
    private int id;
    private String nombre;
    private String apellido;
    private int dni;
    private int telefono;
    private String correo;
    private String direcccion;
    
    //Métodos

    public Cliente() {
    }

    public Cliente(int id, String nombre, String apellido, int dni, int telefono, String correo, String direcccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
        this.direcccion = direcccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDirecccion() {
        return direcccion;
    }

    public void setDirecccion(String direcccion) {
        this.direcccion = direcccion;
    }

    @Override
    public String toString() {
        return "Cliente: "+ id + "\n Nombre: " + nombre + " , Apellido: " + apellido + " , DNI: " + dni + " , Telefono: " + telefono + " , Correo: " + correo + " , Direcccion: " + direcccion ;
    }
    
    //Para tablemodel
    public String[] elementos(){
        String lista[]=new String[7];
        lista[0]=String.valueOf(id);
        lista[1]=nombre;
        lista[2]=apellido;
        lista[3]=String.valueOf(dni);
        lista[4]=String.valueOf(telefono);
        lista[5]=correo;
        lista[6]=direcccion;
        return lista;
    }
    
  
    
}
