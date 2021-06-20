/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import exception.DiaInvalidoException;
import exception.MesInvalidoException;
import exception.NumeroForaDosLimitesException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import model.Candidatura;
import model.CompTecnica;
import model.Data;
import model.Freelancer;
import model.GrauProficiencia;
import model.ListaCandidatura;
import model.ListaFreelancer;
import model.ListaTarefa;
import model.Tarefa;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author pokem
 */
public class CandidaturaTest {
    
    public CandidaturaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of doMedia method, of class Candidatura.
     * @throws java.io.FileNotFoundException
     * @throws exception.NumeroForaDosLimitesException
     * @throws exception.DiaInvalidoException
     * @throws exception.MesInvalidoException
     */
    @Test
    public void testDoMedia() throws FileNotFoundException, NumeroForaDosLimitesException, DiaInvalidoException, MesInvalidoException {
        System.out.println("doMedia");
        
        ListaTarefa listaTarefas = new ListaTarefa();
        listaTarefas.getListaTarefas().clear();
        Tarefa tp1 = new Tarefa("TP3", "Trabalho 3", "Outro Trabalho", "Trabalha Mais", 54, 4);
        listaTarefas.getListaTarefas().add(tp1);

        ListaFreelancer listaFreelancers = new ListaFreelancer();
        listaFreelancers.getListaFreelancers().clear();
        Freelancer freel1 = new Freelancer("Diogo", "2305", "960000000", "diogo@gmail.com");
        listaFreelancers.getListaFreelancers().add(freel1);
        
        Data data1 = new Data(2000, 11, 3);
        
        List<CompTecnica> listaFreelancer1 = new ArrayList<>();
        listaFreelancer1.clear();
        CompTecnica cpt1 = new CompTecnica("1", "Programar em Java", GrauProficiencia.EXCELENTE);
        CompTecnica cpt2 = new CompTecnica("2", "Programar em Html", GrauProficiencia.SATISFATORIO);
        listaFreelancer1.add(cpt1);
        listaFreelancer1.add(cpt2);
        
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
        
        ListaCandidatura listaCandidaturas = new ListaCandidatura();
        listaCandidaturas.getCandidaturas().clear();
        Candidatura cand1 = new Candidatura(data1, 100, 10, "TextoApr", "txtMot", "TP3", "2305");
        cand1.getNIFFreelancer().getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        cand1.getNIFFreelancer().getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer1);
        cand1.getRefTarefa().getListaCompetenciasTarefa().getListaCompTecnica().clear();
        cand1.getRefTarefa().getListaCompetenciasTarefa().setListaCompTecnica(listaTarefa1);
       
        double expResult = 4.0;
        double result = cand1.doMedia();
        assertEquals(expResult, result, 0.0);
    }
        
    /**
     * Test of doDesvioPadrao method, of class Candidatura.
     * @throws java.io.FileNotFoundException
     * @throws exception.NumeroForaDosLimitesException
     * @throws exception.MesInvalidoException
     * @throws exception.DiaInvalidoException
     */
    @Test
    public void testDoDesvioPadrao() throws FileNotFoundException, NumeroForaDosLimitesException, MesInvalidoException, DiaInvalidoException {
        System.out.println("doDesvioPadrao");
        
        ListaTarefa listaTarefas = new ListaTarefa();
        listaTarefas.getListaTarefas().clear();
        Tarefa tp1 = new Tarefa("TP3", "Trabalho 3", "Outro Trabalho", "Trabalha Mais", 54, 4);
        listaTarefas.getListaTarefas().add(tp1);

        ListaFreelancer listaFreelancers = new ListaFreelancer();
        listaFreelancers.getListaFreelancers().clear();
        Freelancer freel1 = new Freelancer("Diogo", "2305", "960000000", "diogo@gmail.com");
        listaFreelancers.getListaFreelancers().add(freel1);
        
        Data data1 = new Data(2000, 11, 3);
        
        List<CompTecnica> listaFreelancer1 = new ArrayList<>();
        listaFreelancer1.clear();
        CompTecnica cpt1 = new CompTecnica("1", "Programar em Java", GrauProficiencia.EXCELENTE);
        CompTecnica cpt2 = new CompTecnica("2", "Programar em Html", GrauProficiencia.MUITO_SATISFATORIO);
        listaFreelancer1.add(cpt1);
        listaFreelancer1.add(cpt2);
        
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
        
        ListaCandidatura listaCandidaturas = new ListaCandidatura();
        listaCandidaturas.getCandidaturas().clear();
        Candidatura cand1 = new Candidatura(data1, 100, 10, "TextoApr", "txtMot", "TP3", "2305");
        cand1.getNIFFreelancer().getReconhecimentosDeCompetencias().getListaCompTecnica().clear();
        cand1.getNIFFreelancer().getReconhecimentosDeCompetencias().setListaCompTecnica(listaFreelancer1);
        cand1.getRefTarefa().getListaCompetenciasTarefa().getListaCompTecnica().clear();
        cand1.getRefTarefa().getListaCompetenciasTarefa().setListaCompTecnica(listaTarefa1);
       
        double expResult = 0.5;        
        double result = cand1.doDesvioPadrao();
        
        assertEquals(expResult, result, 0.0);
    } 
}
