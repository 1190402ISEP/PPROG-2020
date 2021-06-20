package model;

import exception.NumeroForaDosLimitesException;
import exception.DadosIntroduzidosInvalidosException;
import java.io.FileNotFoundException;

/**
 * Faz registo de Tarefas
 *
 * @author 1190402-1191045
 */
public class Tarefa {

    /**
     * A referência da Tarefa.
     */
    private String referencia;
    /**
     * A designação da Tarefa.
     */
    private String designacao;
    /**
     * A descrição informal da Tarefa.
     */
    private String descInformal;
    /**
     * A descrição técnica da Tarefa.
     */
    private String descTecnica;
    /**
     * A duração estimada da Tarefa.
     */
    private int duracaoEst;
    /**
     * O custo estimado da Tarefa.
     */
    private double custoEst;
    /**
     * Lista de Competências.
     */
    private ListaCompetencia listaCompetenciasTarefa;

    /**
     * Constrói uma instância de Tarefa recebendo a
     * referencia,designação,descrição informal,descrição técnica ,duração
     * estimada e custo estimado da Tarefa
     *
     * @param referencia referencia da Tarefa
     * @param designacao designação da Tarefa
     * @param descInformal descrição informal da Tarefa
     * @param descTecnica descrição técnica da Tarefa
     * @param duracaoEst duração estimada da Tarefa
     * @param custoEst custo estimado da Tarefa
     * @throws exception.NumeroForaDosLimitesException nº inserido fora dos
     * limites permitidos
     * @throws java.io.FileNotFoundException Ficheiro Não Encontrado
     */
    public Tarefa(String referencia, String designacao, String descInformal,
            String descTecnica, int duracaoEst, double custoEst) throws NumeroForaDosLimitesException, FileNotFoundException {
        setReferencia(referencia);
        setDesignacao(designacao);
        setDescInformal(descInformal);
        setDescTecnica(descTecnica);
        setDuracaoEst(duracaoEst);
        setCustoEst(custoEst);
        listaCompetenciasTarefa = new ListaCompetencia(referencia, false);
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @return the designacao
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     * @return the descInformal
     */
    public String getDescInformal() {
        return descInformal;
    }

    /**
     * @return the descTecnica
     */
    public String getDescTecnica() {
        return descTecnica;
    }

    /**
     * @return the duracaoEst
     */
    public int getDuracaoEst() {
        return duracaoEst;
    }

    /**
     * @return the custoEst
     */
    public double getCustoEst() {
        return custoEst;
    }

    /**
     * @return the listaCompetenciasTarefa
     */
    public ListaCompetencia getListaCompetenciasTarefa() {
        return listaCompetenciasTarefa;
    }

    /**
     * @param referencia the referencia to set
     */
    public final void setReferencia(String referencia) {
        if (referencia == null || referencia.trim().isEmpty()) {
            throw new IllegalArgumentException("Referência Inválida!");
        }
        this.referencia = referencia;
    }

    /**
     * @param designacao the designacao to set
     */
    public final void setDesignacao(String designacao) {
        if (designacao == null || designacao.trim().isEmpty()) {
            throw new DadosIntroduzidosInvalidosException("Descrição Técnica Inválida!");
        }
        this.designacao = designacao;

    }

    /**
     * @param descInformal the descInformal to set
     */
    public final void setDescInformal(String descInformal) {
        if (descInformal == null || descInformal.trim().isEmpty()) {
            throw new DadosIntroduzidosInvalidosException("Descrição Informal Inválida!");
        }
        this.descInformal = descInformal;

    }

    /**
     * @param descTecnica the descTecnica to set
     */
    public final void setDescTecnica(String descTecnica) {
        if (descTecnica == null || descTecnica.trim().isEmpty()) {
            throw new DadosIntroduzidosInvalidosException("Descrição Técnica Inválida!");
        }
        this.descTecnica = descTecnica;

    }

    /**
     * @param duracaoEst the duracaoEst to set
     * @throws exception.NumeroForaDosLimitesException Número inserido fora dos
     * limites permitidos
     */
    public final void setDuracaoEst(int duracaoEst) throws NumeroForaDosLimitesException {
        if (duracaoEst <= 0) {
            throw new NumeroForaDosLimitesException("Duração Estimada Inválida!");
        }
        this.duracaoEst = duracaoEst;

    }

    /**
     * @param custoEst the custoEst to set
     * @throws exception.NumeroForaDosLimitesException Número inserido fora dos
     * limites permitidos
     */
    public final void setCustoEst(double custoEst) throws NumeroForaDosLimitesException {
        if (custoEst <= 0) {
            throw new NumeroForaDosLimitesException("Custo Estimada Inválido!!");
        }
        this.custoEst = custoEst;

    }

    /**
     * @param listaCompetenciasTarefa the listaCompetenciasTarefa to set
     */
    public void setListaCompetenciasTarefa(ListaCompetencia listaCompetenciasTarefa) {
        this.listaCompetenciasTarefa = listaCompetenciasTarefa;
    }

    /**
     * Devolve a descrição textual acerca da Tarefa.
     *
     * @return informação sobre a Tarefa
     */
    @Override
    public String toString() {
        return String.format("TAREFA!!\nReferência: %s\nDescrição Informal: %s\n"
                + "Descrição Informal: %s\nDescrição Técnica: %s\n"
                + "Duração Estimada: %d\nCusto Estimado: %.2f€\nLista de Competencias:\n%s\n",
                this.referencia, this.designacao, this.descInformal,
                this.descTecnica, this.duracaoEst, this.custoEst, this.listaCompetenciasTarefa);
    }

    /**
     * Compara a Tarefa com o objeto recebido
     *
     * @param outroObjeto o objeto a comparar com a Tarefa.
     * @return true se o objeto recebido representar uma tarefa equivalente à
     * tarefa. Caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Tarefa outraTarefa = (Tarefa) outroObjeto;
        return referencia.equalsIgnoreCase(outraTarefa.referencia) && designacao.equalsIgnoreCase(outraTarefa.designacao) && descInformal.equalsIgnoreCase(outraTarefa.descInformal) && descTecnica.equalsIgnoreCase(outraTarefa.descTecnica) && duracaoEst == outraTarefa.duracaoEst && custoEst == outraTarefa.custoEst;
    }

}
