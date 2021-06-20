package credito;

/**
 *
 * @author 1DK_TP1_1190402_1191405_1191604
 */
public class MainCredito {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //a)        
        CreditoAHabitacao CH1 = new CreditoAHabitacao("Rui", "Piloto", 130000, 120, 1);
        CreditoAHabitacao CH2 = new CreditoAHabitacao("António", "Informático", 90000, 60, 4);

        CreditoDeConsumoAoAutomovel CCA1 = new CreditoDeConsumoAoAutomovel("Pedro", "Designer", 150000, 250);
        CreditoDeConsumoAoAutomovel CCA2 = new CreditoDeConsumoAoAutomovel("Soares", "P.S.P.", 100000, 200);

        CreditoDeConsumoAEducaçao CCE1 = new CreditoDeConsumoAEducaçao("Daniel", "Sapateiro", 120000, 240, 1);
        CreditoDeConsumoAEducaçao CCE2 = new CreditoDeConsumoAEducaçao("José", "Carpinteiro", 5000, 36, 12);

        //b)
        Credito Array[] = new Credito[10];

        Array[0] = CH1;
        Array[1] = CH2;
        Array[2] = CCA1;
        Array[3] = CCA2;
        Array[4] = CCE1;
        Array[5] = CCE2;

        //c)
        for (int i = 0; i < Array.length; i++) {
            if (Array[i] != null) {
                System.out.printf("Cliente: %s%nValor recebido pela instituição bancária: %.2f€%n", Array[i].getNomeCliente(), Array[i].calcularMontanteAReceberPorCadaCredito());
            }
        }

        System.out.println();

        for (int i = 0; i < Array.length; i++) {
            if (Array[i] != null) {
                System.out.printf("Cliente: %s%nValor total dos juros a pagar: %.2f€%n", Array[i].getNomeCliente(), Array[i].calcularMontanteTotalJuros());
            }
        }

        System.out.println();

        //d)
        System.out.printf("Instâncias de créditos à habitação: %d%nInstâncias de créditos ao consumo: %d%n", CreditoAHabitacao.getQuantHabitacao(), CreditoDeConsumoAoAutomovel.getQuantAutomovel() + CreditoDeConsumoAEducaçao.getQuantEducacao());

        System.out.println();

        //e)
        float totalJuros = 0, total = 0;

        for (int i = 0; i < Array.length; i++) {
            if (Array[i] != null) {
                total += Array[i].calcularMontanteAReceberPorCadaCredito();
                totalJuros += Array[i].calcularMontanteTotalJuros();
            }
        }

        System.out.printf("Valor total recebido: %.2f€%nValor total de juros recebido: %.2f€", total, totalJuros);
        

        
    }
}
