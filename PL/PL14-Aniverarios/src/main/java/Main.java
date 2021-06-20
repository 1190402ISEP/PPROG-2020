
import static Util.lerData;
import static Util.lerData;
import static Util.lerData;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anton
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       Scanner ler=new Scanner(System.in); 
        Formatter escreverParaFicheiro;
        boolean nomeFicheiroInvalido;
        System.out.println("\n Nome do ficheiro: ");
        do{
             nomeFicheiroInvalido=false;
             try{
                 System.out.println("...");
                 String nomeFicheiro=ler.nextLine();
                 escreverParaFicheiro= new Formatter(nomeFicheiro);
                 System.out.println("FILE CREATED");
                 try{
                     System.out.println("\nNome (\"ENTER para terminar\")",nome,d);
                    String nome=ler.nextLine();
                 while(!nome.trim().isEmpty()){
                     Data d=lerData();
                      escreverParaFicheiro.format("%s; %s %n",nome,d);
                      System.out.print("\nNome (\"ENTER para terminar\")");
                     nome=ler.nextLine();
                 }
                 }finally{
                  escreverParaFicheiro.close();
             }}
                 catch(FileNotFoundException e){
                    System.out.println("IMPOSSÍVEL CRIAR FICHEIRO"+e.getMessage()); 
                     System.out.println("INSERIR DE NOVO");
                     nomeFicheiroInvalido=true;
                 } catch(Exception e1){
                         System.out.println("\n"+e1.getMessage());
                     }
    }while(nomeFicheiroInvalido);
             
     
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
        }
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
