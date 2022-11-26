/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preguntastest;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author capea
 */
public class MockDAOPreguntas implements IDAOPreguntas{
    

    public MockDAOPreguntas() {
        
    }
    
    
    @Override
    public ArrayList<Pregunta> obtenerPreguntas() throws SQLException, ExcepcionNoPudoConectarse {
        ArrayList<Pregunta> listaPreguntas = new ArrayList<>();
        
        return listaPreguntas;
        
    }

    @Override
    public ArrayList<Partida> obtenerPartidas() throws SQLException, ExcepcionNoPudoConectarse {
        ArrayList<Partida> listaPartidas = new ArrayList<>();
        
        return listaPartidas;
    }

    @Override
    public boolean eliminarPregunta(int ID) {
        if (ID <1){
            return false;
        }
        else return true;
        
    }

    @Override
    public boolean insertarPregunta(Pregunta p) {
        if(p==null){return false;}
        else return true;
    }

    @Override
    public boolean insertarPartida(Partida p) {
        if(p==null){return false;}
        else return true;
    }

    @Override
    public boolean editarPregunta(int id, String pregunta, String res1, String res2, String res3, String res4, int resCorrecta) {
        if(id<0){return false;}
        else return true;
    }

   

   
    
}
