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
public class TelemovelTest {
    
    public TelemovelTest() {
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
     * Test of CalcularValorDeVenda method, of class Telemovel.
     */
    @Test
    public void testCalcularValorDeVenda() {
        System.out.println("CalcularValorDeVenda");
        Telemovel instance = new Telemovel("Samsung Galaxy S20",1500);
        double expResult = 1545;
        double result = instance.CalcularValorDeVenda();
        assertEquals(expResult, result, 0.0);
        
    }
    
}
