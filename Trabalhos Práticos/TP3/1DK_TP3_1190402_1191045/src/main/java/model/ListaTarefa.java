package model;

import exception.NumeroForaDosLimitesException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Faz registo de listas de tarefas.
 *
 * @author 1190402-1191045
 */
public class ListaTarefa {

    /**
     * Lista de tarefas.
     */
    private final List<Tarefa> listaTarefas;

    /**
     * Cria uma instância de ListaTarefas.
     *
     * @throws java.io.FileNotFoundException Ficheiro não encontrado aquando da
     * leitura
     * @throws exception.NumeroForaDosLimitesException parâmetros Erro em
     * alguns parâmetros numéricos que estavam a ser lidos no ficheiro e estão
     * fora dos limites permitidos
     */
    public ListaTarefa() throws FileNotFoundException, NumeroForaDosLimitesException {
        listaTarefas = new ArrayList<>(LerFicheiro.lerFicheiroTarefas());
    }

    /**
     * Retorna a lista de tarefas.
     *
     * @return the listaTarefas
     */
    public List<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

    /**
     * Verifica se a lista está vazia.
     *
     * @return true se a lista está vazia e false se a lista não está vazia
     */
    public boolean listaVazia() {
        return listaTarefas.isEmpty();
    }

    /**
     * Devolve a descrição textual acerca da ListaTarefa.
     *
     * @return informação sobre a ListaTarefa
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (Tarefa pos : listaTarefas) {
            s.append(pos);
            s.append("\n");
        }
        return s.toString().trim();
    }
}
