package Olxyz;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 1DK_1190402_1191045
 */
public class AutomovelTest {
    
    public AutomovelTest() {
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
     * Test of CalcularValorDeAluguer method, of class Automovel.
     */
    @Test
    public void testCalcularValorDeAluguer() {
        System.out.println("CalcularValorDeAluguer");
        Automovel instance = new Automovel("Lamborghini","Miura",0,40000);
        double expResult = 42000;
        double result = instance.CalcularValorDeAluguer();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of CalcularValorDeVenda method, of class Automovel.
     */
    @Test
    public void testCalcularValorDeVenda() {
        System.out.println("CalcularValorDeVenda");
        Automovel instance = new Automovel("Lamborghini","Miura",50000,0);
        double expResult = 51500;
        double result = instance.CalcularValorDeVenda();
        assertEquals(expResult, result, 0.0);
        
    }
    
}
