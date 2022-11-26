/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preguntastest;

import java.util.ArrayList;

/**
 *
 * @author Dam
 */
public class Pregunta {
    private int ID;
    private String pregunta;
    private ArrayList<String> listaRespuestas;
    private int respuestaCorrecta;

    public Pregunta(int id,String pregunta, ArrayList<String> listaRespuestas, int respuestaCorrecta) {
        this.ID=id;
        this.pregunta = pregunta;
        this.listaRespuestas = listaRespuestas;
        this.respuestaCorrecta = respuestaCorrecta;
    }
    
    public Pregunta(String pregunta, ArrayList<String> listaRespuestas, int respuestaCorrecta) {
        this.ID=-1;
        this.pregunta = pregunta;
        this.listaRespuestas = listaRespuestas;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public int getID() {
        return ID;
    }
    
    public String getPregunta() {
        return pregunta;
    }

    public ArrayList<String> getListaRespuestas() {
        return listaRespuestas;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setListaRespuestas(ArrayList<String> listaRespuestas) {
        this.listaRespuestas = listaRespuestas;
    }

    public void setRespuestaCorrecta(int respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
    
    
    
    public boolean comprobarRespuesta(int indice){
        if (indice==respuestaCorrecta) {
            return true;
        } else return false;
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pregunta other = (Pregunta) obj;
        return this.ID == other.ID;
    }

    @Override
    public String toString() {
        return pregunta;
    }
    
    
}
