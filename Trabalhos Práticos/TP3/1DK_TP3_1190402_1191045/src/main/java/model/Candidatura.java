package model;

import exception.NumeroForaDosLimitesException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Faz registo de Candidatura
 *
 * @author 1190402-1191045
 */
public final class Candidatura {

    /**
     * A data da Candidatura.
     */
    private Data dataCandidatura;
    /**
     * O valor pretendido da Candidatura.
     */
    private double valorPretendido;
    /**
     * O nº de dias apresentado na Candidatura.
     */
    private int nrDias;
    /**
     * O texto de apresentação na Candidatura.
     */
    private String txtApresentacao;
    /**
     * O texto de motivação na Candidatura.
     */
    private String txtMotivacao;
    /**
     * A referência relativa à tarefa da Candidatura.
     */
    private Tarefa refTarefa;
    /**
     * O NIF relativo ao Freelancer da Candidatura.
     */
    private Freelancer NIFFreelancer;

    /**
     * Constrói uma instância de Candidatura recebendo a data da candidatura, o
     * valor pretendido, nº de dias, texto de apresentação, texto de motivação,
     * a tarefa associada ao mesmo e o freelancer associado.
     *
     * @param data data da candidatura
     * @param valorPretendido valor pretendido pela realização da tarefa
     * @param nrDias nº de dias para realizar a tarefa
     * @param txtApresentacao texto de apresentação
     * @param txtMotivacao texto de motivação
     * @param refTarefa referência da tarefa
     * @param NIFFreelancer nif do Freelancer
     * @throws exception.NumeroForaDosLimitesException Número inserido fora dos
     * limites permitidos
     * @throws java.io.FileNotFoundException Ficheiro Não Encontrado
     */
    public Candidatura(Data data, double valorPretendido, int nrDias, String txtApresentacao,
            String txtMotivacao, String refTarefa, String NIFFreelancer)
            throws NumeroForaDosLimitesException, FileNotFoundException {
        setDataCandidatura(data);
        setValorPretendido(valorPretendido);
        setNrDias(nrDias);
        setTxtApresentacao(txtApresentacao);
        setTxtMotivacao(txtMotivacao);
        setRefTarefa(refTarefa);
        setNIFFreelancer(NIFFreelancer);
    }

    /**
     * Constrói uma instância de Candidatura recebendo outra candidatura.
     *
     * @param cand candidatura a copiar
     */
    public Candidatura(Candidatura cand) {
        this.dataCandidatura = cand.dataCandidatura;
        this.valorPretendido = cand.valorPretendido;
        this.nrDias = cand.nrDias;
        this.txtApresentacao = cand.txtApresentacao;
        this.txtMotivacao = cand.txtMotivacao;
        this.refTarefa = cand.refTarefa;
        this.NIFFreelancer = cand.NIFFreelancer;
    }

    /**
     * @return the dataCandidatura
     */
    public Data getDataCandidatura() {
        return dataCandidatura;
    }

    /**
     * @return the valorPretendido
     */
    public double getValorPretendido() {
        return valorPretendido;
    }

    /**
     * @return the nrDias
     */
    public int getNrDias() {
        return nrDias;
    }

    /**
     * @return the txtApresentacao
     */
    public String getTxtApresentacao() {
        return txtApresentacao;
    }

    /**
     * @return the txtMotivacao
     */
    public String getTxtMotivacao() {
        return txtMotivacao;
    }

    /**
     * @return the refTarefa
     */
    public Tarefa getRefTarefa() {
        return refTarefa;
    }

    /**
     * @return the NIFFreelancer
     */
    public Freelancer getNIFFreelancer() {
        return NIFFreelancer;
    }

    /**
     * @param dataCandidatura the dataCandidatura to set
     */
    public void setDataCandidatura(Data dataCandidatura) {
        this.dataCandidatura = dataCandidatura;
    }

    /**
     * @param valorPretendido the valorPretendido to set
     * @throws exception.NumeroForaDosLimitesException valor pretendido fora
     * dos limites permitidos
     */
    public final void setValorPretendido(double valorPretendido) throws NumeroForaDosLimitesException {
        if (valorPretendido <= 0) {
            throw new NumeroForaDosLimitesException("Valor Pretendido Inválido!");
        }
        this.valorPretendido = valorPretendido;
    }

    /**
     * @param nrDias the nrDias to set
     * @throws exception.NumeroForaDosLimitesException Nº de dias fora dos
     * limites permitidos
     */
    public final void setNrDias(int nrDias) throws NumeroForaDosLimitesException {
        if (nrDias <= 0) {
            throw new NumeroForaDosLimitesException("Nº de Dias Inválido!");
        }
        this.nrDias = nrDias;
    }

    /**
     * @param txtApresentacao the txtApresentacao to set
     */
    public final void setTxtApresentacao(String txtApresentacao) {
        if (txtApresentacao == null || txtApresentacao.trim().isEmpty()) {
            throw new IllegalArgumentException("Texto de Apresentação Inválido!");
        }
        this.txtApresentacao = txtApresentacao;
    }

    /**
     * @param txtMotivacao the txtMotivacao to set
     */
    public final void setTxtMotivacao(String txtMotivacao) {
        if (txtMotivacao == null || txtMotivacao.trim().isEmpty()) {
            throw new IllegalArgumentException("Texto de Motivação Inválido!");
        }
        this.txtMotivacao = txtMotivacao;
    }

