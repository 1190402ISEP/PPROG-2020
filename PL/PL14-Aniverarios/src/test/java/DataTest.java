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
public class DataTest {
    
    public DataTest() {
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
     * Test of getMes method, of class Data.
     */
    @Test
    public void testSetDataComDataValida() {
        System.out.println("testSetDataComDataValida");
        int ano=2018;
        int mes=12;
        int dia=1;
        
        Data instance= new Data();
        
        instance.setData(ano,mes,dia);
        
        
        assertTrue(instance.getAno()==ano);
         assertTrue(instance.getMes()==mes);
         assertTrue(instance.getDia()==dia);
        //ano bissexto
        
        ano=2004;
        mes=2;
        dia=29;
        instance=new Data();
        
        instance.setData(ano,mes,dia);
        
        
        
        
        
        
        
        
        
        
        
    }
//@Test (expected=MesInvalidoException.class)
//    public void testSetDataComDataInValida() {
//        System.out.println("testSetDataComDataInValida");
//        int ano=2018;
//        int mes=0;
//        int dia=1;
//        
//        Data instance= new Data();
//        
//        instance.setData(ano,mes,dia);
//        ;
//        
//        //mes>12
//        
//        
//        mes=13;
//        
//        instance=new Data();
//        
//        instance.setData(ano,mes,dia);
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//    }
//@Test (expected=DiaInvalidoException.class)
//    public void testSetDataComDataInValida() {
//        System.out.println("testSetDataComDataInValida");
//        //dia<1
//        int ano=2018;
//       
//        int dia=0;
//        
//        Data instance= new Data();
//        for (int mes = 1; mes < =12; mes++) {
//        instance.setData(ano,mes,dia);
//    }
//        
//      //dia >último dia do mês
//      int [] dias {32,29,32,31,33,31,32,32,31,32,31,32};
//       for (int mes = 1; mes < =12; mes++) {
//        instance.setData(ano,mes,dias[mes]);
//    }
//        
//   // ano bissexto
//   instance.setData(2004,2,30);
//        
//        
//        
//        
//        
//        
//        
//        
//        
//    }
    
}
