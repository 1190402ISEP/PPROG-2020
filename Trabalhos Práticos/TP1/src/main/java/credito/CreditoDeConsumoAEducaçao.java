package credito;

/**
 *
 * @author 1DK_TP1_1190402_1191405_1191604
 */
/**
 * Serve para específicar o crédito à educação (extende a classe Crédito)
 */
public class CreditoDeConsumoAEducaçao extends Credito {

    //VARIÁVEIS DE INSTÂNCIA 
    /**
     * @param periodoDeCarencia the período de carência relativo ao crédito
     */
    private int periodoDeCarencia;

    //CONSTANTES
    /**
     * @param PERIODO_DE_CARENCIA_POR_OMISSAO the valor por defeito
     */
    private static final int PERIODO_DE_CARENCIA_POR_OMISSAO = 0;

    //VARIÁVEIS DE CLASSE
    /**
     * @param juroAnual taxa anual que pode ser alterada mas igual para todos os
     * créditos à educação
     */
    private static float juroAnual = 2f;
    
    /**
     * @param quantEducacao número de créditos de consumo à educação criados
     */   
    private static int quantEducacao;

    //CONSTRUTORES
    /**
     * Constrói um crédito com os seguintes parâmetros:
     *
     * @param nomeCliente the nome do cliente
     * @param profissao the profissão exercida pelo cliente
     * @param montante the montante do crédito pedido pelo cliente
     * @param prazoFinanciamento the prazo de financiamento do crédito em
     * questão
     * @param periodoDeCarencia the período de carência relativo ao crédito
     */
    public CreditoDeConsumoAEducaçao(String nomeCliente, String profissao, float montante, int prazoFinanciamento, int periodoDeCarencia) {
        super(nomeCliente, profissao, montante, prazoFinanciamento);
        this.periodoDeCarencia = periodoDeCarencia;
        quantEducacao++;
    }

    /**
     * Constrói um crédito com os seguintes parâmetros:
     *
     * @param nomeCliente the nome do cliente
     * @param profissao the profissão exercida pelo cliente
     * @param montante the montante do crédito pedido pelo cliente
     * @param prazoFinanciamento the prazo de financiamento do crédito em
     * questão
     */
    public CreditoDeConsumoAEducaçao(String nomeCliente, String profissao, float montante, int prazoFinanciamento) {
        super(nomeCliente, profissao, montante, prazoFinanciamento);
        this.periodoDeCarencia = PERIODO_DE_CARENCIA_POR_OMISSAO;
        quantEducacao++;
    }

    /**
     * Constrói um crédito com os seguintes parâmetros:
     *
     * @param nomeCliente the nome do cliente
     * @param profissao the profissão exercida pelo cliente
     * @param montante the montante do crédito pedido pelo cliente
     */
    public CreditoDeConsumoAEducaçao(String nomeCliente, String profissao, float montante) {
        super(nomeCliente, profissao, montante);
        this.periodoDeCarencia = PERIODO_DE_CARENCIA_POR_OMISSAO;
        quantEducacao++;
    }

    /**
     * Constrói um crédito com os seguintes parâmetros:
     *
     * @param nomeCliente the nome do cliente
     * @param profissao the profissão exercida pelo cliente
     */
    public CreditoDeConsumoAEducaçao(String nomeCliente, String profissao) {
        super(nomeCliente, profissao);
        this.periodoDeCarencia = PERIODO_DE_CARENCIA_POR_OMISSAO;
        quantEducacao++;
    }

    /**
     * Constrói um crédito com os seguintes parâmetros:
     *
     * @param nomeCliente the nome do cliente
     */
    public CreditoDeConsumoAEducaçao(String nomeCliente) {
        super(nomeCliente);
        this.periodoDeCarencia = PERIODO_DE_CARENCIA_POR_OMISSAO;
        quantEducacao++;
    }

    /**
     * Constrói um crédito sem parâmetros:
     *
     *
     */
    public CreditoDeConsumoAEducaçao() {
        super();
        this.periodoDeCarencia = PERIODO_DE_CARENCIA_POR_OMISSAO;
        quantEducacao++;
    }

    //VARIÁVEIS DE INSTÂNCIA - MÉTODOS GET
    /**
     * @return the períodoDeCarência
     */
    public int getPeriodoDeCarencia() {
        return periodoDeCarencia;
    }

    //VARIÁVEIS DE INSTÂNCIA- MÉTODOS SET
    /**
     * @param periodoDeCarencia the períodoDeCarência to set
     */
    public void setPeriodoDeCarencia(int periodoDeCarencia) {
        this.periodoDeCarencia = periodoDeCarencia;
    }

    //TO STRING
    /**
     * @return para além do toString da superclasse informa ainda o período de
     * carência e o juro anual
     */
    @Override
    public String toString() {
        return String.format("%s %n Neste crédito à educação o período de carência é de %d mêses", super.toString(), getPeriodoDeCarencia());
    }

    //MÉTODOS DE CÁLCULO
    /**
     * @return the montante recebido relativamente a cada crédito
     */
    @Override
    public float calcularMontanteAReceberPorCadaCredito() {
        return super.getMontante() + calcularMontanteTotalJuros();
    }

    /**
     * @return the valor do montante total dos juros
     */
    @Override
    public float calcularMontanteTotalJuros() {
        float taxa = (juroAnual / 100) / 12;
        float valorAPagarMes = super.getMontante() / (super.getPrazoFinanciamento() - periodoDeCarencia);
        float creditoAPagar = super.getMontante();
        float totalJuros = 0;
        float juroInicial = creditoAPagar * taxa;

        for (int i = periodoDeCarencia; i < super.getPrazoFinanciamento(); i++) {
            totalJuros += creditoAPagar * taxa;
            creditoAPagar -= valorAPagarMes;
        }

        return totalJuros + (juroInicial * periodoDeCarencia);
    }
    
    //VARIÁVEIS DE CLASSE- MÉTODOS GET 
    /**
     * @return the juroAnual
     */
    public static float getJuroAnual() {
        return juroAnual;
    }
    
    /**
     * @return the quantEducacao
     */
    public static int getQuantEducacao() {
        return quantEducacao;
    }

    //VARIÁVEIS DE CLASSE- MÉTODOS SET
    /**
     * @param aJuroAnual the juroAnual to set
     */
    public static void setJuroAnual(float aJuroAnual) {
        juroAnual = aJuroAnual;
    }

}
