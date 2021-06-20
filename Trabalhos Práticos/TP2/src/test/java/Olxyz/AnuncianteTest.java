package Olxyz;

import java.util.List;
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
public class AnuncianteTest {

    public AnuncianteTest() {
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
     * Test of quantidadeProdutos method, of class Anunciante.
     */
    @Test
    public void testQuantidadeProdutos() {
        System.out.println("quantidadeProdutos");
        Anunciante a1 = new Anunciante("Rui", "Rua", "4500-123", "Sra. da Hora");
        a1.introduzirVendavelTelemovel("Samsung", 10);
        a1.introduzirAlugavelApartamento("Rua1", "4123-436", "Ah", 120, 400);
        a1.introduzirAlugavelAutomovel("Lamborghini", "Diablo", 0, 5000000);

        int expResult = 2;
        int result = a1.quantidadeProdutos();
        assertEquals(expResult, result);

    }

    /**
     * Test of valorMaior method, of class Anunciante.
     */
    @Test
    public void testValorMaior() {
        System.out.println("valorMaior");
        Anunciante a1 = new Anunciante("Rui", "Rua", "4500-123", "Sra. da Hora");
        a1.introduzirAlugavelApartamento("Rua1", "4123-436", "Ah", 120, 400);
        a1.introduzirAlugavelAutomovel("Lamborghini", "Diablo", 0, 5000000);
        String expResult = "CARACTERÍSTICAS DO AUTOMÓVEL:\nMARCA: Lamborghini\nModelo: Diablo\nValor De Aluguer: 5250000,00 €\n";
        Automovel auto = (Automovel)a1.valorMaior();
        String result = auto.toStringAluguer();
        assertEquals(expResult, result);

    }

    /**
     * Test of totalPossivelVendas method, of class Anunciante.
     */
    @Test
    public void testTotalPossivelVendas() {
        System.out.println("totalPossivelVendas");
        Anunciante a1 = new Anunciante("Rui", "Rua", "4500-123", "Sra. da Hora");
        a1.introduzirVendavelTelemovel("Samsung", 100);
        a1.introduzirVendavelTelemovel("Nokia", 5);
        float expResult = 105f;
        float result = a1.totalPossivelVendas();
        assertEquals(expResult, result, 0.0);

    }

}
