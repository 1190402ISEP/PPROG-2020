/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contribuinte;

/**
 *
 * @author pokem
 */
public class TrabOutrem extends Contribuinte {

    private String nomeEmpresa;

    private static double taxaRTa = 0.01;
    private static double taxaRTb = 0.02;
    private static double taxaOR = 0.02;
    private static double limiteRT = 30000;

    public TrabOutrem(String nome, String morada, double rendimentosTrabalho, double outrosRendimentos, String nomeEmpresa) {
        super(nome, morada, rendimentosTrabalho, outrosRendimentos);
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getNomeEmpresa() {
        return this.nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    @Override
    public String toString() {
        return String.format("%s, e trabalha na empresa %s.", super.toString(), this.nomeEmpresa);
    }

    @Override
    protected double taxaRT() {
        return super.getRendimentosTrabalho() < TrabOutrem.limiteRT ? TrabOutrem.taxaRTa : TrabOutrem.taxaRTb;
    }

    @Override
    protected double taxaOR() {
        return TrabOutrem.taxaOR;
    }

    public static double getTaxaRTa() {
        return TrabOutrem.taxaRTa;
    }

    public static double getTaxaRTb() {
        return TrabOutrem.taxaRTb;
    }

    public static double getTaxaOR() {
        return TrabOutrem.taxaOR;
    }

    public static double getLimiteRT() {
        return TrabOutrem.limiteRT;
    }

    public static void setTaxaRTa(double TaxaRTa) {
        TrabOutrem.taxaRTa = TaxaRTa;
    }

    public static void setTaxaRTb(double TaxaRTb) {
        TrabOutrem.taxaRTb = TaxaRTb;
    }

    public static void setTaxaOR(double TaxaOR) {
        TrabOutrem.taxaOR = TaxaOR;
    }

    public static void setLimiteRT(double aLimiteRT) {
        TrabOutrem.limiteRT = aLimiteRT;
    }

}
