/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preguntastest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dam
 */
public class GestionJuego {
    private ArrayList<Pregunta> listaPreguntas;
    private ArrayList<Partida> listaPartidas;
    
    public GestionJuego() {
        try {
            this.listaPreguntas = DAOPreguntas.getInstance().obtenerPreguntas();
            this.listaPartidas = DAOPreguntas.getInstance().obtenerPartidas();
        } catch (SQLException | ExcepcionNoPudoConectarse ex) {
            System.out.println("No ha podido conectarse a la BBDD");
            this.listaPreguntas = new ArrayList<>();
            this.listaPartidas = new ArrayList<>();
        }
        
    }
    
    public void recuperarBBDD() throws SQLException, ExcepcionNoPudoConectarse{
        
            this.listaPreguntas = DAOPreguntas.getInstance().obtenerPreguntas();
            this.listaPartidas = DAOPreguntas.getInstance().obtenerPartidas();
        
    }
    
    public void recuperarPreguntas() throws SQLException, ExcepcionNoPudoConectarse{
        
            this.listaPreguntas = DAOPreguntas.getInstance().obtenerPreguntas();
            
        
    }
    
    public void recuperarPartidas(){
        try {
            this.listaPartidas = DAOPreguntas.getInstance().obtenerPartidas();
            
        } catch (SQLException | ExcepcionNoPudoConectarse ex) {
            System.out.println("No ha podido conectarse a la BBDD");

        }
    }

    public ArrayList<Pregunta> getListaPreguntas() {
        return listaPreguntas;
    }

    public ArrayList<Partida> getListaPartidas() {
        return listaPartidas;
    }

    public void setListaPreguntas(ArrayList<Pregunta> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }

    public void setListaPartidas(ArrayList<Partida> listaPartidas) {
        this.listaPartidas = listaPartidas;
    }
    
    
    
    public boolean borrarPregunta(int id){
        Pregunta preg = buscarPregunta(id);
        
        
        return listaPreguntas.remove(preg);
    
    }
    
    public int devolverNumPreguntas(){
        return this.listaPreguntas.size();
    }
    
    public Pregunta eliminarPreguntaIndice(int index){
        return this.listaPreguntas.remove(index);
    }
    
    public Pregunta buscarPregunta(int id){
        boolean encontrado=false;
        for (int i = 0; i < listaPreguntas.size() && encontrado==false; i++) {
            Pregunta p = listaPreguntas.get(i);
            if (p.getID()==id) {
                return p;
            }
        }
        
        return null;
    
    }
    
    public Pregunta obtenerPreguntaIndice(int index){
        return this.listaPreguntas.get(index);
    }
    
    public int obtenerMaxIDPartida(){
        int maxID = 0;
        for (int i = 0; i < listaPartidas.size(); i++) {
            if (listaPartidas.get(i).getId()>maxID) {
                maxID = listaPartidas.get(i).getId();
            }
        }
        
        return maxID;
    }
    
    public void editarPregunta(int indice, String pregunta, ArrayList<String> listaRes, int resCorrecta){
        listaPreguntas.get(indice).setPregunta(pregunta);
        listaPreguntas.get(indice).setListaRespuestas(listaRes);
        listaPreguntas.get(indice).setRespuestaCorrecta(resCorrecta);
    }
    
    
    public void addPregunta(int id,String pregunta ,ArrayList<String> respuesta, int correcta){
        listaPreguntas.add(new Pregunta(id,pregunta,respuesta,correcta));
    }
    
    public void addPregunta(Pregunta p){
        listaPreguntas.add(p);
    }
    
    public void addPartida(Partida p){
        listaPartidas.add(p);
    }
    
    
        
    
}
