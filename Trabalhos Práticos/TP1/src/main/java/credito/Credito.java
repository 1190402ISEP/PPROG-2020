package credito;

/**
 *
 * @author 1DK_TP1_1190402_1191405_1191604
 */
/**
 * Serve para criar créditos
 */
public abstract class Credito {

//VARIÁVEIS DE INSTÂNCIA
    /**
     * @param nomeCliente the nome do cliente
     */
    private String nomeCliente;

    /**
     * @param profissao the profissão exercida pelo cliente
     */
    private String profissao;

    /**
     * @param montante the montante do crédito pedido pelo cliente
     */
    private float montante;

    /**
     * @param prazoFinanciamento the prazo de financiamento do crédito em
     * questão
     */
    private int prazoFinanciamento;

//CONSTANTES
    /**
     * @param NOME_POR_OMISSAO the inicialização por defeito do nome do cliente
     */
    private static final String NOME_POR_OMISSAO = "Sem Nome";

    /**
     * @param PROFISSAO_DO_CLIENTE_POR_OMISSAO the inicialização por defeito da
     * profissão do cliente
     */
    private static final String PROFISSAO_DO_CLIENTE_POR_OMISSAO = "Sem registo";

    /**
     * @param MONTANTE_POR_OMISSAO the inicialização por defeito do montante do
     * crédito
     */
    private static final float MONTANTE_POR_OMISSAO = 0;

    /**
     * @param PRAZO_DE_FINANCIAMENTO_POR_OMISSAO the inicialização por defeito
     * do prazo de financiamento
     */
    private static final int PRAZO_DE_FINANCIAMENTO_POR_OMISSAO = 0;

//CONSTRUTORES
    /**
     * Constrói um crédito com os seguintes parâmetros:
     *
     * @param nomeCliente the nome do cliente
     * @param profissao the profissão exercida pelo cliente
     * @param montante the montante do crédito pedido pelo cliente
     * @param prazoFinanciamento the prazo de financiamento do crédito em
     * questão
     */
    public Credito(String nomeCliente, String profissao, float montante, int prazoFinanciamento) {
        this.nomeCliente = nomeCliente;
        this.profissao = profissao;
        this.montante = montante;
        this.prazoFinanciamento = prazoFinanciamento;
    }

    /**
     * Constrói um crédito com os seguintes parâmetros:
     *
     * @param nomeCliente the nome do cliente
     * @param profissao the profissão exercida pelo cliente
     * @param montante the montante do crédito pedido pelo cliente
     */
    public Credito(String nomeCliente, String profissao, float montante) {
        this.nomeCliente = nomeCliente;
        this.profissao = profissao;
        this.montante = montante;
        this.prazoFinanciamento = PRAZO_DE_FINANCIAMENTO_POR_OMISSAO;
    }

    /**
     * Constrói um crédito com os seguintes parâmetros:
     *
     * @param nomeCliente the nome do cliente
     * @param profissao the profissão exercida pelo cliente
     */
    public Credito(String nomeCliente, String profissao) {
        this.nomeCliente = nomeCliente;
        this.profissao = profissao;
        this.montante = MONTANTE_POR_OMISSAO;
        this.prazoFinanciamento = PRAZO_DE_FINANCIAMENTO_POR_OMISSAO;
    }

    /**
     * Constrói um crédito com os seguintes parâmetros:
     *
     * @param nomeCliente the nome do cliente
     */
    public Credito(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.profissao = PROFISSAO_DO_CLIENTE_POR_OMISSAO;
        this.montante = MONTANTE_POR_OMISSAO;
        this.prazoFinanciamento = PRAZO_DE_FINANCIAMENTO_POR_OMISSAO;
    }

    /**
     * Constrói um crédito sem parâmetros:
     */
    public Credito() {
        this.nomeCliente = NOME_POR_OMISSAO;
        this.profissao = PROFISSAO_DO_CLIENTE_POR_OMISSAO;
        this.montante = MONTANTE_POR_OMISSAO;
        this.prazoFinanciamento = PRAZO_DE_FINANCIAMENTO_POR_OMISSAO;
    }

    //VARIÁVEIS DE INSTÂNCIA- MÉTODOS GET
    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @return the profissão
     */
    public String getProfissao() {
        return profissao;
    }

    /**
     * @return the montante
     */
    public float getMontante() {
        return montante;
    }

    /**
     * @return the prazoFinanciamento
     */
    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    //VARIÁVEIS DE INSTÂNCIA- MÉTODOS SET
    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @param profissao the profissão to set
     */
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    /**
     * @param montante the montante to set
     */
    public void setMontante(float montante) {
        this.montante = montante;
    }

    /**
     * @param prazoFinanciamento the prazoFinanciamento to set
     */
    public void setPrazoFinanciamento(int prazoFinanciamento) {
        this.prazoFinanciamento = prazoFinanciamento;
    }

    //TO STRING
    @Override
    /**
     * @return informações sobre o crédito por extenso e explícito
     */
    public String toString() {
        return String.format("O(A) cliente: %s, exerce a profissão de: %s, o montante referente ao seu crédito é de %.2f euros e o prazo de financiamento é de %d meses.", nomeCliente, profissao, montante, prazoFinanciamento);
    }

    //MÉTODOS ABSTRATOS DE CÁLCULO
    public abstract float calcularMontanteAReceberPorCadaCredito();

    public abstract float calcularMontanteTotalJuros();

}
