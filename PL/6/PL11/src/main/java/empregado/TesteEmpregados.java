package empregado;

import Utilitarios.Data;
import Utilitarios.Tempo;
import java.util.ArrayList;
import java.util.List;

public class TesteEmpregados {

    public static void main(String[] args) {

        Data data = Data.dataAtual();
        System.out.printf(""
                + "### Data ###%n"
                + "%s%n", data);

        Tempo t1 = new Tempo(14, 0);
        Tempo t2 = new Tempo(19, 30);
        System.out.printf("%n"
                + "### Tempos ###%n"
                + "%s%n"
                + "%s%n", t1, t2);
        
        System.out.println();
        System.out.println("### Empregados iniciais ###");
        Empregado e1 = new Empregado("Manuel", "Silva", data, t1, t2);
        Empregado e2 = new Empregado("Miguel", "Ferreira", data, t1, t2);
        
        System.out.println(e1.toString());
        System.out.println(e2.toString());

        System.out.println();
        System.out.println("### Verificação de referências não partilhadas nos "
                + "atributos do tipo Data e do tipo Tempo ###");
        
        System.out.println();
        e1.setDataContrato(2015, 1, 1);
        System.out.println(e1.toString());
        System.out.println(e2.toString());
        
        System.out.println();
        e1.setHoraEntrada(new Tempo(13, 00));
        System.out.println(e1.toString());
        System.out.println(e2.toString());
        
        System.out.println();
        e1.setHoraSaida(new Tempo(18, 30));
        System.out.println(e1.toString());
        System.out.println(e2.toString());
        
        System.out.println();
        data.setData(2015, 9, 11);
        System.out.println("Data data = " + data.toAnoMesDiaString());
        t1.setTempo(17, 0, 0);
        System.out.println("Tempo t1 = " + t1.toStringHHMMSS());
        t2.setTempo(23, 0, 0);
        System.out.println("Tempo t2 = " + t2.toStringHHMMSS());
        
        System.out.println();
        System.out.println(e1.toString());
        System.out.println(e2.toString());
        
        e2.setDataContrato(new Data(2000, 1, 1));
        e2.setHoraEntrada(new Tempo(8, 0));
        e2.setHoraSaida(new Tempo(12, 0));
        
        List<Empregado> empregados= new ArrayList<>();
        empregados.add(e1);
        empregados.add(e2);

        System.out.println("\n### Lista de Empregados ###");
        for (Empregado empregado : empregados) {
            if (empregado != null) {
                System.out.println(empregado.toString());
            }
        }

        System.out.println("\n### Info de Empregados ###");
        for (Empregado empregado : empregados) {
            if (empregado != null) {
                System.out.printf("%s %s, trabalha %d horas por semana e está na empresa à %d dias.%n",
                        empregado.getPrimeiroNome(),
                        empregado.getUltimoNome(),
                        empregado.determinarHorasTrabalho(),
                        empregado.determinarTempoEmpregado());
            }
        }
    }

}