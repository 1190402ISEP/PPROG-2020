package model;

import exception.NumeroForaDosLimitesException;
import static model.LerFicheiro.lerFicheiroCompetenciasNecessariasATarefa;
import static model.LerFicheiro.lerFicheiroreconhecimentoCompetenciasFreelancer;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Permite criar listas de competências técnicas
 *
 * @author 1190402-1191045
 */
public class ListaCompetencia {

    /**
     * Lista de Competências Técnicas de competências técnicas
     */
    private List<CompTecnica> listaCompTecnica;

    /**
     *
     * @throws FileNotFoundException Ficheiro nem encontrado
     */
    public ListaCompetencia() throws FileNotFoundException {
        listaCompTecnica = new ArrayList<>();
    }

    /**
     *Cria uma lista de Competência para um Freelancer ou para uma Tarefa dependendo do valor booleano VF a receber
     * @param referencia referencia da competência Técnica
     * @param VF verdadeiro indica se a nova lista de competencias de um freelancer se falso é de uma tarefa
     * @throws FileNotFoundException Ficheiro nem encontrado
     * @throws exception.NumeroForaDosLimitesException Número Fora Dos Limites
     */
    public ListaCompetencia(String referencia, boolean VF) throws FileNotFoundException, NumeroForaDosLimitesException {
        if (VF == false) {
            listaCompTecnica = new ArrayList<>(lerFicheiroCompetenciasNecessariasATarefa(referencia));
        } else {
            listaCompTecnica = new ArrayList<>(lerFicheiroreconhecimentoCompetenciasFreelancer(referencia));
        }
    }

    /**
     * @return the listaCompTecnica
     */
    public List<CompTecnica> getListaCompTecnica() {
        return listaCompTecnica;
    }

    /**
     * @param listaCompTecnica the listaCompTecnica to set
     */
    public void setListaCompTecnica(List<CompTecnica> listaCompTecnica) {
        this.listaCompTecnica = listaCompTecnica;
    }

    /**
     * Devolve a descrição textual acerca da ListaFreelancers.
     *
     * @return informação sobre a ListaFreelancers
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (CompTecnica pos : listaCompTecnica) {
            s.append(pos);
            s.append("\n");
        }

        return s.toString().trim();
    }



}
