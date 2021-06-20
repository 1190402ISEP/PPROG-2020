/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vencimentosComComparador;

import java.util.Comparator;

/**
 *
 * @author pokem
 */
public class Comparacao2 implements Comparator<Trabalhador>{
    
    @Override
    public int compare(Trabalhador trab1, Trabalhador trab2){
        String nome1 = trab1.getNome();
        String nome2 = trab2.getNome();
        
        return nome1.compareTo(nome2);
    }
}
