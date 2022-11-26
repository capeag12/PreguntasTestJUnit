/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preguntastest;

import java.util.ArrayList;

/**
 *
 * @author capea
 */
public class Partida {
    private int id;
    private String nombre;
    private int puntuacion;
    private int preguntasTotales;
    
    private int contador;
    private ArrayList<Pregunta> listaPreguntas;

    public Partida(int id, String nombre ,ArrayList<Pregunta> listaP) {
        this.id = id;
        this.nombre = nombre;
        this.puntuacion = 0;
        this.listaPreguntas = listaP;
        this.preguntasTotales = listaPreguntas.size();
        this.contador=0;
    }

    public Partida(int id, String nombre, int puntuacion, int preguntasTotales) {
        this.id = id;
        this.nombre = nombre;
        this.puntuacion = puntuacion;
        this.preguntasTotales = preguntasTotales;
    }
    
    

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public int getPreguntasTotales() {
        return preguntasTotales;
    }
    
    public Pregunta devolverSiguiente(){
        if (contador<listaPreguntas.size()) {
            Pregunta p = listaPreguntas.get(contador);
            contador++;
            return p;
        } else return null;
        
    }

    public void añadirPuntuacion(boolean resultado){
        if (resultado==true) {
          puntuacion++;  
        } 
    }

    public ArrayList<Pregunta> getListaPreguntas() {
        return listaPreguntas;
    }
    
    
    @Override
    public String toString() {
        return nombre + ", puntuacion=" + puntuacion + ", preguntasTotales=" + preguntasTotales;
    }
    
    
    
}
