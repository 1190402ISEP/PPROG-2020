/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impostos;

/**
 *
 * @author ANTÓNIO DANIEL BARBOSA FERNANDES
 */
public class Reformado extends ContribuinteComRendimentoDeTrabalho {

    private static float taxaRT = 0.01f;
    private static float taxaOR = 0.03f;

    public Reformado(String nome, String morada, float rendimentoOR, float rendimentoRT) {
        super(nome, morada, rendimentoOR, rendimentoRT);
    }

    public Reformado(String nome, String morada, float rendimentoOR) {
        super(nome, morada, rendimentoOR);
    }

    public Reformado(String nome, String morada) {
        super(nome, morada);
    }

    public Reformado(String nome) {
        super(nome);
    }

    public Reformado() {
        super();
    }

    public String toString() {
        return String.format("%s %n O contribuinte encontra-se reformado.", super.toString());
    }

    @Override
    public float calcularTaxaRendimentoRT() {
        return getTaxaRT() * getRendimentoRT();
    }

    @Override
    public float calcularTaxaRendimentoOR() {
        return getTaxaOR() * getRendimentoOR();
    }

    /**
     * @return the taxaRT
     */
    public static float getTaxaRT() {
        return taxaRT;
    }

    /**
     * @return the taxaOR
     */
    public static float getTaxaOR() {
        return taxaOR;
    }

    /**
     * @param aTaxaRT the taxaRT to set
     */
    public static void setTaxaRT(float aTaxaRT) {
        taxaRT = aTaxaRT;
    }

    /**
     * @param aTaxaOR the taxaOR to set
     */
    public static void setTaxaOR(float aTaxaOR) {
        taxaOR = aTaxaOR;
    }

}
