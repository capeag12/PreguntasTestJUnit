/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preguntastest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author capea
 */
public class DAOPreguntas implements IDAOPreguntas{
        private ArrayList<Pregunta> listaPreguntas;
        private ArrayList<Partida> listaPartidas;
	private static DAOPreguntas dao=null; 
        private Conexion conexion;
        

    private DAOPreguntas() {
        conexion = new Conexion("juegoPreguntas", "root", "");
        
      
    }
    
        @Override
    public ArrayList<Pregunta> obtenerPreguntas() throws SQLException, ExcepcionNoPudoConectarse{
        conexion.conectar();
        listaPreguntas = new ArrayList<Pregunta>();
        ResultSet resultado= conexion.realizarConsulta("SELECT * FROM `pregunta`");
        if (resultado==null) {
            throw new ExcepcionNoPudoConectarse("No se pudo recuperar los datos");
        } else{
            while (resultado.next()) {
            ArrayList<String> listaRespuestas = new ArrayList<>();
            listaRespuestas.add(resultado.getString("Respuesta1"));
            listaRespuestas.add(resultado.getString("Respuesta2"));
            listaRespuestas.add(resultado.getString("Respuesta3"));
            listaRespuestas.add(resultado.getString("Respuesta4"));
            listaPreguntas.add(new Pregunta(Integer.parseInt(resultado.getString("ID")), resultado.getString("Pregunta"), listaRespuestas, Integer.parseInt(resultado.getString("RespuestaCorrecta"))));
        }
        conexion.desconectar();
        return listaPreguntas;
        }
      
    }
    
        @Override
    public ArrayList<Partida> obtenerPartidas() throws SQLException, ExcepcionNoPudoConectarse{
        conexion.conectar();
        listaPartidas = new ArrayList<Partida>();
        ResultSet resultado = conexion.realizarConsulta("SELECT * FROM `historial`");
        
        if (resultado==null) {
            throw new ExcepcionNoPudoConectarse("No se pudo recuperar los datos");
        } else{
            while (resultado.next()) {            
            listaPartidas.add(new Partida(Integer.parseInt(resultado.getString("ID")), resultado.getString("Nombre"), Integer.parseInt(resultado.getString("NumCorrectas")), Integer.parseInt(resultado.getString("NumTotales"))));
        }
            conexion.desconectar();
            return listaPartidas;
        }
        
    }
    @Override
    public boolean eliminarPregunta(int ID){
        conexion.conectar();
        boolean borrado = true;
        ResultSet listaHistorial = null;
            try {
                //Primero busco el id de las partidas que tienen los datos
                listaHistorial = conexion.realizarConsulta("SELECT ID FROM `historial`, historialpregunta WHERE ID = historialpregunta.IDPartida AND historialpregunta.IDPregunta="+ID+";");
            } catch (SQLException ex) {
                Logger.getLogger(DAOPreguntas.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
        
            while (listaHistorial.next() && borrado==true) {                
                String consultaHistorial = "DELETE FROM historialpregunta WHERE `historialpregunta`.`IDPartida` ="+listaHistorial.getString(1)+";";
                borrado= conexion.realizarInsercionEliminacion(consultaHistorial);
                String consultaBorrarHistorial = "DELETE FROM HISTORIAL WHERE ID="+listaHistorial.getString(1)+";";
                borrado= conexion.realizarInsercionEliminacion(consultaBorrarHistorial);
            }
            System.out.println("SE ha realizado el borrado?"+borrado);
        if (borrado==true) {
            
            String consulta2 = "DELETE FROM pregunta WHERE `pregunta`.`ID` = '"+ID+"'";
            System.out.println(consulta2);
            borrado = conexion.realizarInsercionEliminacion(consulta2);
            
            
        }
        else{
            
        }
        
        } catch (Exception e) {
            Logger.getLogger(DAOPreguntas.class.getName()).log(Level.SEVERE, null, e);
        }
        conexion.desconectar();
        return borrado;
    }
    @Override
    public boolean insertarPregunta(Pregunta p){
        conexion.conectar();
        ArrayList<String> lista = p.getListaRespuestas();
        String consulta = "INSERT INTO `pregunta` (`ID`, `Pregunta`, `Respuesta1`, `Respuesta2`, `Respuesta3`, `Respuesta4`, `RespuestaCorrecta`) "
                        + "VALUES (NULL, '"+p.getPregunta()+"', '"+lista.get(0)+"', '"+lista.get(1)+"', '"+lista.get(2)+"', '"+lista.get(3)+"', '"+p.getRespuestaCorrecta()+"');";
        System.out.println(consulta);
        boolean added = false;
            try {
                added= conexion.realizarInsercionEliminacion(consulta);
            } catch (SQLException ex) {
            }
        conexion.desconectar();
        return added;
        
    }
    @Override
    public boolean insertarPartida(Partida p){
        conexion.conectar();
        boolean added = false;
        try {
        conexion.conexion.setAutoCommit(false);
        String consulta = "INSERT INTO `historial` (`ID`, `Nombre`, `NumCorrectas`, `NumTotales`) VALUES (NULL, '"+p.getNombre()+"', '"+p.getPuntuacion()+"', '"+p.getPreguntasTotales()+"')";
        System.out.println(consulta);
        added = conexion.realizarInsercionEliminacion(consulta);
        
        if (added==true) {
            String consultaNuevaPreg = "SELECT MAX(ID) FROM `historial`;";
            
            String idPartida="";
            ResultSet resultado = conexion.realizarConsulta(consultaNuevaPreg);
            while (resultado.next()) {                
                idPartida = resultado.getString(1);
            }

            for (int i = 0; i < p.getListaPreguntas().size(); i++) {
                String consultaNuevo = "INSERT INTO `historialpregunta` (`IDPartida`, `IDPregunta`) VALUES ('"+idPartida+"', '"+p.getListaPreguntas().get(i).getID()+"');";
                added= conexion.realizarInsercionEliminacion(consultaNuevo);
            }
        } else{added=false; conexion.conexion.rollback();}
        conexion.conexion.commit();
        } catch (Exception e) {
            try {
                conexion.conexion.rollback();
            } catch (SQLException ex) {
                System.out.println("Algo fallo");
                return false;
            }
        }
            try {
                conexion.conexion.setAutoCommit(true);
            } catch (SQLException ex) {
                return false;
            }
        conexion.desconectar();
        return added;
    }
    @Override
    public boolean editarPregunta(int id,String pregunta, String res1, String res2, String res3, String res4, int resCorrecta ){
            String consulta = "UPDATE `pregunta` SET `Pregunta` = '"+pregunta+"', `Respuesta1` = '"+res1+"', `Respuesta2` = '"+res2+"', `Respuesta3` = '"+res3+"', `Respuesta4` = '"+res4+"', `RespuestaCorrecta` = '"+resCorrecta+"' WHERE `pregunta`.`ID` ="+id+";";
            System.out.println(consulta);
            conexion.conectar();
            int i=conexion.realizarUpdate(consulta);
            if (i==0) {
                System.out.println("Algo no fue bien");
                conexion.desconectar();
                return false;
            } else{System.out.println("Todo fue bien");conexion.desconectar(); ; return true;}
        }
    
    
    public static DAOPreguntas getInstance(){
	if (dao== null) dao =new DAOPreguntas();
	  
	return dao;
	}
}
