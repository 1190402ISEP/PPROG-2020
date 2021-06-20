/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author anton
 */
public class EmpregadoTest {

    public EmpregadoTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of CalcularHorasSemanais method, of class Empregado.
     */
    @org.junit.jupiter.api.Test
    public void testCalcularHorasSemanais() {
        System.out.println("CalcularHorasSemanais");
        Empregado instance = new Empregado();
        float expResult = 0.0f;
        float result = instance.calcularHorasSemanais();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of calcularAntiguidade method, of class Empregado.
     */
    @org.junit.jupiter.api.Test
    public void testCalcularAntiguidade() {
        System.out.println("calcularAntiguidade");
        Empregado instance = new Empregado();
        int expResult = 2019;
        int result = instance.calcularAntiguidade();
        assertEquals(expResult, result);

    }

    @Test
    public void EqualsTest() {
        Empregado instance = new Empregado();

        System.out.println("equals");
        assertFalse(instance.equals(null), "Não deve ser nulo!!!");
        assertFalse(instance.equals(null), "Não deve ser nulo!!!");

        Empregado other = new Empregado();

        assertTrue(instance.equals(other), "deve ser igual a outro");

        Tempo t1 = new Tempo(14, 0);
        Tempo t2 = new Tempo(19, 30);
        Empregado another = new Empregado("Manuel", "Silva", Data.dataAtual(), t1, t2);
        assertFalse(instance.equals(another), "não devem ser iguais");

    }

}
