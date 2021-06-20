package credito;

/**
 *
 * @author 1DK_TP1_1190402_1191405_1191604
 */
/**
 * Serve para específicar o crédito ao automóvel (extende a classe Crédito)
 */
public class CreditoDeConsumoAoAutomovel extends Credito {

    //VARIÁVRIS DE CLASSE
    /**
     * @param taxaDeJuroAnual taxa anual que pode vir a ser alterada mas é a
     * mesma para todos os clientes
     */
    private float taxaDeJuroAnual = 6f;
    /**
     * @param descontoMenos24Meses desconto para clientes que pedem pagamento de
     * crédito em menos de 24 meses e que pode vir a ser alterada
     */
    private float descontoMenos24Meses = 1f;
    /**
     * @param quantAutomovel número de créditos de consumo ao automóvel criados
     */
    private static int quantAutomovel;

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
    public CreditoDeConsumoAoAutomovel(String nomeCliente, String profissao, float montante, int prazoFinanciamento) {
        super(nomeCliente, profissao, montante, prazoFinanciamento);
        quantAutomovel++;
    }

    /**
     * Constrói um crédito com os seguintes parâmetros:
     *
     * @param nomeCliente the nome do cliente
     * @param profissao the profissão exercida pelo cliente
     * @param montante the montante do crédito pedido pelo cliente
     */
    public CreditoDeConsumoAoAutomovel(String nomeCliente, String profissao, float montante) {
        super(nomeCliente, profissao, montante);
        quantAutomovel++;
    }

    /**
     * Constrói um crédito com os seguintes parâmetros:
     *
     * @param nomeCliente the nome do cliente
     * @param profissao the profissão exercida pelo cliente
     */
    public CreditoDeConsumoAoAutomovel(String nomeCliente, String profissao) {
        super(nomeCliente, profissao);
        quantAutomovel++;
    }

    /**
     * Constrói um crédito com os seguintes parâmetros:
     *
     * @param nomeCliente the nome do cliente
     */
    public CreditoDeConsumoAoAutomovel(String nomeCliente) {
        super(nomeCliente);
        quantAutomovel++;
    }

    /**
     * Constrói um crédito sem
     */
    public CreditoDeConsumoAoAutomovel() {
        super();
        quantAutomovel++;
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
        float taxa = (taxaDeJuroAnual / 100) / 12;
        float taxaDesconto = (taxaDeJuroAnual - descontoMenos24Meses / 100) / 12;
        float valorAPagarMes = super.getMontante() / super.getPrazoFinanciamento();
        float creditoAPagar = super.getMontante();
        float totalJuros = 0;

        if (super.getPrazoFinanciamento() > 24) {
            for (int i = 0; i < super.getPrazoFinanciamento(); i++) {
                totalJuros += creditoAPagar * taxa;
                creditoAPagar -= valorAPagarMes;
            }
        } else {
            for (int i = 0; i < super.getPrazoFinanciamento(); i++) {
                totalJuros += creditoAPagar * taxaDesconto;
                creditoAPagar -= valorAPagarMes;
            }
        }

        return totalJuros;
    }

    //VARIÁVRIS DE CLASSE- MÉTODOS GET
    /**
     * @return the taxaDeJuroAnual
     */
    public float getTaxaDeJuroAnual() {
        return taxaDeJuroAnual;
    }

    /**
     * @return the descontoMenos24Meses
     */
    public float getDescontoMenos24Meses() {
        return descontoMenos24Meses;
    }

    /**
     * @return the quantAutomovel
     */
    public static int getQuantAutomovel() {
        return quantAutomovel;
    }

    //VARIÁVRIS DE CLASSE- MÉTODOS SET
    /**
     * @param taxaDeJuroAnual the taxaDeJuroAnual to set
     */
    public void setTaxaDeJuroAnual(float taxaDeJuroAnual) {
        this.taxaDeJuroAnual = taxaDeJuroAnual;
    }

    /**
     * @param descontoMenos24Meses the descontoMenos24Meses to set
     */
    public void setDescontoMenos24Meses(float descontoMenos24Meses) {
        this.descontoMenos24Meses = descontoMenos24Meses;
    }

}
