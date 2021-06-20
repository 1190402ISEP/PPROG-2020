/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodecartas;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author António Daniel Barbosa Fernandes (1190402)
 */
public class MaoDeJogoTest {
    
    public MaoDeJogoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

   

    /**
     * Test of tiposDeCarta method, of class MaoDeJogo.
     */
    @Test
    public void testTiposDeCarta() {
        System.out.println("tiposDeCarta");
        MaoDeJogo instance = new MaoDeJogo();
        List<Carta.Tipo> expResult = null;
        List<Carta.Tipo> result = instance.tiposDeCarta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contarCartasDoTipo method, of class MaoDeJogo.
     */
    @Test
    public void testContarCartasDoTipo() {
        System.out.println("contarCartasDoTipo");
        Carta.Tipo tipo = null;
        MaoDeJogo instance = new MaoDeJogo();
        int expResult = 0;
        int result = instance.contarCartasDoTipo(tipo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordenar method, of class MaoDeJogo.
     */
    @Test
    public void testOrdenar() {
        System.out.println("ordenar");
        MaoDeJogo instance = new MaoDeJogo();
        instance.ordenar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
