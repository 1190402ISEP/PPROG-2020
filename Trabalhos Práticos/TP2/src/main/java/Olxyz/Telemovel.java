package Olxyz;

/**
 *
 * @author 1DK_1190402_1191045
 */
/**
 * Serve para criar Telemóveis
 */
public class Telemovel implements TaxaDeJuroVenda {

    /**
     * @param designacao the designação do telemóvel
     */
    private String designacao;
    /**
     * @param valorDeVenda the valor de venda do telemóvel
     */
    private float valorDeVenda;
    /**
     * @param DESIGNACAO_POR_OMISSAO the designação do telemóvel por omissão
     */
    private static final String DESIGNACAO_POR_OMISSAO = "Telemóvel Sem Designação";
    /**
     * @param VALOR_DE_VENDA_POR_OMISSAO the valor de venda do telemóvel por
     * omissão
     */
    private static final float VALOR_DE_VENDA_POR_OMISSAO = 0;

    /**
     * Constrói um Telemovel com os seguintes parâmetros:
     *
     * @param designacao the designação do telemóvel
     * @param valorDeVenda the valor de venda do telemóvel
     */
    public Telemovel(String designacao, float valorDeVenda) {
        this.designacao = designacao;
        this.valorDeVenda = valorDeVenda;
    }

    /**
     * Constrói um Telemovel sem parâmetros:
     */
    public Telemovel() {
        this.designacao = DESIGNACAO_POR_OMISSAO;
        this.valorDeVenda = VALOR_DE_VENDA_POR_OMISSAO;
    }

    /**
     * Constrói um Telemovel _construtor cópia_ copiando a informação de outro:
     *
     * @param outroTelemovel the objeto a copiar
     */
    public Telemovel(Telemovel outroTelemovel) {
        this.designacao = outroTelemovel.designacao;
        this.valorDeVenda = outroTelemovel.valorDeVenda;
    }

    /**
     * @return the designacao
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     * @return the valorDeVenda
     */
    public float getValorDeVenda() {
        return valorDeVenda;
    }

    /**
     * @param designacao the designacao to set
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    /**
     * @param valorDeVenda the valorDeVenda to set
     */
    public void setValorDeVenda(float valorDeVenda) {
        this.valorDeVenda = valorDeVenda;
    }

    /**
     * @return informações sobre o telemóvel
     */
    @Override
    public String toString() {
        return String.format("TELEMÓVEL\nDesignação: %s\nCusto: %.2f €\n", designacao, CalcularValorDeVenda());
    }

    /**
     * @return the valor de venda do telemóvel
     */
    @Override
    public double CalcularValorDeVenda() {
        return this.valorDeVenda * CALCULAR_TAXA_VENDA;
    }

}
