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
public class BaralhoTest {
    
    public BaralhoTest() {
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
     * Test of toString method, of class Baralho.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Baralho instance = new Baralho();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of baralhar method, of class Baralho.
     */
    @Test
    public void testBaralhar() {
        System.out.println("baralhar");
        Baralho instance = new Baralho();
        instance.baralhar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of partir method, of class Baralho.
     */
    @Test
    public void testPartir() {
        System.out.println("partir");
        Baralho instance = new Baralho();
        instance.partir();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of primeirasCartas method, of class Baralho.
     */
    @Test
    public void testPrimeirasCartas() {
        System.out.println("primeirasCartas");
        int n = 0;
        Baralho instance = new Baralho();
        List<Carta> expResult = null;
        List<Carta> result = instance.primeirasCartas(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ultimasCartas method, of class Baralho.
     */
    @Test
    public void testUltimasCartas() {
        System.out.println("ultimasCartas");
        int n = 0;
        Baralho instance = new Baralho();
        List<Carta> expResult = null;
        List<Carta> result = instance.ultimasCartas(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
