package imposto;

public abstract class TrabalhadorPropia extends ContribuinteComRendimentoTrabalho{
    private String profissao;
    
    private static final String PROFISSAO_POR_OMISSAO = "Sem profissao.";
    
    private final float escala1OutrosRendimentos = 50000;
    private final float taxaRendimentos1 = 2;
    private final float taxaRendimentos2 = 5;
    private final float taxaRendimentosTrabalho = 3;
    
    @Override
    public float ObterTaxaRendimentosTrabalho(){
        return taxaRendimentosTrabalho;
    }
    @Override
    public abstract float ObterTaxaOutrosRendimentos();
}
