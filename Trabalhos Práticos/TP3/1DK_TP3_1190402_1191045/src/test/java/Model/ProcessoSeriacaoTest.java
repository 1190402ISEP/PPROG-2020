/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import model.Freelancer;
import model.ListaCandidatura;
import model.Tarefa;
import model.ListaTarefa;
import model.ProcessoSeriacao;
import model.CompTecnica;
import model.GrauProficiencia;
import model.ListaFreelancer;
import model.Candidatura;
import model.Data;
import exception.DiaInvalidoException;
import exception.MesInvalidoException;
import exception.NumeroForaDosLimitesException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 1190402-1191045
 */
public class ProcessoSeriacaoTest {

    public ProcessoSeriacaoTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of ProcessoSeriacao1 method, of class ProcessoSeriacao.
     *
     * @throws java.io.FileNotFoundException Ficheiro Não Encontrado
     * @throws exception.NumeroForaDosLimitesException Número Fora Dos Limites
     * @throws exception.MesInvalidoException Mês Inválido
     * @throws exception.DiaInvalidoException Dia Inválido
     */
    @org.junit.jupiter.api.Test
    public void testProcessoSeriacao1MediaMaior() throws FileNotFoundException, NumeroForaDosLimitesException, MesInvalidoException, DiaInvalidoException {
        System.out.println("MediaMaior");
        
        ListaTarefa listaTarefas = new ListaTarefa();
        listaTarefas.getListaTarefas().clear();
        Tarefa tp1 = new Tarefa("TP3", "Trabalho 3", "Outro Trabalho", "Trabalha Mais", 54, 4);
        listaTarefas.getListaTarefas().add(tp1);

        ListaFreelancer listaFreelancers = new ListaFreelancer();
        listaFreelancers.getListaFreelancers().clear();
        Freelancer freel1 = new Freelancer("Diogo", "2305", "960000000", "diogo@gmail.com");
        Freelancer freel2 = new Freelancer("Rui", "1404", "960000000", "rui@gmail.com");
        listaFreelancers.getListaFreelancers().add(freel1);
        listaFreelancers.getListaFreelancers().add(freel2);
        
        Data data1 = new Data(2000, 11, 3);
        Data data2 = new Data(2000, 11, 3);
        
        List<CompTecnica> listaFreelancer1 = new ArrayList<>();
        listaFreelancer1.clear();
        CompTecnica cpt1 = new CompTecnica("1", "Programar em Java", GrauProficiencia.EXCELENTE);
        CompTecnica cpt2 = new CompTecnica("2", "Programar em Html", GrauProficiencia.MUITO_SATISFATORIO);
        listaFreelancer1.add(cpt1);
        listaFreelancer1.add(cpt2);
        
        List<CompTecnica> listaFreelancer2 = new ArrayList<>();
        listaFreelancer2.clear();
        CompTecnica cpt3 = new CompTecnica("1", "Programar em Java", GrauProficiencia.EXCELENTE);
        CompTecnica cpt4 = new CompTecnica("2", "Programar em Html", GrauProficiencia.EXCELENTE);
        listaFreelancer2.add(cpt3);
        listaFreelancer2.add(cpt4);
        
        List<CompTecnica> listaTarefa1 = new ArrayList<>();
        listaTarefa1.clear();
        CompTecnica cpt5 = new CompTecnica("1", "Programar em Java", GrauProficiencia.NADA_SATISFATORIO);
        CompTecnica cpt6 = new CompTecnica("2", "Programar em Html", GrauProficiencia.NADA_SATISFATORIO);
        listaTarefa1.add(cpt5);
        listaTarefa1.add(cpt6);
        
        tp1.getListaCompetenciasTarefa().getListaCompTecnica().clear();
        tp1.getListaCompetenciasTarefa().setListaCompTecnica(listaTarefa1);
        freel1.getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        freel1.getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer1);
        freel2.getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        freel2.getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer2);
        
        ListaCandidatura listaCandidaturas = new ListaCandidatura();
        listaCandidaturas.getCandidaturas().clear();
        Candidatura cand1 = new Candidatura(data1, 100, 10, "TextoApr", "txtMot", "TP3", "2305");
        Candidatura cand2 = new Candidatura(data2, 100, 10, "TextoApr", "txtMot", "TP3", "1404");
        cand1.getNIFFreelancer().getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        cand1.getNIFFreelancer().getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer1);
        cand1.getRefTarefa().getListaCompetenciasTarefa().getListaCompTecnica().clear();
        cand1.getRefTarefa().getListaCompetenciasTarefa().setListaCompTecnica(listaTarefa1);
        cand2.getNIFFreelancer().getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        cand2.getNIFFreelancer().getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer2);
        cand2.getRefTarefa().getListaCompetenciasTarefa().getListaCompTecnica().clear();
        cand2.getRefTarefa().getListaCompetenciasTarefa().setListaCompTecnica(listaTarefa1);
                
        listaCandidaturas.getCandidaturas().add(cand1);
        listaCandidaturas.getCandidaturas().add(cand2);
                
        List<Candidatura> listaCandidaturaPosSeriacao = new ArrayList<>();
        listaCandidaturaPosSeriacao.clear();
        listaCandidaturaPosSeriacao.add(cand2);
        listaCandidaturaPosSeriacao.add(cand1);
        
        ProcessoSeriacao ps = new ProcessoSeriacao();
        String result = ps.ProcessoSeriacao1(listaCandidaturas.getCandidaturas());
        
        String expResult = listaCandidaturaPosSeriacao.toString();
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of ProcessoSeriacao1 method, of class ProcessoSeriacao.
     *
     * @throws java.io.FileNotFoundException Ficheiro Não Encontrado
     * @throws exception.NumeroForaDosLimitesException Número Fora Dos Limites
     * @throws exception.MesInvalidoException Mês Inválido
     * @throws exception.DiaInvalidoException Dia Inválido
     */
    @org.junit.jupiter.api.Test
    public void testProcessoSeriacao1PreçoMaisBaixo() throws FileNotFoundException, NumeroForaDosLimitesException, MesInvalidoException, DiaInvalidoException {
        System.out.println("PreçoMaisBaixo");
        
        ListaTarefa listaTarefas = new ListaTarefa();
        listaTarefas.getListaTarefas().clear();
        Tarefa tp1 = new Tarefa("TP3", "Trabalho 3", "Outro Trabalho", "Trabalha Mais", 54, 4);
        listaTarefas.getListaTarefas().add(tp1);

        ListaFreelancer listaFreelancers = new ListaFreelancer();
        listaFreelancers.getListaFreelancers().clear();
        Freelancer freel1 = new Freelancer("Diogo", "2305", "960000000", "diogo@gmail.com");
        Freelancer freel2 = new Freelancer("Rui", "1404", "960000000", "rui@gmail.com");
        listaFreelancers.getListaFreelancers().add(freel1);
        listaFreelancers.getListaFreelancers().add(freel2);
        
        Data data1 = new Data(2000, 11, 3);
        Data data2 = new Data(2000, 11, 3);
        
        List<CompTecnica> listaFreelancer1 = new ArrayList<>();
        listaFreelancer1.clear();
        CompTecnica cpt1 = new CompTecnica("1", "Programar em Java", GrauProficiencia.EXCELENTE);
        CompTecnica cpt2 = new CompTecnica("2", "Programar em Html", GrauProficiencia.EXCELENTE);
        listaFreelancer1.add(cpt1);
        listaFreelancer1.add(cpt2);
        
        List<CompTecnica> listaFreelancer2 = new ArrayList<>();
        listaFreelancer2.clear();
        CompTecnica cpt3 = new CompTecnica("1", "Programar em Java", GrauProficiencia.EXCELENTE);
        CompTecnica cpt4 = new CompTecnica("2", "Programar em Html", GrauProficiencia.EXCELENTE);
        listaFreelancer2.add(cpt3);
        listaFreelancer2.add(cpt4);
        
        List<CompTecnica> listaTarefa1 = new ArrayList<>();
        listaTarefa1.clear();
        CompTecnica cpt5 = new CompTecnica("1", "Programar em Java", GrauProficiencia.NADA_SATISFATORIO);
        CompTecnica cpt6 = new CompTecnica("2", "Programar em Html", GrauProficiencia.NADA_SATISFATORIO);
        listaTarefa1.add(cpt5);
        listaTarefa1.add(cpt6);
        
        tp1.getListaCompetenciasTarefa().getListaCompTecnica().clear();
        tp1.getListaCompetenciasTarefa().setListaCompTecnica(listaTarefa1);
        freel1.getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        freel1.getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer1);
        freel2.getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        freel2.getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer2);
        
        ListaCandidatura listaCandidaturas = new ListaCandidatura();
        listaCandidaturas.getCandidaturas().clear();
        Candidatura cand1 = new Candidatura(data1, 100, 10, "TextoApr", "txtMot", "TP3", "2305");
        Candidatura cand2 = new Candidatura(data2, 90, 10, "TextoApr", "txtMot", "TP3", "1404");
        cand1.getNIFFreelancer().getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        cand1.getNIFFreelancer().getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer1);
        cand1.getRefTarefa().getListaCompetenciasTarefa().getListaCompTecnica().clear();
        cand1.getRefTarefa().getListaCompetenciasTarefa().setListaCompTecnica(listaTarefa1);
        cand2.getNIFFreelancer().getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        cand2.getNIFFreelancer().getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer2);
        cand2.getRefTarefa().getListaCompetenciasTarefa().getListaCompTecnica().clear();
        cand2.getRefTarefa().getListaCompetenciasTarefa().setListaCompTecnica(listaTarefa1);
                
        listaCandidaturas.getCandidaturas().add(cand1);
        listaCandidaturas.getCandidaturas().add(cand2);
                
        List<Candidatura> listaCandidaturaPosSeriacao = new ArrayList<>();
        listaCandidaturaPosSeriacao.clear();
        listaCandidaturaPosSeriacao.add(cand2);
        listaCandidaturaPosSeriacao.add(cand1);
        
        ProcessoSeriacao ps = new ProcessoSeriacao();
        String result = ps.ProcessoSeriacao1(listaCandidaturas.getCandidaturas());
        
        String expResult = listaCandidaturaPosSeriacao.toString();
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of ProcessoSeriacao1 method, of class ProcessoSeriacao.
     *
     * @throws java.io.FileNotFoundException Ficheiro Não Encontrado
     * @throws exception.NumeroForaDosLimitesException Número Fora Dos Limites
     * @throws exception.MesInvalidoException Mês Inválido
     * @throws exception.DiaInvalidoException Dia Inválido
     */
    @org.junit.jupiter.api.Test
    public void testProcessoSeriacao1MaisCedo() throws FileNotFoundException, NumeroForaDosLimitesException, MesInvalidoException, DiaInvalidoException {
        System.out.println("MaisCedo");
        
        ListaTarefa listaTarefas = new ListaTarefa();
        listaTarefas.getListaTarefas().clear();
        Tarefa tp1 = new Tarefa("TP3", "Trabalho 3", "Outro Trabalho", "Trabalha Mais", 54, 4);
        listaTarefas.getListaTarefas().add(tp1);

        ListaFreelancer listaFreelancers = new ListaFreelancer();
        listaFreelancers.getListaFreelancers().clear();
        Freelancer freel1 = new Freelancer("Diogo", "2305", "960000000", "diogo@gmail.com");
        Freelancer freel2 = new Freelancer("Rui", "1404", "960000000", "rui@gmail.com");
        listaFreelancers.getListaFreelancers().add(freel1);
        listaFreelancers.getListaFreelancers().add(freel2);
        
        Data data1 = new Data(2000, 11, 3);
        Data data2 = new Data(2001, 11, 3);
        
        List<CompTecnica> listaFreelancer1 = new ArrayList<>();
        listaFreelancer1.clear();
        CompTecnica cpt1 = new CompTecnica("1", "Programar em Java", GrauProficiencia.EXCELENTE);
        CompTecnica cpt2 = new CompTecnica("2", "Programar em Html", GrauProficiencia.EXCELENTE);
        listaFreelancer1.add(cpt1);
        listaFreelancer1.add(cpt2);
        
        List<CompTecnica> listaFreelancer2 = new ArrayList<>();
        listaFreelancer2.clear();
        CompTecnica cpt3 = new CompTecnica("1", "Programar em Java", GrauProficiencia.EXCELENTE);
        CompTecnica cpt4 = new CompTecnica("2", "Programar em Html", GrauProficiencia.EXCELENTE);
        listaFreelancer2.add(cpt3);
        listaFreelancer2.add(cpt4);
        
        List<CompTecnica> listaTarefa1 = new ArrayList<>();
        listaTarefa1.clear();
        CompTecnica cpt5 = new CompTecnica("1", "Programar em Java", GrauProficiencia.NADA_SATISFATORIO);
        CompTecnica cpt6 = new CompTecnica("2", "Programar em Html", GrauProficiencia.NADA_SATISFATORIO);
        listaTarefa1.add(cpt5);
        listaTarefa1.add(cpt6);
        
        tp1.getListaCompetenciasTarefa().getListaCompTecnica().clear();
        tp1.getListaCompetenciasTarefa().setListaCompTecnica(listaTarefa1);
        freel1.getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        freel1.getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer1);
        freel2.getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        freel2.getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer2);
        
        ListaCandidatura listaCandidaturas = new ListaCandidatura();
        listaCandidaturas.getCandidaturas().clear();
        Candidatura cand1 = new Candidatura(data1, 100, 10, "TextoApr", "txtMot", "TP3", "2305");
        Candidatura cand2 = new Candidatura(data2, 100, 10, "TextoApr", "txtMot", "TP3", "1404");
        cand1.getNIFFreelancer().getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        cand1.getNIFFreelancer().getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer1);
        cand1.getRefTarefa().getListaCompetenciasTarefa().getListaCompTecnica().clear();
        cand1.getRefTarefa().getListaCompetenciasTarefa().setListaCompTecnica(listaTarefa1);
        cand2.getNIFFreelancer().getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        cand2.getNIFFreelancer().getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer2);
        cand2.getRefTarefa().getListaCompetenciasTarefa().getListaCompTecnica().clear();
        cand2.getRefTarefa().getListaCompetenciasTarefa().setListaCompTecnica(listaTarefa1);
                
        listaCandidaturas.getCandidaturas().add(cand1);
        listaCandidaturas.getCandidaturas().add(cand2);
                
        List<Candidatura> listaCandidaturaPosSeriacao = new ArrayList<>();
        listaCandidaturaPosSeriacao.clear();
        listaCandidaturaPosSeriacao.add(cand2);
        listaCandidaturaPosSeriacao.add(cand1);
        
        ProcessoSeriacao ps = new ProcessoSeriacao();
        String result = ps.ProcessoSeriacao1(listaCandidaturas.getCandidaturas());
        
        String expResult = listaCandidaturaPosSeriacao.toString();
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of ProcessoSeriacao1 method, of class ProcessoSeriacao.
     *
     * @throws java.io.FileNotFoundException Ficheiro Não Encontrado
     * @throws exception.NumeroForaDosLimitesException Número Fora Dos Limites
     * @throws exception.MesInvalidoException Mês Inválido
     * @throws exception.DiaInvalidoException Dia Inválido
     */
    @org.junit.jupiter.api.Test
    public void testProcessoSeriacao2MediaMaior() throws FileNotFoundException, NumeroForaDosLimitesException, MesInvalidoException, DiaInvalidoException {
        System.out.println("MediaMaior");
        
        ListaTarefa listaTarefas = new ListaTarefa();
        listaTarefas.getListaTarefas().clear();
        Tarefa tp1 = new Tarefa("TP3", "Trabalho 3", "Outro Trabalho", "Trabalha Mais", 54, 4);
        listaTarefas.getListaTarefas().add(tp1);

        ListaFreelancer listaFreelancers = new ListaFreelancer();
        listaFreelancers.getListaFreelancers().clear();
        Freelancer freel1 = new Freelancer("Diogo", "2305", "960000000", "diogo@gmail.com");
        Freelancer freel2 = new Freelancer("Rui", "1404", "960000000", "rui@gmail.com");
        listaFreelancers.getListaFreelancers().add(freel1);
        listaFreelancers.getListaFreelancers().add(freel2);
        
        Data data1 = new Data(2000, 11, 3);
        Data data2 = new Data(2000, 11, 3);
        
        List<CompTecnica> listaFreelancer1 = new ArrayList<>();
        listaFreelancer1.clear();
        CompTecnica cpt1 = new CompTecnica("1", "Programar em Java", GrauProficiencia.EXCELENTE);
        CompTecnica cpt2 = new CompTecnica("2", "Programar em Html", GrauProficiencia.MUITO_SATISFATORIO);
        listaFreelancer1.add(cpt1);
        listaFreelancer1.add(cpt2);
        
        List<CompTecnica> listaFreelancer2 = new ArrayList<>();
        listaFreelancer2.clear();
        CompTecnica cpt3 = new CompTecnica("1", "Programar em Java", GrauProficiencia.EXCELENTE);
        CompTecnica cpt4 = new CompTecnica("2", "Programar em Html", GrauProficiencia.EXCELENTE);
        listaFreelancer2.add(cpt3);
        listaFreelancer2.add(cpt4);
        
        List<CompTecnica> listaTarefa1 = new ArrayList<>();
        listaTarefa1.clear();
        CompTecnica cpt5 = new CompTecnica("1", "Programar em Java", GrauProficiencia.NADA_SATISFATORIO);
        CompTecnica cpt6 = new CompTecnica("2", "Programar em Html", GrauProficiencia.NADA_SATISFATORIO);
        listaTarefa1.add(cpt5);
        listaTarefa1.add(cpt6);
        
        tp1.getListaCompetenciasTarefa().getListaCompTecnica().clear();
        tp1.getListaCompetenciasTarefa().setListaCompTecnica(listaTarefa1);
        freel1.getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        freel1.getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer1);
        freel2.getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        freel2.getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer2);
        
        ListaCandidatura listaCandidaturas = new ListaCandidatura();
        listaCandidaturas.getCandidaturas().clear();
        Candidatura cand1 = new Candidatura(data1, 100, 10, "TextoApr", "txtMot", "TP3", "2305");
        Candidatura cand2 = new Candidatura(data2, 100, 10, "TextoApr", "txtMot", "TP3", "1404");
        cand1.getNIFFreelancer().getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        cand1.getNIFFreelancer().getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer1);
        cand1.getRefTarefa().getListaCompetenciasTarefa().getListaCompTecnica().clear();
        cand1.getRefTarefa().getListaCompetenciasTarefa().setListaCompTecnica(listaTarefa1);
        cand2.getNIFFreelancer().getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        cand2.getNIFFreelancer().getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer2);
        cand2.getRefTarefa().getListaCompetenciasTarefa().getListaCompTecnica().clear();
        cand2.getRefTarefa().getListaCompetenciasTarefa().setListaCompTecnica(listaTarefa1);
                
        listaCandidaturas.getCandidaturas().add(cand1);
        listaCandidaturas.getCandidaturas().add(cand2);
                
        List<Candidatura> listaCandidaturaPosSeriacao = new ArrayList<>();
        listaCandidaturaPosSeriacao.clear();
        listaCandidaturaPosSeriacao.add(cand2);
        listaCandidaturaPosSeriacao.add(cand1);
        
        ProcessoSeriacao ps = new ProcessoSeriacao();
        String result = ps.ProcessoSeriacao2(listaCandidaturas.getCandidaturas());
        
        String expResult = listaCandidaturaPosSeriacao.toString();
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of ProcessoSeriacao1 method, of class ProcessoSeriacao.
     *
     * @throws java.io.FileNotFoundException Ficheiro Não Encontrado
     * @throws exception.NumeroForaDosLimitesException Número Fora Dos Limites
     * @throws exception.MesInvalidoException Mês Inválido
     * @throws exception.DiaInvalidoException Dia Inválido
     */
    @org.junit.jupiter.api.Test
    public void testProcessoSeriacao2MenorDesvio() throws FileNotFoundException, NumeroForaDosLimitesException, MesInvalidoException, DiaInvalidoException {
        System.out.println("MenorDesvio");
        
        ListaTarefa listaTarefas = new ListaTarefa();
        listaTarefas.getListaTarefas().clear();
        Tarefa tp1 = new Tarefa("TP3", "Trabalho 3", "Outro Trabalho", "Trabalha Mais", 54, 4);
        listaTarefas.getListaTarefas().add(tp1);

        ListaFreelancer listaFreelancers = new ListaFreelancer();
        listaFreelancers.getListaFreelancers().clear();
        Freelancer freel1 = new Freelancer("Diogo", "2305", "960000000", "diogo@gmail.com");
        Freelancer freel2 = new Freelancer("Rui", "1404", "960000000", "rui@gmail.com");
        listaFreelancers.getListaFreelancers().add(freel1);
        listaFreelancers.getListaFreelancers().add(freel2);
        
        Data data1 = new Data(2000, 11, 3);
        Data data2 = new Data(2000, 11, 3);
        
        List<CompTecnica> listaFreelancer1 = new ArrayList<>();
        listaFreelancer1.clear();
        CompTecnica cpt1 = new CompTecnica("1", "Programar em Java", GrauProficiencia.EXCELENTE);
        CompTecnica cpt2 = new CompTecnica("2", "Programar em Html", GrauProficiencia.SATISFATORIO);
        listaFreelancer1.add(cpt1);
        listaFreelancer1.add(cpt2);
        
        List<CompTecnica> listaFreelancer2 = new ArrayList<>();
        listaFreelancer2.clear();
        CompTecnica cpt3 = new CompTecnica("1", "Programar em Java", GrauProficiencia.MUITO_SATISFATORIO);
        CompTecnica cpt4 = new CompTecnica("2", "Programar em Html", GrauProficiencia.MUITO_SATISFATORIO);
        listaFreelancer2.add(cpt3);
        listaFreelancer2.add(cpt4);
        
        List<CompTecnica> listaTarefa1 = new ArrayList<>();
        listaTarefa1.clear();
        CompTecnica cpt5 = new CompTecnica("1", "Programar em Java", GrauProficiencia.NADA_SATISFATORIO);
        CompTecnica cpt6 = new CompTecnica("2", "Programar em Html", GrauProficiencia.NADA_SATISFATORIO);
        listaTarefa1.add(cpt5);
        listaTarefa1.add(cpt6);
        
        tp1.getListaCompetenciasTarefa().getListaCompTecnica().clear();
        tp1.getListaCompetenciasTarefa().setListaCompTecnica(listaTarefa1);
        freel1.getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        freel1.getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer1);
        freel2.getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        freel2.getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer2);
        
        ListaCandidatura listaCandidaturas = new ListaCandidatura();
        listaCandidaturas.getCandidaturas().clear();
        Candidatura cand1 = new Candidatura(data1, 100, 10, "TextoApr", "txtMot", "TP3", "2305");
        Candidatura cand2 = new Candidatura(data2, 100, 10, "TextoApr", "txtMot", "TP3", "1404");
        cand1.getNIFFreelancer().getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        cand1.getNIFFreelancer().getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer1);
        cand1.getRefTarefa().getListaCompetenciasTarefa().getListaCompTecnica().clear();
        cand1.getRefTarefa().getListaCompetenciasTarefa().setListaCompTecnica(listaTarefa1);
        cand2.getNIFFreelancer().getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        cand2.getNIFFreelancer().getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer2);
        cand2.getRefTarefa().getListaCompetenciasTarefa().getListaCompTecnica().clear();
        cand2.getRefTarefa().getListaCompetenciasTarefa().setListaCompTecnica(listaTarefa1);
                
        listaCandidaturas.getCandidaturas().add(cand1);
        listaCandidaturas.getCandidaturas().add(cand2);
                
        List<Candidatura> listaCandidaturaPosSeriacao = new ArrayList<>();
        listaCandidaturaPosSeriacao.clear();
        listaCandidaturaPosSeriacao.add(cand2);
        listaCandidaturaPosSeriacao.add(cand1);
        
        ProcessoSeriacao ps = new ProcessoSeriacao();
        String result = ps.ProcessoSeriacao2(listaCandidaturas.getCandidaturas());
        
        String expResult = listaCandidaturaPosSeriacao.toString();
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of ProcessoSeriacao1 method, of class ProcessoSeriacao.
     *
     * @throws java.io.FileNotFoundException Ficheiro Não Encontrado
     * @throws exception.NumeroForaDosLimitesException Número Fora Dos Limites
     * @throws exception.MesInvalidoException Mês Inválido
     * @throws exception.DiaInvalidoException Dia Inválido
     */
    @org.junit.jupiter.api.Test
    public void testProcessoSeriacao2PreçoMaisBaixo() throws FileNotFoundException, NumeroForaDosLimitesException, MesInvalidoException, DiaInvalidoException {
        System.out.println("PreçoMaisBaixo");
        
        ListaTarefa listaTarefas = new ListaTarefa();
        listaTarefas.getListaTarefas().clear();
        Tarefa tp1 = new Tarefa("TP3", "Trabalho 3", "Outro Trabalho", "Trabalha Mais", 54, 4);
        listaTarefas.getListaTarefas().add(tp1);

        ListaFreelancer listaFreelancers = new ListaFreelancer();
        listaFreelancers.getListaFreelancers().clear();
        Freelancer freel1 = new Freelancer("Diogo", "2305", "960000000", "diogo@gmail.com");
        Freelancer freel2 = new Freelancer("Rui", "1404", "960000000", "rui@gmail.com");
        listaFreelancers.getListaFreelancers().add(freel1);
        listaFreelancers.getListaFreelancers().add(freel2);
        
        Data data1 = new Data(2000, 11, 3);
        Data data2 = new Data(2000, 11, 3);
        
        List<CompTecnica> listaFreelancer1 = new ArrayList<>();
        listaFreelancer1.clear();
        CompTecnica cpt1 = new CompTecnica("1", "Programar em Java", GrauProficiencia.EXCELENTE);
        CompTecnica cpt2 = new CompTecnica("2", "Programar em Html", GrauProficiencia.EXCELENTE);
        listaFreelancer1.add(cpt1);
        listaFreelancer1.add(cpt2);
        
        List<CompTecnica> listaFreelancer2 = new ArrayList<>();
        listaFreelancer2.clear();
        CompTecnica cpt3 = new CompTecnica("1", "Programar em Java", GrauProficiencia.EXCELENTE);
        CompTecnica cpt4 = new CompTecnica("2", "Programar em Html", GrauProficiencia.EXCELENTE);
        listaFreelancer2.add(cpt3);
        listaFreelancer2.add(cpt4);
        
        List<CompTecnica> listaTarefa1 = new ArrayList<>();
        listaTarefa1.clear();
        CompTecnica cpt5 = new CompTecnica("1", "Programar em Java", GrauProficiencia.NADA_SATISFATORIO);
        CompTecnica cpt6 = new CompTecnica("2", "Programar em Html", GrauProficiencia.NADA_SATISFATORIO);
        listaTarefa1.add(cpt5);
        listaTarefa1.add(cpt6);
        
        tp1.getListaCompetenciasTarefa().getListaCompTecnica().clear();
        tp1.getListaCompetenciasTarefa().setListaCompTecnica(listaTarefa1);
        freel1.getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        freel1.getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer1);
        freel2.getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        freel2.getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer2);
        
        ListaCandidatura listaCandidaturas = new ListaCandidatura();
        listaCandidaturas.getCandidaturas().clear();
        Candidatura cand1 = new Candidatura(data1, 100, 10, "TextoApr", "txtMot", "TP3", "2305");
        Candidatura cand2 = new Candidatura(data2, 90, 10, "TextoApr", "txtMot", "TP3", "1404");
        cand1.getNIFFreelancer().getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        cand1.getNIFFreelancer().getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer1);
        cand1.getRefTarefa().getListaCompetenciasTarefa().getListaCompTecnica().clear();
        cand1.getRefTarefa().getListaCompetenciasTarefa().setListaCompTecnica(listaTarefa1);
        cand2.getNIFFreelancer().getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        cand2.getNIFFreelancer().getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer2);
        cand2.getRefTarefa().getListaCompetenciasTarefa().getListaCompTecnica().clear();
        cand2.getRefTarefa().getListaCompetenciasTarefa().setListaCompTecnica(listaTarefa1);
                
        listaCandidaturas.getCandidaturas().add(cand1);
        listaCandidaturas.getCandidaturas().add(cand2);
                
        List<Candidatura> listaCandidaturaPosSeriacao = new ArrayList<>();
        listaCandidaturaPosSeriacao.clear();
        listaCandidaturaPosSeriacao.add(cand2);
        listaCandidaturaPosSeriacao.add(cand1);
        
        ProcessoSeriacao ps = new ProcessoSeriacao();
        String result = ps.ProcessoSeriacao2(listaCandidaturas.getCandidaturas());
        
        String expResult = listaCandidaturaPosSeriacao.toString();
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of ProcessoSeriacao1 method, of class ProcessoSeriacao.
     *
     * @throws java.io.FileNotFoundException Ficheiro Não Encontrado
     * @throws exception.NumeroForaDosLimitesException Número Fora Dos Limites
     * @throws exception.MesInvalidoException Mês Inválido
     * @throws exception.DiaInvalidoException Dia Inválido
     */
    @org.junit.jupiter.api.Test
    public void testProcessoSeriacao2MaisCedo() throws FileNotFoundException, NumeroForaDosLimitesException, MesInvalidoException, DiaInvalidoException {
        System.out.println("MaisCedo");
        
        ListaTarefa listaTarefas = new ListaTarefa();
        listaTarefas.getListaTarefas().clear();
        Tarefa tp1 = new Tarefa("TP3", "Trabalho 3", "Outro Trabalho", "Trabalha Mais", 54, 4);
        listaTarefas.getListaTarefas().add(tp1);

        ListaFreelancer listaFreelancers = new ListaFreelancer();
        listaFreelancers.getListaFreelancers().clear();
        Freelancer freel1 = new Freelancer("Diogo", "2305", "960000000", "diogo@gmail.com");
        Freelancer freel2 = new Freelancer("Rui", "1404", "960000000", "rui@gmail.com");
        listaFreelancers.getListaFreelancers().add(freel1);
        listaFreelancers.getListaFreelancers().add(freel2);
        
        Data data1 = new Data(2000, 11, 3);
        Data data2 = new Data(2001, 11, 3);
        
        List<CompTecnica> listaFreelancer1 = new ArrayList<>();
        listaFreelancer1.clear();
        CompTecnica cpt1 = new CompTecnica("1", "Programar em Java", GrauProficiencia.EXCELENTE);
        CompTecnica cpt2 = new CompTecnica("2", "Programar em Html", GrauProficiencia.EXCELENTE);
        listaFreelancer1.add(cpt1);
        listaFreelancer1.add(cpt2);
        
        List<CompTecnica> listaFreelancer2 = new ArrayList<>();
        listaFreelancer2.clear();
        CompTecnica cpt3 = new CompTecnica("1", "Programar em Java", GrauProficiencia.EXCELENTE);
        CompTecnica cpt4 = new CompTecnica("2", "Programar em Html", GrauProficiencia.EXCELENTE);
        listaFreelancer2.add(cpt3);
        listaFreelancer2.add(cpt4);
        
        List<CompTecnica> listaTarefa1 = new ArrayList<>();
        listaTarefa1.clear();
        CompTecnica cpt5 = new CompTecnica("1", "Programar em Java", GrauProficiencia.NADA_SATISFATORIO);
        CompTecnica cpt6 = new CompTecnica("2", "Programar em Html", GrauProficiencia.NADA_SATISFATORIO);
        listaTarefa1.add(cpt5);
        listaTarefa1.add(cpt6);
        
        tp1.getListaCompetenciasTarefa().getListaCompTecnica().clear();
        tp1.getListaCompetenciasTarefa().setListaCompTecnica(listaTarefa1);
        freel1.getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        freel1.getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer1);
        freel2.getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        freel2.getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer2);
        
        ListaCandidatura listaCandidaturas = new ListaCandidatura();
        listaCandidaturas.getCandidaturas().clear();
        Candidatura cand1 = new Candidatura(data1, 100, 10, "TextoApr", "txtMot", "TP3", "2305");
        Candidatura cand2 = new Candidatura(data2, 100, 10, "TextoApr", "txtMot", "TP3", "1404");
        cand1.getNIFFreelancer().getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        cand1.getNIFFreelancer().getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer1);
        cand1.getRefTarefa().getListaCompetenciasTarefa().getListaCompTecnica().clear();
        cand1.getRefTarefa().getListaCompetenciasTarefa().setListaCompTecnica(listaTarefa1);
        cand2.getNIFFreelancer().getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        cand2.getNIFFreelancer().getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer2);
        cand2.getRefTarefa().getListaCompetenciasTarefa().getListaCompTecnica().clear();
        cand2.getRefTarefa().getListaCompetenciasTarefa().setListaCompTecnica(listaTarefa1);
                
        listaCandidaturas.getCandidaturas().add(cand1);
        listaCandidaturas.getCandidaturas().add(cand2);
                
        List<Candidatura> listaCandidaturaPosSeriacao = new ArrayList<>();
        listaCandidaturaPosSeriacao.clear();
        listaCandidaturaPosSeriacao.add(cand2);
        listaCandidaturaPosSeriacao.add(cand1);
        
        ProcessoSeriacao ps = new ProcessoSeriacao();
        String result = ps.ProcessoSeriacao2(listaCandidaturas.getCandidaturas());
        
        String expResult = listaCandidaturaPosSeriacao.toString();
        
        assertEquals(expResult, result);
    }
