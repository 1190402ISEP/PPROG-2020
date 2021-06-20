package Olxyz;

/**
 *
 * @author 1DK_1190402_1191045
 */
public class Olxyz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Anunciante[] anunciantes = new Anunciante[5];

        Anunciante a1 = new Anunciante("Rui", "Rua", "4500-123", "Sra. da Hora");
        a1.introduzirVendavelTelemovel("Samsung", 10);
        a1.introduzirAlugavelApartamento("Rua1", "4123-436", "Ah", 120, 400);
        a1.introduzirAlugavelAutomovel("Lamborghini", "Diablo", 0, 5000000);

        anunciantes[0] = a1;

        Anunciante a2 = new Anunciante("Antonio", "Rua2", "6987-521", "Porto");
        a2.introduzirVendavelTelemovel("IPhone", 20);
        a2.introduzirVendavelAutomovel("Ferrari", "F50", 3000000, 0);
        a2.introduzirAlugavelApartamento("Rua3", "1", "China", 500, 500);

        anunciantes[1] = a2;

        Anunciante a3 = new Anunciante("Eminem", "Rua4", "6", "Matosos");
        a3.introduzirAlugavelApartamento("Rua5", "99", "Lapra", 5000, 50);
        a3.introduzirAlugavelApartamento("Rua6", "12", "Larpa", 50, 5000);

        anunciantes[2] = a3;

        int totalAluguer = 0;

        for (int i = 0; i < anunciantes.length; i++) {
            if (anunciantes[i] != null) {
                totalAluguer += anunciantes[i].quantidadeProdutos();
            }
        }

        System.out.printf("Existem %d artigos disponíveis para aluguer na plataforma Olxyz.\n", totalAluguer);
        System.out.println();

        for (int i = 0; i < anunciantes.length; i++) {
            if (anunciantes[i] != null) {
                float aux = anunciantes[i].totalPossivelVendas();
                if (aux != 0) {
                    System.out.printf("%sSomatório das possíveis vendas: %.2f\n\n", anunciantes[i], aux);
                }
            }
        }

        System.out.println("");

        for (int i = 0; i < anunciantes.length; i++) {
            if (anunciantes[i] != null && anunciantes[i].getAluguer().size() != 0) {

                if (anunciantes[i].valorMaior() instanceof Automovel) {
                    System.out.printf("ANUNCIANTE\nNome: %s\n%s\n", anunciantes[i].getNome(), ((Automovel) anunciantes[i].valorMaior()).toStringAluguer());
                }

                if (anunciantes[i].valorMaior() instanceof Apartamento) {
                    System.out.printf("ANUNCIANTE\nNome: %s\n%s\n", anunciantes[i].getNome(), ((Apartamento) anunciantes[i].valorMaior()));
                }
            }
        }
    }
}
