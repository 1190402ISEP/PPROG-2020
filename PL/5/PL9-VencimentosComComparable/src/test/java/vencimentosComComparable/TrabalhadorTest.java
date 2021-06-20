/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vencimentosComComparable;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author pokem
 */
public class TrabalhadorTest {
    
    private Trabalhador trab1, trab2, trab3;
    public TrabalhadorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        trab1 = new TrabalhadorComissao("Paulo Silva", 1000.0f, 3500.0f, 5.30f);
        trab2 = new TrabalhadorHora("Paulo Silva", 100, 8.0f);
        trab3 = new TrabalhadorComissao("Rui Soares", 1000.0f, 3500.0f, 5.30f);
    }
    
    @AfterEach
    public void tearDown() {
    }


    /**
     * Test of compareTo method, of class Trabalhador.
     */
    @Test
    public void testCompareToZero() {
        System.out.println("compareTo");
        int expResult = 0;
        int result = trab1.compareTo(trab3);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Trabalhador.
     */
    @Test
    public void testCompareToPos() {
        System.out.println("compareTo");
        int expResult = 1;
        int result = trab1.compareTo(trab2);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of compareTo method, of class Trabalhador.
     */
    @Test
    public void testCompareToNeg() {
        System.out.println("compareTo");
        int expResult = -1;
        int result = trab2.compareTo(trab1);
        assertEquals(expResult, result);
    }
}
