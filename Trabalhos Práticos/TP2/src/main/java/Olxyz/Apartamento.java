package Olxyz;

/**
 *
 * @author 1DK_1190402_1191045
 */
/**
 * Serve para criar Apartamentos
 */
public class Apartamento implements TaxaDeJuroAluguer {

    /**
     * @param endereco the endereço do apartamento
     */
    private Endereco endereco;
    /**
     * @param area the área do apartamento
     */
    private float area;
    /**
     * @param valorDeAluguer the valor do aluguer do apartamento
     */
    private float valorDeAluguer;
    /**
     * @param ENDERECO_POR_OMISSAO the endereço do apartamento por omissão
     */
    private static final Endereco ENDERECO_POR_OMISSAO = new Endereco();
    /**
     * @param AREA_POR_OMISSAO the área do apartamento por omissão
     */
    private static final float AREA_POR_OMISSAO = 0;
    /**
     * @param VALOR_DE_ALUGUER_POR_OMISSAO the valor de aluguer do apartamento
     * por omissão
     */
    private static final float VALOR_DE_ALUGUER_POR_OMISSAO = 0;

    /**
     * Constrói um Apartamento com os seguintes parâmetros:
     *
     * @param nomeDaRua the nome da rua do apartamento
     * @param codigoPostal the código postal do endereço do apartamento
     * @param localidade the localidade do apartamento
     * @param area the area em m2 do apartamento
     * @param valorDeAluguer the valor de aluguer do apartamento
     */
    public Apartamento(String nomeDaRua, String codigoPostal, String localidade, float area, float valorDeAluguer) {
        this.endereco = new Endereco(nomeDaRua, codigoPostal, localidade);
        this.area = area;
        this.valorDeAluguer = valorDeAluguer;
    }

    /**
     * Constrói um Apartamento com os seguintes parâmetros:
     *
     * @param endereco the endereço do apartamento
     * @param area the area em m2 do apartamento
     * @param valorDeAluguer the valor de aluguer do apartamento
     */
    public Apartamento(Endereco endereco, float area, float valorDeAluguer) {
        this.endereco = new Endereco(endereco);
        this.area = area;
        this.valorDeAluguer = valorDeAluguer;
    }

    /**
     * Constrói um Apartamento sem parâmetros:
     */
    public Apartamento() {
        this.endereco = ENDERECO_POR_OMISSAO;
        this.area = AREA_POR_OMISSAO;
        this.valorDeAluguer = VALOR_DE_ALUGUER_POR_OMISSAO;
    }

    /**
     * Constrói um Apartamento _construtor cópia_ copiando a informação de
     * outro:
     *
     * @param apartamento the objeto a copiar
     */
    public Apartamento(Apartamento apartamento) {
        this.endereco = new Endereco(apartamento.endereco);
        this.area = apartamento.area;
        this.valorDeAluguer = apartamento.valorDeAluguer;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return new Endereco(endereco);
    }

    /**
     * @return the area
     */
    public float getArea() {
        return area;
    }

    /**
     * @return the valorDeAluguer
     */
    public float getValorDeAluguer() {
        return valorDeAluguer;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco.setEndereco(endereco);
    }

    /**
     * @param Rua the Rua to set
     */
    public void setRua(String Rua) {
        this.endereco.setNomeDaRua(Rua);
    }

    /**
     * @param codigoPostal the codigoPostal to set
     */
    public void setCodigoPostal(String codigoPostal) {
        this.endereco.setCodigoPostal(codigoPostal);
    }

    /**
     * @param localidade the localidade to set
     */
    public void setLocalidade(String localidade) {
        this.endereco.setLocalidade(localidade);
    }

    /**
     * @param area the area to set
     */
    public void setArea(float area) {
        this.area = area;
    }

    /**
     * @param valorDeAluguer the valorDeAluguer to set
     */
    public void setValorDeAluguer(float valorDeAluguer) {
        this.valorDeAluguer = valorDeAluguer;
    }

    /**
     * @return informações sobre o apartamento
     */
    @Override
    public String toString() {
        return String.format("APARTAMENTO\n%sArea: %.2f m^2\nValor De Aluguer: %.2f €\n", endereco.toString(), area, CalcularValorDeAluguer());
    }

    /**
     * @return valor de aluguer do apartamento
     */
    @Override
    public double CalcularValorDeAluguer() {
        return this.valorDeAluguer * CALCULAR_TAXA_ALUGUER;
    }
}
