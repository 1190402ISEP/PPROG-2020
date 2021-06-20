package impostos;

/**
 *
 * @author ANTÓNIO DANIEL BARBOSA FERNANDES
 */
public abstract class Contribuinte {

    private String nome;
    private String morada;
    private float rendimentoOR;

    private static final String NOME_POR_OMISSAO = "Sem Nome";
    private static final String MORADA_POR_OMISSAO = "Sem Morada";
    private static final float RENDIMENTO_OR_POR_OMISSAO = 0;

    public Contribuinte(String nome, String morada, float rendimentoOR) {
        this.nome = nome;
        this.morada = morada;
        this.rendimentoOR = rendimentoOR;
    }

    public Contribuinte(String nome, String morada) {
        this.nome = nome;
        this.morada = morada;
        this.rendimentoOR = RENDIMENTO_OR_POR_OMISSAO;
    }

    public Contribuinte(String nome) {
        this.nome = nome;
        this.morada = MORADA_POR_OMISSAO;
        this.rendimentoOR = RENDIMENTO_OR_POR_OMISSAO;
    }

    public Contribuinte() {
        this.nome = NOME_POR_OMISSAO;
        this.morada = MORADA_POR_OMISSAO;
        this.rendimentoOR = RENDIMENTO_OR_POR_OMISSAO;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the morada
     */
    public String getMorada() {
        return morada;
    }

    /**
     * @return the taxaOR
     */
    public float getRendimentoOR() {
        return rendimentoOR;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param morada the morada to set
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * @param taxaOR the taxaOR to set
     */
    public void setrendimentoOR(float rendimentoOR) {
        this.rendimentoOR = rendimentoOR;
    }

    public String toString() {
        return String.format("O contribuinte %s ,mora em %s e apresenta um valor de outros rendimentos igual a %f euros.", nome, morada, rendimentoOR);
    }

    public abstract float calcularImposto();

}