    /**
     *
     * @param refTarefa the refTarefa to set
     * @throws java.io.FileNotFoundException Ficheiro Não Encontrado
     * @throws exception.NumeroForaDosLimitesException Nº Fora Dos Limites
     * Permitidos
     */
    public final void setRefTarefa(String refTarefa) throws FileNotFoundException, NumeroForaDosLimitesException {
        boolean VF = true;//Continua true se não for encontrada uma tarefa com a referencia passada como parâmetro.
        ListaTarefa listaTarefas = new ListaTarefa();

        for (int i = 0; i < listaTarefas.getListaTarefas().size(); i++) {
            Tarefa tar = listaTarefas.getListaTarefas().get(i);
            if (tar.getReferencia().equals(refTarefa)) {
                this.refTarefa = tar;
                VF = false;
            }
        }

        if (VF == true) {
            throw new IllegalArgumentException("Texto de Referencia Inválida!");
        }
    }

    /**
     *
     * @param NIFFreelancer the NIFFreelancer to set
     * @throws java.io.FileNotFoundException Ficheiro Não Encontrado
     * @throws exception.NumeroForaDosLimitesException Número Fora Dos Limites
     * Permitidos
     */
    public final void setNIFFreelancer(String NIFFreelancer) throws FileNotFoundException, NumeroForaDosLimitesException {
        boolean VF = true;//Continua true se não for encontrado um freelancer com o NIF passado como parâmetro.
        ListaFreelancer listaFreelancers = new ListaFreelancer();

        for (int i = 0; i < listaFreelancers.getListaFreelancers().size(); i++) {
            Freelancer free = listaFreelancers.getListaFreelancers().get(i);
            if (free.getNIF().equals(NIFFreelancer)) {
                this.NIFFreelancer = free;
                VF = false;
            }
        }

        if (VF == true) {
            throw new IllegalArgumentException("Freelancer Não Encontrado!");
        }
    }

    /**
     * Devolve a descrição textual acerca a Candidatura.
     *
     * @return informação sobre a Candidatura
     */
    @Override
    public String toString() {
        return String.format("CANDIDATURA!!\nData: %s\nValor Pretendido: %.2f€\n"
                + "Número de Dias: %d\nTexto de Apresentação: %s\nTexto de "
                + "Motivação: %s\n\nFreelancer: %s\n"
                + "---------------------------------------------------------\n",
                this.dataCandidatura, this.valorPretendido, this.nrDias,
                this.txtApresentacao, this.txtMotivacao, this.NIFFreelancer);
    }

    /**
     * Compara a Candidatura com o objeto recebido.
     *
     * @param outroObjeto o objeto a comparar com a Candidatura.
     * @return true se o objeto recebido representar uma Candidatura equivalente
     * à candidatura. Caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Candidatura outraCandidatura = (Candidatura) outroObjeto;
        return this.dataCandidatura.equals(outraCandidatura.dataCandidatura) && this.valorPretendido == outraCandidatura.valorPretendido && this.nrDias == outraCandidatura.nrDias && this.txtApresentacao.equalsIgnoreCase(outraCandidatura.txtApresentacao) && this.txtMotivacao.equalsIgnoreCase(outraCandidatura.txtMotivacao);
    }

    /**
     * @return valor da media dos graus de proficiência das competências
     * exigidas para a tarefa
     */
    public double doMedia() {
        double soma = 0;

        for (int j = 0; j < NIFFreelancer.getReconhecimentosDeCompetencias().getListaCompTecnica().size(); j++) {
            for (int k = 0; k < refTarefa.getListaCompetenciasTarefa().getListaCompTecnica().size(); k++) {
                if (NIFFreelancer.getReconhecimentosDeCompetencias().getListaCompTecnica().get(j).getDescricao().equals(refTarefa.getListaCompetenciasTarefa().getListaCompTecnica().get(k).getDescricao())) {
                    soma += NIFFreelancer.getReconhecimentosDeCompetencias().getListaCompTecnica().get(j).getGrauDeProficiencia().ordinal() + 1;
                }
            }
        }

        return (soma / refTarefa.getListaCompetenciasTarefa().getListaCompTecnica().size());
    }

    /**
     * @return valor do desvio padrão dos graus de proficiência das competências
     * exigidas para a tarefa
     */
    public double doDesvioPadrao() {
        double numerador = 0;
        double media = doMedia();
        List<CompTecnica> temp = new ArrayList<>();
        for (int j = 0; j < NIFFreelancer.getReconhecimentosDeCompetencias().getListaCompTecnica().size(); j++) {
            for (int k = 0; k < refTarefa.getListaCompetenciasTarefa().getListaCompTecnica().size(); k++) {
                if (NIFFreelancer.getReconhecimentosDeCompetencias().getListaCompTecnica().get(j).getDescricao().equals(refTarefa.getListaCompetenciasTarefa().getListaCompTecnica().get(k).getDescricao())) {
                    temp.add(NIFFreelancer.getReconhecimentosDeCompetencias().getListaCompTecnica().get(j));
                }
            }
        }

        int total = temp.size();
        for (CompTecnica pos : temp) {
            int x = pos.getGrauDeProficiencia().ordinal() + 1;
            numerador = numerador + (Math.pow((x - media), 2));
        }

        return Math.sqrt((numerador / total));
    }
}
