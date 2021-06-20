/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package credito;

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
public class CreditoAHabitacaoTest {

    public CreditoAHabitacaoTest() {
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
     * Test of calcularMontanteAReceberPorCadaCredito method, of class
     * CreditoAHabitacao.
     */
    @Test
    public void testCalcularMontanteAReceberPorCadaCredito() {
        System.out.println("calcularMontanteAReceberPorCadaCredito");
        CreditoAHabitacao instance = new CreditoAHabitacao("António", "Engenheiro Informático", 120000, 240, 1);
        float expResult = 133255f;
        float result = instance.calcularMontanteAReceberPorCadaCredito();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of calcularMontanteTotalJuros method, of class CreditoAHabitacao.
     */
    @Test
    public void testCalcularMontanteTotalJuros() {
        System.out.println("calcularMontanteTotalJuros");
        CreditoAHabitacao instance = new CreditoAHabitacao("Luiz", "Engenheiro", 120000, 240, 1);
        float expResult = 13255f;
        float result = instance.calcularMontanteTotalJuros();
        assertEquals(expResult, result, 0.0);

    }

}
