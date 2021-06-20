package imposto;

public abstract class ContribuinteComRendimentoTrabalho extends Contribuintes{
    private float rendimentosTrabalho;
    
    private static final float RENDIMENTOS_TRABALHO_POR_OMISSAO = 0;
    
    public ContribuinteComRendimentoTrabalho(String nome, String morada, float 
            outrosRendimentos, float rendimentoTrabalho){ 
        
        super(nome, morada, outrosRendimentos);
        this.rendimentosTrabalho = rendimentoTrabalho;
    }
    
    public ContribuinteComRendimentoTrabalho(){
        super();
        rendimentosTrabalho = RENDIMENTOS_TRABALHO_POR_OMISSAO;
    }
    
    public float getRendimentoTrabalho(){
        return rendimentosTrabalho;
    }
    
    public void setRendimentoTrabalho(float rendimentoTrabalho){
        this.rendimentosTrabalho = rendimentoTrabalho;
    }
    
    @Override
    public String toString(){
        return String.format("%s %nRendimentos de trabalho: %.2f"
                + "%nTaxa sobre Rendimentos de Trabalho: %.2f%%"
                + "%nTaxa sobre Outros Rendimentos: %.2f%%"
                , super.toString(), rendimentosTrabalho,
                ObterTaxaRendimentosTrabalho(), ObterTaxaOutrosRendimentos());
    }
    
    @Override
    public float calcularImposto(){
        return ((rendimentosTrabalho * ObterTaxaRendimentosTrabalho()
                + getOutrosRendimentos() * ObterTaxaOutrosRendimentos()) / 100);
    }
    
    public abstract float ObterTaxaRendimentosTrabalho();
    
    public abstract float ObterTaxaOutrosRendimentos();
}
