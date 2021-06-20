package org.isep.dei.pl19.controller;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.isep.dei.pl19.model.FicheiroListaTarefas;
import org.isep.dei.pl19.model.ListaTarefas;
import org.isep.dei.pl19.model.Prioridade;
import org.isep.dei.pl19.model.Tarefa;

public class AplicacaoController {

    private ListaTarefas lista;
    private FicheiroListaTarefas ficheiroListaTarefas;

    //inicia atributos
    public AplicacaoController() {
        lista = new ListaTarefas();
        ficheiroListaTarefas = new FicheiroListaTarefas();
    }

    //adiciona uma nova tarefa na lista
    public boolean adicionarTarefa(String descricao, Prioridade prioridade) {
        return lista.adicionarTarefa(descricao, prioridade);
    }

    //elimina de lista todas as tarefas
    public void eliminarTarefas() {
        lista.eliminarTarefas();
    }

    //elimina apenas a última tarefa inserida na lista
    public boolean eliminarUltimaTarefa() {
        return lista.eliminarTarefa(lista.tamanho() - 1);
    }

    //verifica se lista está ou não vazia
    public boolean listaVazia() {
        return lista.estaVazia();
    }

    //retorna os elementos da lista, por ordem de inserção
    public String getListaTarefas() {
        return lista.toString();
    }

    //retorna os elementos da lista, por decrescente de prioridade
    public String getListaTarefasPorPrioridade() {
        return lista.toStringOrdemPrioridades();
    }

    //retorna um array com todos os valores de Prioridade
    public Prioridade[] getPrioridades() {
        return Prioridade.values();
    }

    public void preencher() {
        final int limSuperior = 15;
        lista.preencherLista((new Random()).nextInt(limSuperior) + 1);
    }

    public boolean guardarFicheiroTexto() {
        return ficheiroListaTarefas.guardarFicheiroTexto(lista);
    }

    public boolean guardarFicheiroBinario() {
        return ficheiroListaTarefas.guardarFicheiroBinario(lista);
    }
    public List<String> getArrayListTarefasPorPrioridade(){
        return Arrays.asList(lista.toStringOrdemPrioridades().split("\n"));
    }
    public List<String> getArrayListTarefas(){
        //Array para Lista
        return Arrays.asList(lista.toString().split("\n"));
    }
    
    
    
}
