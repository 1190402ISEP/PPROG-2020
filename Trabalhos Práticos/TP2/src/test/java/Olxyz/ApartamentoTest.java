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
public class ApartamentoTest {
    
    public ApartamentoTest() {
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
     * Test of CalcularValorDeAluguer method, of class Apartamento.
     */
    @Test
    public void testCalcularValorDeAluguer() {
        System.out.println("CalcularValorDeAluguer");
        Endereco e1= new Endereco("Porto","4500-606","ISEP");
        Apartamento instance = new Apartamento(e1,200,5000);
        double expResult = 5250f;
        double result = instance.CalcularValorDeAluguer();
        assertEquals(expResult, result, 0.0);
        
    }
    
}
