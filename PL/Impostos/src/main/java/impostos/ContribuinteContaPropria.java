package impostos;

/**
 *
 * @author ANTÓNIO DANIEL BARBOSA FERNANDES
 */
public class ContribuinteContaPropria extends ContribuinteComRendimentoDeTrabalho {

    private String profissao;

    private static final String PROFISSAO_POR_OMISSAO = "Sem Dados";

    private static float taxaRT = 0.03f;
    private static float taxaOR1 = 0.02f;
    private static float taxaOR2 = 0.05f;
    private static int escalao1 = 50000;

    public ContribuinteContaPropria(String nome, String morada, float rendimentoOR, float rendimentoRT, String profissao) {
        super(nome, morada, rendimentoOR, rendimentoRT);
        this.profissao = profissao;
    }

    public ContribuinteContaPropria(String nome, String morada, float rendimentoOR, float rendimentoRT) {
        super(nome, morada, rendimentoOR, rendimentoRT);
        this.profissao = PROFISSAO_POR_OMISSAO;
    }

    public ContribuinteContaPropria(String nome, String morada, float rendimentoOR) {
        super(nome, morada, rendimentoOR);
        this.profissao = PROFISSAO_POR_OMISSAO;
    }

    public ContribuinteContaPropria(String nome, String morada) {
        super(nome, morada);
        this.profissao = PROFISSAO_POR_OMISSAO;
    }

    public ContribuinteContaPropria(String nome) {
        super(nome);
        this.profissao = PROFISSAO_POR_OMISSAO;
    }

    public ContribuinteContaPropria() {
        super();
        this.profissao = PROFISSAO_POR_OMISSAO;
    }

    /**
     * @return the profissao
     */
    public String getProfissao() {
        return profissao;
    }

    /**
     * @param profissao the profissao to set
     */
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String toString() {
        return String.format("%s %n O contribuinte exerce a profissão:%s.", super.toString(), profissao);
    }

    @Override
    public float calcularTaxaRendimentoRT() {
        return getRendimentoRT() * taxaRT;
    }

    @Override
    public float calcularTaxaRendimentoOR() {
        if (getRendimentoOR() < escalao1) {
            return taxaOR1 * getRendimentoOR();
        } else {
            return taxaOR2 * getRendimentoOR();
        }
    }

    /**
     * @return the taxaRT
     */
    public static float getTaxaRT() {
        return taxaRT;
    }

    /**
     * @return the taxaOR1
     */
    public static float getTaxaOR1() {
        return taxaOR1;
    }

    /**
     * @return the taxaOR2
     */
    public static float getTaxaOR2() {
        return taxaOR2;
    }

    /**
     * @return the escalao1
     */
    public static int getEscalao1() {
        return escalao1;
    }

    /**
     * @param aTaxaRT the taxaRT to set
     */
    public static void setTaxaRT(float aTaxaRT) {
        taxaRT = aTaxaRT;
    }

    /**
     * @param aTaxaOR1 the taxaOR1 to set
     */
    public static void setTaxaOR1(float aTaxaOR1) {
        taxaOR1 = aTaxaOR1;
    }

    /**
     * @param aTaxaOR2 the taxaOR2 to set
     */
    public static void setTaxaOR2(float aTaxaOR2) {
        taxaOR2 = aTaxaOR2;
    }

    /**
     * @param aEscalao1 the escalao1 to set
     */
    public static void setEscalao1(int aEscalao1) {
        escalao1 = aEscalao1;
    }

}
