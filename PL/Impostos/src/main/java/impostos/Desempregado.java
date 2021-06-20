package impostos;

/**
 *
 * @author ANTÓNIO DANIEL BARBOSA FERNANDES
 */
public class Desempregado extends Contribuinte {

    private int mesesDeParagem;

    private static final int MESES_DE_PARAGEM_POR_OMISSAO = 0;

    private static float taxaOR = 0.02f;

    public Desempregado(String nome, String morada, float rendimentosOR, int mesesDeParagem) {
        super(nome, morada, rendimentosOR);
        this.mesesDeParagem = mesesDeParagem;
    }

    public Desempregado(String nome, String morada, float rendimentosOR) {
        super(nome, morada, rendimentosOR);
        this.mesesDeParagem = MESES_DE_PARAGEM_POR_OMISSAO;
    }

    public Desempregado(String nome, String morada) {
        super(nome, morada);
        this.mesesDeParagem = MESES_DE_PARAGEM_POR_OMISSAO;
    }

    public Desempregado(String nome) {
        super(nome);
        this.mesesDeParagem = MESES_DE_PARAGEM_POR_OMISSAO;
    }

    public Desempregado() {
        super();
        this.mesesDeParagem = MESES_DE_PARAGEM_POR_OMISSAO;
    }

    @Override
    public String toString() {
        return String.format("%s %n O contribuinte apresenta um valor de meses de paragem de %f meses.", super.toString(), mesesDeParagem);
    }

    @Override
    public float calcularImposto() {
        return getRendimentoOR() * getTaxaOR();
    }

    /**
     * @return the taxaOR
     */
    public static float getTaxaOR() {
        return taxaOR;
    }

    /**
     * @param aTaxaOR the taxaOR to set
     */
    public static void setTaxaOR(float aTaxaOR) {
        taxaOR = aTaxaOR;
    }

}
