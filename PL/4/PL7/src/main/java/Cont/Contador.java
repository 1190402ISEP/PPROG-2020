package Cont;

public abstract class Contador {
    private String identificador;
    private String cliente;
    private int consumo;
    
    private static final String IDENTIFICADOR_POR_OMISSAO = "Sem identificador";
    private static final String CLIENTE_POR_OMISSAO = "Sem nome";
    private static final int CONSUMO_POR_OMISSAO = 0;
    
    public Contador(String identificador, String cliente, int consumo){
        this.identificador = identificador;
        this.cliente = cliente;
        this.consumo = consumo;
    }
    
    public Contador(String identificador, int consumo){
        this.identificador = identificador;
        this.consumo = consumo;
        cliente = CLIENTE_POR_OMISSAO;
    }
    
    public Contador(String identificador, String cliente){
        this.identificador = identificador;
        this.cliente = cliente;
        consumo = CONSUMO_POR_OMISSAO;
    }
    
    public Contador(String identificador){
        this.identificador = identificador;
        cliente = CLIENTE_POR_OMISSAO;
        consumo = CONSUMO_POR_OMISSAO;
    }
    
    public Contador(){
        identificador = IDENTIFICADOR_POR_OMISSAO;
        cliente = CLIENTE_POR_OMISSAO;
        consumo = CONSUMO_POR_OMISSAO;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getCliente() {
        return cliente;
    }

    public int getConsumo() {
        return consumo;
    }
    
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    } 
    
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }
    
    @Override
    public String toString(){
        return String.format("Contador: %s Dono: %s", identificador, cliente);
    }
    
    public abstract float CalcularCusto();

}