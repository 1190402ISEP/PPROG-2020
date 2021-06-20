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
public class CreditoDeConsumoAEducaçaoTest {

    public CreditoDeConsumoAEducaçaoTest() {
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
     * CreditoDeConsumoAEducaçao.
     */
    @Test
    public void testCalcularMontanteAReceberPorCadaCredito() {
        System.out.println("calcularMontanteAReceberPorCadaCredito");
        CreditoDeConsumoAEducaçao instance = new CreditoDeConsumoAEducaçao("António", "Engenheiro Informático", 18000, 60, 24);
        float expResult = 19275f;
        float result = instance.calcularMontanteAReceberPorCadaCredito();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of calcularMontanteTotalJuros method, of class
     * CreditoDeConsumoAEducaçao.
     */
    @Test
    public void testCalcularMontanteTotalJuros() {
        System.out.println("calcularMontanteTotalJuros");
        CreditoDeConsumoAEducaçao instance = new CreditoDeConsumoAEducaçao("António", "Engenheiro Informático", 18000, 60, 24);
        float expResult = 1275f;
        float result = instance.calcularMontanteTotalJuros();
        assertEquals(expResult, result, 0.0);

    }

}
