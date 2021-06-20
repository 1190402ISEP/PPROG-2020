package model;

import exception.DiaInvalidoException;
import exception.MesInvalidoException;
import exception.NaoEncontradoException;
import exception.NumeroForaDosLimitesException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Faz registo da lista de candidaturas.
 *
 * @author 1190402-1191045
 */
public class ListaCandidatura {

    /**
     * Lista de Candidaturas.
     */
    private final List<Candidatura> listaCandidaturas;

    /**
     * Cria uma instância de ListaCandidaturas através da leitura de um
     * ficheiro.
     *
     * @throws java.io.FileNotFoundException ficheiro não encontrado
     * @throws exception.NumeroForaDosLimitesException números associados a
     * alguns parâmetros no processo de leitura são inválidos
     * @throws exception.MesInvalidoException Mes inserido inválido
     * @throws exception.DiaInvalidoException Dia inserido inválido
     */
    public ListaCandidatura() throws FileNotFoundException, NumeroForaDosLimitesException, MesInvalidoException, DiaInvalidoException {
        listaCandidaturas = new ArrayList<>(LerFicheiro.lerFicheiroCandidaturas());
    }

    /**
     * @return the listaCandidaturas
     */
    public List<Candidatura> getCandidaturas() {
        return listaCandidaturas;
    }

    /**
     * Procura-se a candidatura com a referencia indicada comparando com todas
     * as candidaturas presentes na lista e retorna a lista de candidatura
     * referente a essa mesma referencia e com as competências necessárias para
     * a tarefa.
     *
     * @param tarefa tarefa a partir da qual se vai procurar a candidatura
     * @return listaAux com a referencia passada por parâmetro
     * @throws exception.NaoEncontradoException nenhuma candidatura à tarefa
     */
    public List<Candidatura> getCandidatura(Tarefa tarefa) throws NaoEncontradoException {
        List<Candidatura> listaAux = new ArrayList<>();
        listaAux.clear();
        List<Candidatura> listaAux2 = new ArrayList<>();
        listaAux2.clear();
        int verificador = 0;

        for (int i = 0; i < listaCandidaturas.size(); i++) {
            Candidatura cand = listaCandidaturas.get(i);
            if (cand.getRefTarefa().equals(tarefa)) {
                listaAux.add(cand);
            }
        }

        if (listaAux.isEmpty()) {
            throw new NaoEncontradoException("Não foi encontrada nenhuma candidatura referente à tarefa " + tarefa.toString());
        }

        for (int i = 0; i < listaAux.size(); i++) {
            Candidatura cand = listaAux.get(i);
            for (int j = 0; j < cand.getNIFFreelancer().getReconhecimentosDeCompetencias().getListaCompTecnica().size(); j++) {
                for (int k = 0; k < tarefa.getListaCompetenciasTarefa().getListaCompTecnica().size(); k++) {
                    if (cand.getNIFFreelancer().getReconhecimentosDeCompetencias().getListaCompTecnica().get(j).getDescricao().equals(tarefa.getListaCompetenciasTarefa().getListaCompTecnica().get(k).getDescricao())) {
                        if (cand.getNIFFreelancer().getReconhecimentosDeCompetencias().getListaCompTecnica().get(j).getGrauDeProficiencia().ordinal() >= tarefa.getListaCompetenciasTarefa().getListaCompTecnica().get(k).getGrauDeProficiencia().ordinal()) {
                            k = tarefa.getListaCompetenciasTarefa().getListaCompTecnica().size();
                            verificador += 1;
                        }
                    }
                }
                if (verificador == tarefa.getListaCompetenciasTarefa().getListaCompTecnica().size()) {
                    if (!listaAux2.contains(cand)){
                        listaAux2.add(cand);
                    }       
                }
            }
            verificador = 0;
        }

        if (listaAux2.isEmpty()) {
            throw new NaoEncontradoException("Nenhuma candidatura com os requisitos mínimos!");
        }

        return listaAux2;
    }

    /**
     * Devolve a descrição textual acerca da ListaCandidatura.
     *
     * @return informação sobre a ListaCandidatura
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (Candidatura pos : listaCandidaturas) {
            s.append(pos);
            s.append("\n");
        }
        return s.toString().trim();
    }

}
