package impostos;

/**
 *
 * @author ANTÓNIO DANIEL BARBOSA FERNANDES
 */
public class ContribuinteContaOutrem extends ContribuinteComRendimentoDeTrabalho {

    private String nomeDaEmpresa;

    private static final String NOME__DA_EMPRESA_POR_OMISSAO = "Sem nome";

    private static float taxaRT1 = 0.01f;
    private static float taxaRT2 = 0.02f;
    private static float taxaOR = 0.02f;
    private static int escalao1 = 30000;

    public ContribuinteContaOutrem(String nome, String morada, float rendimentoOR, float rendimentoRT, String nomeDaEmpresa) {
        super(nome, morada, rendimentoOR, rendimentoRT);
        this.nomeDaEmpresa = nomeDaEmpresa;
    }

    public ContribuinteContaOutrem(String nome, String morada, float rendimentoOR, float rendimentoRT) {
        super(nome, morada, rendimentoOR, rendimentoRT);
        this.nomeDaEmpresa = NOME__DA_EMPRESA_POR_OMISSAO;
    }

    public ContribuinteContaOutrem(String nome, String morada, float rendimentoOR) {
        super(nome, morada, rendimentoOR);
        this.nomeDaEmpresa = NOME__DA_EMPRESA_POR_OMISSAO;
    }

    public ContribuinteContaOutrem(String nome, String morada) {
        super(nome, morada);
        this.nomeDaEmpresa = NOME__DA_EMPRESA_POR_OMISSAO;
    }

    public ContribuinteContaOutrem(String nome) {
        super(nome);
        this.nomeDaEmpresa = NOME__DA_EMPRESA_POR_OMISSAO;
    }

    public ContribuinteContaOutrem() {
        super();
        this.nomeDaEmpresa = NOME__DA_EMPRESA_POR_OMISSAO;
    }

    /**
     * @return the nomeDaEmpresa
     */
    public String getNomeDaEmpresa() {
        return nomeDaEmpresa;
    }

    /**
     * @param nomeDaEmpresa the nomeDaEmpresa to set
     */
    public void setNomeDaEmpresa(String nomeDaEmpresa) {
        this.nomeDaEmpresa = nomeDaEmpresa;
    }

    public String toString() {
        return String.format("%s %n O nome da empresa para o qual trabalha é: %s.", super.toString(), nomeDaEmpresa);
    }

    @Override
    public float calcularTaxaRendimentoRT() {
        if (getRendimentoRT() < getEscalao1()) {
            return getTaxaRT1() * getRendimentoRT();
        } else {
            return getTaxaRT2() * getRendimentoRT();
        }
    }

    @Override
    public float calcularTaxaRendimentoOR() {
        return getTaxaOR() * getRendimentoOR();
    }

    /**
     * @return the taxaRT1
     */
    public static float getTaxaRT1() {
        return taxaRT1;
    }

    /**
     * @return the taxaRT2
     */
    public static float getTaxaRT2() {
        return taxaRT2;
    }

    /**
     * @return the taxaOR
     */
    public static float getTaxaOR() {
        return taxaOR;
    }

    /**
     * @return the escalao1
     */
    public static int getEscalao1() {
        return escalao1;
    }

    /**
     * @param aTaxaRT1 the taxaRT1 to set
     */
    public static void setTaxaRT1(float aTaxaRT1) {
        taxaRT1 = aTaxaRT1;
    }

    /**
     * @param aTaxaRT2 the taxaRT2 to set
     */
    public static void setTaxaRT2(float aTaxaRT2) {
        taxaRT2 = aTaxaRT2;
    }

    /**
     * @param aTaxaOR the taxaOR to set
     */
    public static void setTaxaOR(float aTaxaOR) {
        taxaOR = aTaxaOR;
    }

    /**
     * @param aEscalao1 the escalao1 to set
     */
    public static void setEscalao1(int aEscalao1) {
        escalao1 = aEscalao1;
    }

}
