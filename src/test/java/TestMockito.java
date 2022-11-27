/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.preguntastest.Comprobar;
import com.mycompany.preguntastest.DAOPreguntas;
import com.mycompany.preguntastest.ExcepcionNoPudoConectarse;
import com.mycompany.preguntastest.IDAOPreguntas;
import com.mycompany.preguntastest.Partida;
import com.mycompany.preguntastest.Pregunta;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;


/**
 *
 * @author capea
 */

public class TestMockito {
    Comprobar comp;
    @Mock
    DAOPreguntas dao;

    public TestMockito() {
        
    }
    
    
    
    @BeforeEach
    public void setUp() {
        comp = new Comprobar();
        dao =  Mockito.mock(DAOPreguntas.class);
        comp.setDao(dao);
    }
    
    
    @Test
    public void testCantidadPreguntas() {
        try{
            Mockito.when(dao.obtenerPreguntas()).thenReturn(new ArrayList<Pregunta>());
            assertEquals(0, comp.devolverCantidadPreguntas());
        } catch(SQLException e){
             fail("Lanzada excepcion no esperada SQLException");
        } catch(ExcepcionNoPudoConectarse ex){
             fail("Lanzada excepcion no esperada ExcepcionNoPudoConectarse");
        }
    }
    
    @Test
     public void testCantidadPartidas() {
         
         try{
             Mockito.when(dao.obtenerPartidas()).thenReturn(new ArrayList<Partida>());
             assertEquals(0, comp.devolverCantidadPartidas());
         } catch(SQLException e){
             fail("Lanzada excepcion no esperada SQLException");
         } catch(ExcepcionNoPudoConectarse ex){
             fail("Lanzada excepcion no esperada ExcepcionNoPudoConectarse");
         }
         
     }
}
