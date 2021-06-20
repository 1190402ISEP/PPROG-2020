package Olxyz;

/**
 *
 * @author 1DK_1190402_1191045
 */
/**
 * Serve para criar Endereços
 */
public class Endereco {

    /**
     * @param nomeDaRua the nome da rua associado ao endereço
     */
    private String nomeDaRua;
    /**
     * @param codigoPostal the código postal associado ao endereço
     */
    private String codigoPostal;
    /**
     * @param localidade the localidade associada ao endereço
     */
    private String localidade;
    /**
     * @param NOME_DA_RUA_POR_OMISSAO the nome da rua por omissão associado ao
     * endereço
     */
    private static final String NOME_DA_RUA_POR_OMISSAO = "Rua Sem Nome";
    /**
     * @param CODIGO_POSTAL_POR_OMISSAO the código postal por omissão associado
     * ao endereço
     */
    private static final String CODIGO_POSTAL_POR_OMISSAO = "Sem Infomação de Código Postal";
    /**
     * @param LOCALIDADE_POR_OMISSAO the localidade por omissão associada ao
     * endereço
     */
    private static final String LOCALIDADE_POR_OMISSAO = "Sem Localidade";

    /**
     * Constrói um Automovel com os seguintes parâmetros:
     *
     * @param nomeDaRua the nome da rua associado ao endereço
     * @param codigoPostal the código postal associado ao endereço
     * @param localidade the localidade associada ao endereço
     */
    public Endereco(String nomeDaRua, String codigoPostal, String localidade) {
        this.nomeDaRua = nomeDaRua;
        this.codigoPostal = codigoPostal;
        this.localidade = localidade;
    }

    /**
     * Constrói um Automovel sem parâmetros:
     */
    public Endereco() {
        this.nomeDaRua = NOME_DA_RUA_POR_OMISSAO;
        this.codigoPostal = CODIGO_POSTAL_POR_OMISSAO;
        this.localidade = LOCALIDADE_POR_OMISSAO;
    }

    /**
     * Constrói um Endereco _construtor cópia_ copiando a informação de outro:
     *
     * @param outroEndereco the objeto a copiar
     */
    public Endereco(Endereco outroEndereco) {
        this.nomeDaRua = outroEndereco.nomeDaRua;
        this.codigoPostal = outroEndereco.codigoPostal;
        this.localidade = outroEndereco.localidade;
    }

    /**
     * @return the nomeDaRua
     */
    public String getNomeDaRua() {
        return nomeDaRua;
    }

    /**
     * @return the codigoPostal
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * @return the localidade
     */
    public String getLocalidade() {
        return localidade;
    }

    /**
     * @param nomeDaRua the nomeDaRua to set
     */
    public void setNomeDaRua(String nomeDaRua) {
        this.nomeDaRua = nomeDaRua;
    }

    /**
     * @param codigoPostal the codigoPostal to set
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * @param localidade the localidade to set
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    /**
     * @param outroEndereco the outroEndereco to set
     */
    public void setEndereco(Endereco outroEndereco) {
        this.nomeDaRua = outroEndereco.nomeDaRua;
        this.codigoPostal = outroEndereco.codigoPostal;
        this.localidade = outroEndereco.localidade;
    }

    /**
     * @return informações sobre o endereço
     */
    @Override
    public String toString() {
        return String.format("Rua: %s\nCódigo Postal: %s\nLocalidade: %s\n", nomeDaRua, codigoPostal, localidade);
    }
}
