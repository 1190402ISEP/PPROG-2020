package model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Despoleta os processos de seriação
 *
 * @author 1190402-1191045
 */
public class ProcessoSeriacao {

    /**
     * Despoleta o processo de seriação 1
     *
     * @param listaCandidaturas para o processo de seriação
     * @return resultado da seriação
     */
    public String ProcessoSeriacao1(List<Candidatura> listaCandidaturas) {
        Collections.sort(listaCandidaturas, processo1);

        return listaCandidaturas.toString();
    }

    /**
     * Despoleta o processo de seriação 2
     *
     * @param listaCandidaturas para o processo de seriação
     * @return resultado da seriação
     */
    public String ProcessoSeriacao2(List<Candidatura> listaCandidaturas) {
        Collections.sort(listaCandidaturas, processo2);

        return listaCandidaturas.toString();
    }
    /**
     * Faz-se a seriação 1: primeiramente ordena-se a lista por ordem
     * descrescente de valores de média dos graus de proficiência, o que estiver
     * em primeiro lugar é o que tem maior média caso haja candidaturas em que a
     * média seja igual passa a ser verificado qual a candidatura com preço mais
     * baixo e posteriormente caso haja candidaturas com o mesmo preço
     * verifica-se qual foi publicada mais cedo.
     */
    Comparator<Candidatura> processo1 = new Comparator<Candidatura>() {

        @Override
        public int compare(Candidatura cand1, Candidatura cand2) {
            if (cand1.doMedia() > cand2.doMedia()) {
                return -1;
            } else if (cand1.doMedia() < cand2.doMedia()) {
                return 1;
            } else {
                if (cand1.getValorPretendido() < cand2.getValorPretendido()) {
                    return -1;
                } else if (cand1.getValorPretendido() > cand2.getValorPretendido()) {
                    return 1;
                } else {
                    if (cand1.getDataCandidatura().isMaior(cand2.getDataCandidatura())) {
                        return -1;
                    } else if (cand2.getDataCandidatura().isMaior(cand1.getDataCandidatura())) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        }
    };

    /**
     * Faz-se a seriação 2: primeiramente ordena-se a lista por ordem
     * descrescente de valores de média dos graus de proficiência, o que estiver
     * em primeiro lugar é o que tem maior média caso haja candidaturas em que a
     * média seja igual passa a ser verificado qual destes tem um menor desvio
     * padrão dos níveis de proficiência exigidos para a tarefa caso estes sejam
     * iguais verifica-se qual a candidatura com preço mais baixo e
     * posteriormente caso haja candidaturas com o mesmo preço verifica-se qual
     * foi publicada mais cedo.
     */
    Comparator<Candidatura> processo2 = new Comparator<Candidatura>() {

        @Override
        public int compare(Candidatura cand1, Candidatura cand2) {
            if (cand1.doMedia() > cand2.doMedia()) {
                return -1;
            } else if (cand1.doMedia() < cand2.doMedia()) {
                return 1;
            } else {
                if (cand1.doDesvioPadrao() < cand2.doDesvioPadrao()) {
                    return -1;
                } else if (cand1.doDesvioPadrao() > cand2.doDesvioPadrao()) {
                    return 1;
                } else {
                    if (cand1.getValorPretendido() < cand2.getValorPretendido()) {
                        return -1;
                    } else if (cand1.getValorPretendido() > cand2.getValorPretendido()) {
                        return 1;
                    } else {
                        if (cand1.getDataCandidatura().isMaior(cand2.getDataCandidatura())) {
                            return -1;
                        } else if (cand2.getDataCandidatura().isMaior(cand1.getDataCandidatura())) {
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                }
            }
        }
    };
}
