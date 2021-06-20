package vencimentos;

public class MainVencimentos {

    public static void main(String[] args) {
//        Objeto do tipo TrabalhadorPeca, de nome Jorge Silva que produziu 53 peças do tipo 1 e 62 do tipo 2;
        TrabalhadorPeca tp1 = new TrabalhadorPeca("Jorge Silva", 53, 62);
        
//        Objeto do tipo TrabalhadorComissao, de nome Susana Ferreira, com o salário base de 650,00€ e uma comissão de 4,25% sobre as vendas efetuadas que totalizaram o valor de 2731,50€;
        TrabalhadorComissao tc1 = new TrabalhadorComissao("Susana Ferreira", 650f, 2731.50f, 4.25f);
        
//        Objeto do tipo TrabalhadorHora, de nome Carlos Miguel, que ganha por hora 4,50€ e com um total de horas de trabalho igual a 168.
        TrabalhadorHora th1 = new TrabalhadorHora("Carlos Miguel", 168, 4.50f);
        
        //Object[] Array = new Object[10];
        Trabalhador[] Array = new Trabalhador[10];
        
        Array[0] = tp1;
        Array[1] = tc1;
        Array[2] = th1;
        
        for (int i = 0; i < Array.length; i++) {
            if (Array[i] != null){
                System.out.println(Array[i] + "");
                System.out.println();
            }
        }
        
        for (int i = 0; i < Array.length; i++) {
            if (Array[i] != null && Array[i] instanceof TrabalhadorHora){
                System.out.println(Array[i] + "");
                System.out.println();
            }
        }
        
//        for (int i = 0; i < Array.length; i++) {
//            if (Array[i] != null){
//                Trabalhador temp = (Trabalhador) Array[i];
//                System.out.printf("%s: %.2f%n", temp.getNome(), temp.calcularVencimento());
//                System.out.println();
//            }
//        }
        
        for (int i = 0; i < Array.length; i++) {
            if (Array[i] != null){
                System.out.printf("%s: %.2f€%n", Array[i].getNome(), Array[i].calcularVencimento());
                System.out.println();
            }
        }
    }
    
}
