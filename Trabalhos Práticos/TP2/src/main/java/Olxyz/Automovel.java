package Olxyz;

/**
 *
 * @author 1DK_1190402_1191045
 */
/**
 * Serve para criar Automóveis
 */
public class Automovel implements TaxaDeJuroAluguer, TaxaDeJuroVenda {

    /**
     * @param marca the marca do automóvel
     */
    private String marca;
    /**
     * @param modelo the modelo do automóvel
     */
    private String modelo;
    /**
     * @param valorDeVenda the valor de venda do automóvel
     */
    private float valorDeVenda;
    /**
     * @param valorDeAluguer the valor de aluguer do automóvel
     */
    private float valorDeAluguer;
    /**
     * @param MARCA_POR_OMISSAO the marca do automóvel por omissão
     */
    private static final String MARCA_POR_OMISSAO = "Sem Marca";
    /**
     * @param MODELO_POR_OMISSAO the modelo do automóvel por omissão
     */
    private static final String MODELO_POR_OMISSAO = "Sem Modelo";
    /**
     * @param VALOR_DE_VENDA_POR_OMISSAO the valor de venda do automóvel por
     * omissão
     */
    private static final float VALOR_DE_VENDA_POR_OMISSAO = 0;
    /**
     * @param VALOR_DE_ALUGUER_POR_OMISSAO the valor de aluguer do automóvel por
     * omissão
     */
    private static final float VALOR_DE_ALUGUER_POR_OMISSAO = 0;

    /**
     * Constrói um Automovel com os seguintes parâmetros:
     *
     * @param marca the marca do automóvel
     * @param modelo the modelo do automóvel
     * @param valorDeVenda the valor de venda do automóvel
     * @param valorDeAluguer the valor de aluguer do automóvel
     */
    public Automovel(String marca, String modelo, float valorDeVenda, float valorDeAluguer) {
        this.marca = marca;
        this.modelo = modelo;
        this.valorDeVenda = valorDeVenda;
        this.valorDeAluguer = valorDeAluguer;
    }

    /**
     * Constrói um Automovel sem parâmetros:
     */
    public Automovel() {
        this.marca = MARCA_POR_OMISSAO;
        this.modelo = MODELO_POR_OMISSAO;
        this.valorDeVenda = VALOR_DE_VENDA_POR_OMISSAO;
        this.valorDeAluguer = VALOR_DE_ALUGUER_POR_OMISSAO;
    }

    /**
     * Constrói um Automovel _construtor cópia_ copiando a informação de outro:
     *
     * @param outroAutomovel the objeto a copiar
     */
    public Automovel(Automovel outroAutomovel) {
        this.marca = outroAutomovel.marca;
        this.modelo = outroAutomovel.modelo;
        this.valorDeVenda = outroAutomovel.valorDeVenda;
        this.valorDeAluguer = outroAutomovel.valorDeAluguer;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @return the valorDeVenda
     */
    public float getValorDeVenda() {
        return valorDeVenda;
    }

    /**
     * @return the valorDeAluguer
     */
    public float getValorDeAluguer() {
        return valorDeAluguer;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @param valorDeVenda the valorDeVenda to set
     */
    public void setValorDeVenda(float valorDeVenda) {
        this.valorDeVenda = valorDeVenda;
    }

    /**
     * @param valorDeAluguer the valorDeAluguer to set
     */
    public void setValorDeAluguer(float valorDeAluguer) {
        this.valorDeAluguer = valorDeAluguer;
    }

    /**
     * @return informação sobre o automóvel para venda
     */
    public String toStringVenda() {
        return String.format("CARACTERÍSTICAS DO AUTOMÓVEL:\nMARCA: %s\nModelo: %s\nValor De Venda: %.2f €\n", marca, modelo, CalcularValorDeVenda());
    }

    /**
     * @return informação sobre o automóvel para aluguer
     */
    public String toStringAluguer() {
        return String.format("CARACTERÍSTICAS DO AUTOMÓVEL:\nMARCA: %s\nModelo: %s\nValor De Aluguer: %.2f €\n", marca, modelo, CalcularValorDeAluguer());
    }

    /**
     * @return o valor de aluguer do automóvel
     */
    @Override
    public double CalcularValorDeAluguer() {
        return this.valorDeAluguer * CALCULAR_TAXA_ALUGUER;
    }

    /**
     * @return o valor de venda do automóvel
     */
    @Override
    public double CalcularValorDeVenda() {
        return this.valorDeVenda * CALCULAR_TAXA_VENDA;
    }
}
