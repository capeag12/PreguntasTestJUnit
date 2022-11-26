/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.preguntastest.Comprobar;
import com.mycompany.preguntastest.DAOPreguntas;
import com.mycompany.preguntastest.ExcepcionNoPudoConectarse;
import com.mycompany.preguntastest.IDAOPreguntas;
import com.mycompany.preguntastest.MockDAOPreguntas;
import com.mycompany.preguntastest.Pregunta;
import java.lang.module.ModuleDescriptor;
import java.sql.SQLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author capea
 */
public class TestDAO {
    Comprobar comp;
    
    public TestDAO() {
        
    }
    
    
    //En caso de fallar el before each en un nuevo proyecto, copiar la parte de dependencies y build del pom.xml, son necesarias esas librerias
    @BeforeEach
    public void setUp() {
        comp = new Comprobar();
        comp.setDao(new MockDAOPreguntas());
        
    }
    
    
    
     @Test
     public void testCantidadPreguntas() {
         
         try{
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
             assertEquals(0, comp.devolverCantidadPartidas());
         } catch(SQLException e){
             fail("Lanzada excepcion no esperada SQLException");
         } catch(ExcepcionNoPudoConectarse ex){
             fail("Lanzada excepcion no esperada ExcepcionNoPudoConectarse");
         }
         
     }
}
