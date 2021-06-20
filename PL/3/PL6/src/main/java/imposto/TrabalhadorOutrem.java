package imposto;

public abstract class TrabalhadorOutrem extends ContribuinteComRendimentoTrabalho{
    private String empresa;
    
    private static final String EMPRESA_POR_OMISSAO = "Sem empresa.";
 
    private static float escalaoRendimentoTrabalho = 30000;
    private static float taxaRendimentos1 = 1;
    private static float taxaRendimentos2 = 2;
    private static float taxaOutrosRendimentos = 2;
    
    public TrabalhadorOutrem(String nome, String morada, float 
            outrosRendimentos, float rendimentoTrabalho, String empresa){
        super(nome, morada, outrosRendimentos, rendimentoTrabalho);
        this.empresa = empresa;
    } 
    
    
    
    public float ObterTaxaRendimentosTrabalho(){
        return (getRendimentosTrabalho() <= escalaoRendimentoTrabalho) ? taxaRendimentos1 : taxaRendimentos2;
    }
    public abstract float ObterTaxaOutrosRendimentos();
}
