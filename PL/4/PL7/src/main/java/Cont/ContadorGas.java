package Cont;

public class ContadorGas extends Contador {
    
    private static final String PREFIXO_CONTADOR_GAS = "GAS-";
    private static float custoM3 = 0.8f;
    private static int totalContadorGas = 0;
    
    public ContadorGas(String cliente, int consumo){
        super(PREFIXO_CONTADOR_GAS + (totalContadorGas + 1), cliente, consumo);
        totalContadorGas++;        
    }
    
    public ContadorGas(String cliente){
        super(PREFIXO_CONTADOR_GAS + (totalContadorGas + 1), cliente);
        totalContadorGas++;  
    }
    
    public ContadorGas(int consumo){
        super(PREFIXO_CONTADOR_GAS + (totalContadorGas + 1), consumo);
        totalContadorGas++; 
    }
    
    public ContadorGas(){
        super(PREFIXO_CONTADOR_GAS + (totalContadorGas + 1));
        totalContadorGas++; 
    }
    
    @Override
    public String toString(){
        return String.format("%s Consumo Gás: %d", super.toString(), super.getConsumo());
    }
    
    @Override
    public float CalcularCusto(){
        return custoM3 * super.getConsumo();
    }

    public float getCustoM3() {
        return custoM3;
    }

    public int getTotalContadorGas() {
        return totalContadorGas;
    }

    public void setCustoM3(float custoM3) {
        this.custoM3 = custoM3;
    }    
    
}
