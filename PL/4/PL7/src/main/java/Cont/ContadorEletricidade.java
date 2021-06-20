package Cont;

public abstract class ContadorEletricidade extends Contador{
    private static final String PREFIXO_CONTADOR_ELETRICIDADE = "ELECT-";
    private static int totalContadorEletricidade = 0;
    
    public ContadorEletricidade(String cliente, int consumo){
        super(PREFIXO_CONTADOR_ELETRICIDADE + (totalContadorEletricidade + 1), cliente, consumo);
        totalContadorEletricidade++;
    }
    
    public ContadorEletricidade(String cliente){
        super(PREFIXO_CONTADOR_ELETRICIDADE + (totalContadorEletricidade + 1), cliente);
        totalContadorEletricidade++;
    }
    
    public ContadorEletricidade(int consumo){
        super(PREFIXO_CONTADOR_ELETRICIDADE + (totalContadorEletricidade + 1), consumo);
        totalContadorEletricidade++;
    }
    
    public ContadorEletricidade(){
        super(PREFIXO_CONTADOR_ELETRICIDADE + (totalContadorEletricidade + 1));
        totalContadorEletricidade++;
    }

    public static int getTotalContadorEletricidade() {
        return totalContadorEletricidade;
    }
    
}
