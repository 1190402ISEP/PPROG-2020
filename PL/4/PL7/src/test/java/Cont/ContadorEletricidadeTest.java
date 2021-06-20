package Cont;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContadorEletricidadeTest {

    @Test
    public void testGetTotalContadorEletricidade() {
        System.out.println("getTotalContadorEletricidade");
        int expResult = 0;
        int result = ContadorEletricidade.getTotalContadorEletricidade();
        assertEquals(expResult, result);
        
        
    }
    
}
