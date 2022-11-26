package com.mycompany.preguntastest;


import com.mycompany.preguntastest.Conexion;
import com.mycompany.preguntastest.Partida;
import com.mycompany.preguntastest.Pregunta;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author capea
 */
public interface IDAOPreguntas {
    
    
    public ArrayList<Pregunta> obtenerPreguntas() throws SQLException, ExcepcionNoPudoConectarse;
    
    public ArrayList<Partida> obtenerPartidas() throws SQLException, ExcepcionNoPudoConectarse;
    
    public boolean eliminarPregunta(int ID);
    
    public boolean insertarPregunta(Pregunta p);
    
    public boolean insertarPartida(Partida p);
    
    public boolean editarPregunta(int id,String pregunta, String res1, String res2, String res3, String res4, int resCorrecta );
    
  
}