//    /**
//     * Test of ProcessoSeriacao2 method, of class ProcessoSeriacao.
//     *
//     * @throws java.io.FileNotFoundException Ficheiro Não Encontrado
//     * @throws Exceptions.NumeroForaDosLimitesException Número Fora Dos Limites
//     * @throws Exceptions.MesInvalidoException Mês Inválido
//     * @throws Exceptions.DiaInvalidoException Dia Inválido
//     */
//    @org.junit.jupiter.api.Test
//    public void testProcessoSeriacao2() throws FileNotFoundException, NumeroForaDosLimitesException, MesInvalidoException, DiaInvalidoException {
//        System.out.println("ProcessoSeriacao2");
//        ProcessoSeriacao instance = new ProcessoSeriacao();
//
//        Freelancer freel1 = new Freelancer("António", "1222", "930000000", "antonio@gmail.com");
//        Freelancer freel2 = new Freelancer("Rui", "1404", "960000000", "rui@gmail.com");
//        Freelancer freel3 = new Freelancer("Diogo", "2305", "960000000", "diogo@gmail.com");
//
//        Tarefa tp3 = new Tarefa("TP3", "Trabalho 3", "Outro Trabalho", "Trabalha Mais", 54, 4);
//
//        Data data1 = new Data(2000, 11, 3);
//        Candidatura cand1 = new Candidatura(data1, 140, 54, "Olá", "Eu", "TP3", "1404");
//
//        Data data2 = new Data(2000, 1, 4);
//        Candidatura cand2 = new Candidatura(data2, 130, 48, "Bom dia", "Tu", "TP3", "1222");
//
//        Data data3 = new Data(2010, 2, 12);
//        Candidatura cand3 = new Candidatura(data3, 120, 54, "Boa Tarde", "Nos", "TP3", "2305");
//
//        List<Candidatura> listaCandidaturas = new ArrayList<>();
//        listaCandidaturas.add(cand1);
//        listaCandidaturas.add(cand2);
//        listaCandidaturas.add(cand3);
//
//        List<Candidatura> listaCandidaturaPosSeriacao = new ArrayList<Candidatura>();
//        listaCandidaturaPosSeriacao.add(cand3);
//        listaCandidaturaPosSeriacao.add(cand2);
//        listaCandidaturaPosSeriacao.add(cand1);
//        String expResult = listaCandidaturaPosSeriacao.toString();
//        String result = instance.ProcessoSeriacao2(listaCandidaturas);
//        assertEquals(expResult, result);
//    }
}
