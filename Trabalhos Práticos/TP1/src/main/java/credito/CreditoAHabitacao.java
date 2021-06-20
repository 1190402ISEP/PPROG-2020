package credito;

/**
 *
 * @author 1DK_TP1_1190402_1191405_1191604
 */
/**
 * Serve para específicar o crédito à habitação (extende a classe Crédito)
 */
public class CreditoAHabitacao extends Credito {

    //VARIÁVEIS DE INSTÂNCIA
    /**
     * @param spread spread do crédito
     */
    private float spread;

    //CONSTANTES
    /**
     * @param SPREAD_POR_OMISSAO valor por defeito
     */
    private static final float SPREAD_POR_OMISSAO = 0;

    //VARIÁVEIS DE CLASSE
    /**
     * @param taxaEuriborA12Meses taxa que pode ser alterada mas igual para
     * todos os créditos à habitação
     */
    private static float taxaEuriborA12Meses = 0.1f;

    /**
     * @param quantHabitacao número de créditos por habitação criados
     */
    private static int quantHabitacao;

    //CONSTRUTORES
    /**
     * Constrói um crédito com os seguintes parâmetros:
     *
     * @param nomeCliente the nome do cliente
     * @param profissao the profissão exercida pelo cliente
     * @param montante the montante do crédito pedido pelo cliente
     * @param prazoFinanciamento the prazo de financiamento do crédito em
     * questão
     * @param spread the spread do crédito
     */
    public CreditoAHabitacao(String nomeCliente, String profissao, float montante, int prazoFinanciamento, float spread) {
        super(nomeCliente, profissao, montante, prazoFinanciamento);
        this.spread = spread;
        quantHabitacao++;
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
    public CreditoAHabitacao(String nomeCliente, String profissao, float montante, int prazoFinanciamento) {
        super(nomeCliente, profissao, montante, prazoFinanciamento);
        this.spread = SPREAD_POR_OMISSAO;
        quantHabitacao++;
    }

    /**
     * Constrói um crédito com os seguintes parâmetros:
     *
     * @param nomeCliente the nome do cliente
     * @param profissao the profissão exercida pelo cliente
     * @param montante the montante do crédito pedido pelo cliente
     */
    public CreditoAHabitacao(String nomeCliente, String profissao, float montante) {
        super(nomeCliente, profissao, montante);
        this.spread = SPREAD_POR_OMISSAO;
        quantHabitacao++;
    }

    /**
     * Constrói um crédito com os seguintes parâmetros:
     *
     * @param nomeCliente the nome do cliente
     * @param profissao the profissão exercida pelo cliente
     */
    public CreditoAHabitacao(String nomeCliente, String profissao) {
        super(nomeCliente, profissao);
        this.spread = SPREAD_POR_OMISSAO;
        quantHabitacao++;
    }

    /**
     * Constrói um crédito com os seguintes parâmetros:
     *
     * @param nomeCliente the nome do cliente
     */
    public CreditoAHabitacao(String nomeCliente) {
        super(nomeCliente);
        this.spread = SPREAD_POR_OMISSAO;
        quantHabitacao++;
    }

    /**
     * Constrói um crédito sem parâmetros:
     *
     *
     */
    public CreditoAHabitacao() {
        super();
        this.spread = SPREAD_POR_OMISSAO;
        quantHabitacao++;
    }

    //VARIÁVEIS DE INSTÂNCIA -MÉTODOS GET
    /**
     * @return the spread
     */
    public float getSpread() {
        return spread;
    }

    //VARIÁVEIS DE INSTÂNCIA -MÉTODOS SET
    /**
     * @param spread the spread to set
     */
    public void setSpread(float spread) {
        this.spread = spread;
    }

    //TO STRING
    /**
     * @return informa para além da informação do toString da superclasse o
     * valor do spread e da taxa Euribor
     */
    @Override
    public String toString() {
        return String.format("%s%nO crédito à habitação tem um spread de %.2f%%.", super.toString(), spread);
    }

    //MÉTODOS DE CÁLCULO
    /**
     * @return montante recebido relativamente a cada crédito
     */
    @Override
    public float calcularMontanteAReceberPorCadaCredito() {
        return super.getMontante() + calcularMontanteTotalJuros();
    }

    /**
     * @return valor do montante total dos juros
     */
    @Override
    public float calcularMontanteTotalJuros() {
        float valorAPagarMes = super.getMontante() / super.getPrazoFinanciamento();
        float taxas = ((taxaEuriborA12Meses / 100 / 12) + (spread / 100) / 12);
        float creditoAPagar = super.getMontante();
        float totalJuros = 0;

        for (int i = 0; i < super.getPrazoFinanciamento(); i++) {
            totalJuros += creditoAPagar * taxas;
            creditoAPagar -= valorAPagarMes;
        }

        return totalJuros;
    }

    //VARIÁVEIS DE CLASSE- MÉTODOS GET
    /**
     * @return the taxaEuriborA12Meses
     */
    public static float getTaxaEuriborA12Meses() {
        return taxaEuriborA12Meses;
    }
    
    /**
     * @return the quantHabitacao
     */
    public static int getQuantHabitacao() {
        return quantHabitacao;
    }

    //VARIÁVEIS DE CLASSE- MÉTODOS SET
    /**
     * @param aTaxaEuriborA12Meses the taxaEuriborA12Meses to set
     */
    public static void setTaxaEuriborA12Meses(float aTaxaEuriborA12Meses) {
        taxaEuriborA12Meses = aTaxaEuriborA12Meses;
    }

}
