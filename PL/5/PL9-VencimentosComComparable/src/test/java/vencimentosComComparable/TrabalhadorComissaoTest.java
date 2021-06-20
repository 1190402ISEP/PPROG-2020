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
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author pokem
 */
public class TrabalhadorComissaoTest {
    
    private TrabalhadorComissao trab1;
    public TrabalhadorComissaoTest() {
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
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of calcularVencimento method, of class TrabalhadorComissao.
     */
    @org.junit.jupiter.api.Test
    public void testCalcularVencimento() {
        System.out.println("calcularVencimento");
        float expResult = 1185.5F;
        float result = trab1.calcularVencimento();
        assertEquals(expResult, result, 0.005);
    }
    
}
