package controller;

import exception.DiaInvalidoException;
import exception.MesInvalidoException;
import exception.NaoEncontradoException;
import exception.NumeroForaDosLimitesException;
import model.ListaCandidatura;
import model.ListaTarefa;
import model.Candidatura;
import model.ProcessoSeriacao;
import model.Processo;
import model.Tarefa;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Controlador da aplicação (cria objetos de SeriarAnuncioController).
 *
 * @author 1190402-1191045
 */
public class SeriarAnuncioController {

    /**
     * Lista de Tarefas.
     */
    private static ListaTarefa listaTarefas;
    /**
     * Lista de Candidaturas.
     */
    private static ListaCandidatura listaCandidaturas;
    /**
     * Processo de Seriação.
     */
    private static ProcessoSeriacao processoSeriacao;

    /**
     * Inicializa as listas de tarefas e candidaturas.
     *
     * @throws FileNotFoundException ficheiro não encontrado
     * @throws NumeroForaDosLimitesException nº fora dos limites permitidos
     * @throws exception.MesInvalidoException Mes inserido inválido
     * @throws exception.DiaInvalidoException Dia inserido inválido
     */
    public SeriarAnuncioController() throws FileNotFoundException, NumeroForaDosLimitesException, MesInvalidoException, DiaInvalidoException {
        listaTarefas = new ListaTarefa();
        listaCandidaturas = new ListaCandidatura();
        processoSeriacao = new ProcessoSeriacao();
    }

    /**
     * Get da lista de tarefas.
     *
     * @return lista de tarefas
     */
    public List<Tarefa> getListaTarefas() {
        return listaTarefas.getListaTarefas();
    }

    /**
     * Get da lista de candidaturas referentes a uma tarefa através da
     * referência da tarefa.
     *
     * @param tarefa tarefa para a qual se faz o get das candidaturas
     * @return lista das candidaturas à tarefa em que a referência foi recebida
     * por parâmetro
     * @throws NaoEncontradoException Nenhuma candidatura referente à tarefa
     */
    public List<Candidatura> getListaCandidaturas(Tarefa tarefa) throws NaoEncontradoException {
        return listaCandidaturas.getCandidatura(tarefa);
    }

    /**
     * Iniciar o processo de Seriação 1.
     *
     * @param lista lista de candidaturas da tarefa
     * @return resultado do processo de seriação 1
     */
    public String despoletarProcessoDeSeriacao1(List<Candidatura> lista) {
        return processoSeriacao.ProcessoSeriacao1(lista);
    }

    /**
     * Iniciar o processo de Seriação 2.
     *
     * @param lista lista de candidaturas da tarefa
     * @return resultado do processo de seriação 2
     */
    public String despoletarProcessoDeSeriacao2(List<Candidatura> lista) {
        return processoSeriacao.ProcessoSeriacao2(lista);
    }

    /**
     * Verifica se a lista está vazia.
     *
     * @return true se está vazia e false se não está vazia
     */
    public boolean listaVazia() {
        return listaTarefas.listaVazia();
    }

    /**
     * Get dos Tipos Processo Disponíveis.
     *
     * @return todos os processos disponíveis
     */
    public Processo[] getProcessos() {
        return Processo.values();
    }
}
