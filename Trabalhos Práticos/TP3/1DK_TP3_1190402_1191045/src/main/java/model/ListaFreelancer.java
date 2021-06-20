package model;

import exception.NumeroForaDosLimitesException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 1190402-1191045
 */
public class ListaFreelancer {

    /**
     * Lista de Freelancers.
     */
    private final List<Freelancer> listaFreelancers;

    /**
     * Cria uma instância de ListaTarefas.
     *
     * @throws java.io.FileNotFoundException Ficheiro não encontrado aquando da
     * leitura
     * @throws exception.NumeroForaDosLimitesException parâmetros Erro em
     * alguns parâmetros numéricos que estavam a ser lidos no ficheiro e estão
     * fora dos limites permitidos
     */
    public ListaFreelancer() throws FileNotFoundException, NumeroForaDosLimitesException {
        listaFreelancers = new ArrayList<>(LerFicheiro.lerFicheiroFreelancer());
    }

    /**
     * Retorna a lista de Freelancers.
     *
     * @return the listaFreelancers
     */
    public List<Freelancer> getListaFreelancers() {
        return listaFreelancers;
    }

    /**
     * Verifica se a lista está vazia.
     *
     * @return true se a lista está vazia e false se a lista não está vazia
     */
    public boolean listaVazia() {
        return listaFreelancers.isEmpty();
    }

    /**
     * Devolve a descrição textual acerca da ListaFreelancer.
     *
     * @return informação sobre a ListaFreelancer
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (Freelancer pos : listaFreelancers) {
            s.append(pos);
            s.append("\n");
        }
        return s.toString().trim();
    }
}
