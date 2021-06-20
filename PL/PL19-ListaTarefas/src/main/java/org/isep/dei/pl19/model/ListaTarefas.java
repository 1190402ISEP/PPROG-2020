package org.isep.dei.pl19.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListaTarefas {

   

    public enum ORDENACAO {
        INSERCAO, PRIORIDADE
    }

    private List<Tarefa> listaTarefas;
    
    //implementar todas as funcionalidades necessárias
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
//    public String toStringOrdemPrioridades(){
//        List<Tarefa> copia= new ArrayList<> (listaTarefas);
//        
//        Collections.sort(copia,Collections.reverseOrder());
//        StringBuilder s= new StringBuilder();
//        for (Tarefa pos : copia) {
//            s.append(pos);
//            s.append("\n");
//        }
//    
//return s.toString().trim();
//    }
//    
 
    public String toStringOrdemPrioridades(){
        List<Tarefa> copia= new ArrayList<> (listaTarefas);
        
        Collections.sort(copia,Collections.reverseOrder());
        StringBuilder s= new StringBuilder();
        for (Iterator<Tarefa> iteradorTarefa =copia.iterator();iteradorTarefa.hasNext();) {
            s.append(iteradorTarefa.next());
            s.append("\n");
        }
    
return s.toString().trim();
    }
    



    public void preencherLista(int tam){
        int numberItems=listaTarefas.size();
    }
    
    
 
    public boolean eliminarTarefa(String tarefa){
        Iterator<Tarefa> iteradorTarefa= listaTarefas.iterator();
        int i=0;
        while(iteradorTarefa.hasNext() && !iteradorTarefa.next().toString().equalsIgnoreCase(tarefa)){
        i++;
    }
        if(iteradorTarefa.hasNext()){
            return eliminarTarefa(i);
        }
        return false;
    }

}
