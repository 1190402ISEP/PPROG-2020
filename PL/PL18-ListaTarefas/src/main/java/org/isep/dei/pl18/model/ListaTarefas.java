package org.isep.dei.pl18.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.isep.dei.pl18.model.Tarefa;

public class ListaTarefas {

    public enum ORDENACAO {
        INSERCAO, PRIORIDADE
    }

    private List<Tarefa> listaTarefas;

    //implementar todas as funcionalidades necessárias
    public ListaTarefas() {
        listaTarefas = new ArrayList<>();
    }

    public boolean adicionarTarefa(String descricao, Prioridade prioridade) {
        Tarefa tarefa = new Tarefa(descricao, prioridade);
        return getListaTarefas().contains(tarefa) ? false : getListaTarefas().add(tarefa);
    }

    public boolean eliminarTarefa(int i) {
        return getListaTarefas().remove(getListaTarefas().get(i));

    }

    public void eliminarTarefas() {
        getListaTarefas().clear();
    }

    public boolean estaVazia() {
        return getListaTarefas().isEmpty();
    }

    public int tamanho() {
        return getListaTarefas().size();
    }

    /**
     * @return the listaTarefas
     */
    public List<Tarefa> getListaTarefas() {
        return listaTarefas;
    }
public String toString(){
    StringBuilder s= new StringBuilder();
    
    for (Tarefa pos: listaTarefas) {
        s.append(pos);
    s.append("\n");
       
    }
    return s.toString().trim();
}
    public String toStringOrdemPrioridades(){
        List<Tarefa> copia= new ArrayList<> (listaTarefas);
        
        Collections.sort(copia,Collections.reverseOrder());
        StringBuilder s= new StringBuilder();
        for (Tarefa pos : copia) {
            s.append(pos);
            s.append("\n");
        }
    
return s.toString().trim();
    }
    
    
    public void preencherLista(int tam){
        int numberItems=listaTarefas.size();
    }
    
    
 
    
    
    
    
    
    
}
