package imposto;

public abstract class Desempregado extends Contribuintes{
    private int mesesParagem;
       
    private static final int MESES_PARAGEM_POR_OMISSAO = 0;
       
    private final float taxaOutrosRendimentos = 2;
    
    @Override
    public abstract float calcularImposto();
}
