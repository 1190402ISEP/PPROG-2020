package imposto;

public abstract class Reformado extends ContribuinteComRendimentoTrabalho{
    private final float taxaRendimentosTrabalho = 1;
    private final float taxaOutrosRendimentos = 3;
    
    public Reformado(){
        super();
    }
    
    public float ObterTaxaRendimentosTrabalho(){
        return taxaRendimentosTrabalho;
    }
    public float ObterTaxaOutrosRendimentos(){
        return taxaOutrosRendimentos;
    }
}
