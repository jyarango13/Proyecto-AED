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
public class Paciente {
    
    //Atributos
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private int dni;
    private int id_historia;
    private int telefono;

    //Métodos
    public Paciente() {
    }

    public Paciente(int id, String nombre, String apellido, String correo, int dni, int id_historia, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.dni = dni;
        this.id_historia = id_historia;
        this.telefono = telefono;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getId_historia() {
        return id_historia;
    }

    public void setId_historia(int id_historia) {
        this.id_historia = id_historia;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Paciente " + id + "\n Nombre: " + nombre + " , Apellido: " + apellido + " , Correo: " + correo + " , DNI: " + dni + " , Historia: " + id_historia + " , Telefono=" + telefono ;
    }
    
//        private int id;
//    private String nombre;
//    private String apellido;
//    private String correo;
//    private int dni;
//    private int id_historia;
//    private int telefono;
    public String[] elementos(){
    String lista[]=new String[7];
    lista[0]=String.valueOf(id);
    lista[1]=nombre;
    lista[2]=apellido;
    lista[3]=correo;
    lista[4]=String.valueOf(dni);
    lista[5]=String.valueOf(id_historia);
    lista[6]=String.valueOf(telefono);
    return lista;
}
    
    
}
