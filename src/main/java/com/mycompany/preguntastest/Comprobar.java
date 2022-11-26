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
public class Comprobar {
    private IDAOPreguntas dao;
    

    public Comprobar() {
        dao = DAOPreguntas.getInstance();
    }

    public IDAOPreguntas getDao() {
        return dao;
    }

    public void setDao(IDAOPreguntas dao) {
        this.dao = dao;
    }
    
    public int devolverCantidadPreguntas() throws ExcepcionNoPudoConectarse, SQLException{
        ArrayList<Pregunta> listaPreguntas = dao.obtenerPreguntas();
        return listaPreguntas.size();
        
    }
    
    public int devolverCantidadPartidas() throws SQLException, ExcepcionNoPudoConectarse{
        ArrayList<Partida> listaPartidas = dao.obtenerPartidas();
        return listaPartidas.size();
        
    }
    
    
}
