package imposto;

public abstract class Contribuintes {
    private String nome;
    private String morada;
    private float outrosRendimentos;
    
    private static final String NOME_POR_OMISSAO = "Sem nome";
    private static final String MORADA_POR_OMISSAO = "Sem morada";
    private static final float OUTROS_RENDIMENTOS_POR_OMISSAO = 0;
    
    public Contribuintes(String nome, String morada, float outrosRendimentos){
        this.nome = nome;
        this.morada = morada;     
        this.outrosRendimentos = outrosRendimentos;
    }
    
    public Contribuintes(){
        nome = NOME_POR_OMISSAO;
        morada = MORADA_POR_OMISSAO;
        outrosRendimentos = OUTROS_RENDIMENTOS_POR_OMISSAO;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getMorada(){
        return morada;
    }
    
    public float getOutrosRendimentos(){
        return outrosRendimentos;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setMorada(String morada){
        this.morada = morada;
    }
    
    public void setOutrosRendimentos(float outrosRendimentos){
        this.outrosRendimentos = outrosRendimentos;
    }
    
    @Override
    public String toString(){
        return String.format("Nome: %s%nMorada: %s%nOutros rendimentos: %.2f", 
                nome, morada, outrosRendimentos);
    }
    
    public abstract float calcularImposto();
}
