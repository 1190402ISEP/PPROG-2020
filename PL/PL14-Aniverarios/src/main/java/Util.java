import java.util.Scanner;

/**
 *
 * @author anton
 */
public final class Util {
    private Util(){}
    public static Data lerData(){
       Scanner ler= new Scanner (System.in);
    Data d=new Data();
    boolean dataInvalida=true;
    
    do{
        try{
            String[] data =ler.nextLine().split("/");
            if(data.length != 3){
                throw new NumberFormatException();
            }
            int ano= Integer.parseInt(data[0]);
            int mes= Integer.parseInt(data[1]);
            int dia= Integer.parseInt(data[2]);
            
            d.setData(ano,mes,dia);
            
            dataInvalida=false;
            
        }
        catch(NumberFormatException e){
            System.out.println("FORMATO INVÁLIDO");
            System.out.println("DIGITE NOVAMENTE A DATA NO FORMATO CERTO!");
        }
                catch(DiaInvalidoException | MesInvalidoException e){
            System.out.println(e.getMessage());
            System.out.println("DIGITE NOVAMENTE A DATA NO FORMATO CERTO!");
        }
        //implicitamente - jvm
        //explicitamente- programador
   
   
    
    }while(dataInvalida);
    
    return d;
    }
   
    }
    
    
    
    
    
    
    
    
    
    
    
