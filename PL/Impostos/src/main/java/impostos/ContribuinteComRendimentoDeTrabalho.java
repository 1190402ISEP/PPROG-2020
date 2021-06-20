package impostos;

/**
 *
 * @author ANTÓNIO DANIEL BARBOSA FERNANDES
 */
public abstract class ContribuinteComRendimentoDeTrabalho extends Contribuinte {

    private float rendimentoRT;

    private static final float RENDIMENTO_RT_POR_OMISSAO = 0;

    public ContribuinteComRendimentoDeTrabalho(String nome, String morada, float rendimentoOR, float rendimentoRT) {
        super(nome, morada, rendimentoOR);
        this.rendimentoRT = rendimentoRT;
    }

    public ContribuinteComRendimentoDeTrabalho(String nome, String morada, float rendimentoOR) {
        super(nome, morada, rendimentoOR);
        this.rendimentoRT = RENDIMENTO_RT_POR_OMISSAO;
    }

    public ContribuinteComRendimentoDeTrabalho(String nome, String morada) {
        super(nome, morada);
        this.rendimentoRT = RENDIMENTO_RT_POR_OMISSAO;
    }

    public ContribuinteComRendimentoDeTrabalho(String nome) {
        super(nome);
        this.rendimentoRT = RENDIMENTO_RT_POR_OMISSAO;
    }

    public ContribuinteComRendimentoDeTrabalho() {
        super();
        this.rendimentoRT = RENDIMENTO_RT_POR_OMISSAO;
    }

    /**
     * @return the rendimentosRT
     */
    public float getRendimentoRT() {
        return rendimentoRT;
    }

    /**
     * @param rendimentosRT the rendimentosRT to set
     */
    public void setRendimentoRT(float rendimentosRT) {
        this.rendimentoRT = rendimentosRT;
    }

    @Override
    public String toString() {
        return String.format("%s %n O contribuinte apresenta um rendimento de trabalho de %f euros.", super.toString(), rendimentoRT);
    }

    @Override
    public float calcularImposto() {
        return (getRendimentoOR() * calcularTaxaRendimentoOR()) + (getRendimentoRT() * calcularTaxaRendimentoRT());

    }

    public abstract float calcularTaxaRendimentoRT();

    public abstract float calcularTaxaRendimentoOR();
}
