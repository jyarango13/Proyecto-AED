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
public class Trabajador {
    
    //Atributos
    private String nombre;
    private int tipo;
    private int horas;
    private double sueldoSemanal;
    
    //Métodos

    public Trabajador(String nombre, int tipo, int horas) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.horas = horas;
        switch (tipo){
                case 1: //Auxiliar 20 soles
                    if (horas > 40) {
                        sueldoSemanal = 40 * 20 + (horas - 40) * 20 * 1.37;
                    } else {
                        sueldoSemanal = horas * 20;
                    }
                    break;
                case 2: // Obstetra 40 soles
                    if (horas > 40) {
                        sueldoSemanal = 40 * 40 + (horas - 40) * 40 * 1.37;
                    } else {
                        sueldoSemanal = horas * 40;
                    }
                    break;
                case 3: // medico 60 soles
                    if (horas > 40) {
                        sueldoSemanal = 40 * 60 + (horas - 40) * 60 * 1.37;
                    } else {
                        sueldoSemanal = horas * 60;
                    }
                    break;
                case 4: // Cirujano 80 soles
                    if (horas > 40) {
                        sueldoSemanal = 40 * 80 + (horas - 40) * 80 * 1.37;
                    } else {
                        sueldoSemanal = horas * 80;
                    }
                    break;
                default:
                    break;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public int getHoras() {
        return horas;
    }

    public double getSueldoSemanal() {
        return sueldoSemanal;
    }
    
    

    @Override
    public String toString() {
        return "Nombre: " + nombre + " , Tipo: " + tipo + " , Horas: " + horas + " , SueldoSemanal: " + sueldoSemanal ;
    }
    
    public String[] elementos(){
        String lista[]=new String[4];
        lista[0]=nombre;
        lista[1]=String.valueOf(tipo);
        lista[2]=String.valueOf(horas);
        lista[3]=String.valueOf(sueldoSemanal);
        return lista;
    }
    
}
