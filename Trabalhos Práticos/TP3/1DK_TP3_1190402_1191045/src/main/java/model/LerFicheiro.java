package model;

import exception.DiaInvalidoException;
import exception.MesInvalidoException;
import exception.NumeroForaDosLimitesException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Lê os ficheiros e cria os objetos refentes ao mesmo.
 *
 * @author 1190402-1191045
 */
public class LerFicheiro {

    /**
     * Lê e instância tarefas que foram recebidas através da leitura de um
     * ficheiro de texto.
     *
     * @return lista de tarefas criada a partir da leitura de ficheiro
     */
    public static List<Tarefa> lerFicheiroTarefas() {
        boolean VF = false;
        List<Tarefa> listaDeTarefas = new ArrayList<>();
        try {
            Scanner in = new Scanner(new File("Tarefas.txt"));
            String cabecalho = in.nextLine();
            try {
                while (in.hasNextLine()) {
                    String linha = in.nextLine();
                    String[] data = linha.split(";");
                    Tarefa tarefa = new Tarefa(data[0].trim(), data[1].trim(),
                            data[2].trim(), data[3].trim(),
                            Integer.parseInt(data[4].trim()),
                            Double.parseDouble(data[5].trim()));
                    if (!listaDeTarefas.contains(tarefa)) {
                        if (listaDeTarefas.isEmpty()) {
                            listaDeTarefas.add(tarefa);
                        } else {
                            for (int i = 0; i < listaDeTarefas.size(); i++) {
                                Tarefa tar = listaDeTarefas.get(i);
                                if (tar.getReferencia().equalsIgnoreCase(data[0].trim())) {
                                    VF = true;
                                }
                            }
                            if (VF == false) {
                                listaDeTarefas.add(tarefa);
                            }
                        }
                    }
                }
            } finally {
                in.close();
            }
        } catch (FileNotFoundException fne) {
            System.out.println("Ficheiro de Tarefas não encontrado!");
        } catch (NumeroForaDosLimitesException | NumberFormatException npe) {
            System.out.println("Falha de informação precisa no registo de Tarefas!");
        }

        return listaDeTarefas;
    }

    /**
     * Lê e instância candidaturas que foram recebidas através da leitura de um
     * ficheiro de texto.
     *
     * @return lista de candidaturas criada a partir da leitura de ficheiro
     */
    public static List<Candidatura> lerFicheiroCandidaturas() {
        List<Candidatura> listaDeCandidaturas = new ArrayList<>();
        try {
            Scanner in = new Scanner(new File("Candidaturas.txt"));
            String cabecalho = in.nextLine();
            try {
                while (in.hasNextLine()) {
                    String linha = in.nextLine();
                    String[] data = linha.split(";");
                    Data dataCandidatura = new Data(Integer.parseInt(data[0].trim()),
                            Integer.parseInt(data[1].trim()), Integer.parseInt(data[2].trim()));
                    Candidatura candidatura = new Candidatura(dataCandidatura,
                            Double.parseDouble(data[3].trim()), Integer.parseInt(data[4].trim()),
                            data[5].trim(), data[6].trim(), data[7].trim(), data[8].trim());
                    if (!listaDeCandidaturas.contains(candidatura)) {
                        listaDeCandidaturas.add(candidatura);
                    }
                }
            } finally {
                in.close();
            }
        } catch (FileNotFoundException fne) {
            System.out.println("Ficheiro de Candidaturas não encontrado!");
        } catch (DiaInvalidoException | MesInvalidoException | NumeroForaDosLimitesException | NumberFormatException e) {
            System.out.println("Falha de informação precisa no registo de Candidaturas!");
        }
        return listaDeCandidaturas;
    }

    /**
     *
     * Lê e instância freelancer que foram recebidas através da leitura de um
     * ficheiro de texto.
     *
     * @return lista de freelancer criada a partir da leitura de ficheiro
     */
    public static List<Freelancer> lerFicheiroFreelancer() {
        boolean VF = false;
        List<Freelancer> listaDeFreelancers = new ArrayList<>();
        try {
            Scanner in = new Scanner(new File("Freelancer.txt"));
            String cabecalho = in.nextLine();
            try {
                while (in.hasNextLine()) {
                    String linha = in.nextLine();
                    String[] data = linha.split(";");
                    Freelancer freelancer = new Freelancer(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim());
                    if (!listaDeFreelancers.contains(freelancer)) {
                        if (listaDeFreelancers.isEmpty()) {
                            listaDeFreelancers.add(freelancer);
                        } else {
                            for (int i = 0; i < listaDeFreelancers.size(); i++) {
                                Freelancer free = listaDeFreelancers.get(i);
                                if (free.getNIF().equalsIgnoreCase(data[1].trim())) {
                                    VF = true;
                                }
                            }
                            if (VF == false) {
                                listaDeFreelancers.add(freelancer);
                            }
                        }
                    }
                }
            } finally {
                in.close();
            }
        } catch (FileNotFoundException fne) {
            System.out.println("Ficheiro de Freelancer não encontrado!");
        } catch (NumeroForaDosLimitesException e) {
            System.out.println("Falha de informação precisa no registo de Freelancer!");
        }
        return listaDeFreelancers;
    }

    /**
     *
     * Lê e instância Competências Técnicas que foram recebidas através da
     * leitura de um ficheiro de texto para associar às tarefas
     *
     * @param referencia referencia da tarefa
     * @return lista de competências criada a partir da leitura de ficheiro
     */
    public static List<CompTecnica> lerFicheiroCompetenciasNecessariasATarefa(String referencia) {
        List<CompTecnica> listaCompTecnica = new ArrayList<>();
        try {
            Scanner in = new Scanner(new File("ComptTecnica_GrauDeProficiencia_Tarefa.txt"));
            String cabecalho = in.nextLine();
            try {
                while (in.hasNextLine()) {
                    String linha = in.nextLine();
                    String[] data = linha.split(";");
                    CompTecnica compTecnica = new CompTecnica(data[1].trim(), data[2].trim(), GrauProficiencia.valueOf(data[3].trim()));
                    if (referencia.equalsIgnoreCase(data[0].trim())) {
                        if (!listaCompTecnica.contains(compTecnica)) {
                            listaCompTecnica.add(compTecnica);
                        }
                    }
                }
            } finally {
                in.close();
            }
        } catch (FileNotFoundException fne) {
            System.out.println("Ficheiro de Competencias Necessarias à Tarefa não encontrado!");
        } catch (Exception e) {
            System.out.println("Falha de informação precisa no registo de Competencias Necessarias à Tarefa!");
        }
        return listaCompTecnica;
    }

    /**
     *
     * Lê e instância Competências Técnicas que foram recebidas através da
     * leitura de um ficheiro de texto para associar às tarefas
     *
     * @param NIF nif do freelancer
     * @return lista de competências criada a partir da leitura de ficheiro
     */
    public static List<CompTecnica> lerFicheiroreconhecimentoCompetenciasFreelancer(String NIF) {
        List<CompTecnica> listaCompTecnica = new ArrayList<>();
        try {
            Scanner in = new Scanner(new File("ComptTecnica_GrauDeProficiencia_Freelancer.txt"));
            String cabecalho = in.nextLine();
            try {
                while (in.hasNextLine()) {
                    String linha = in.nextLine();
                    String[] data = linha.split(";");
                    CompTecnica compTecnica = new CompTecnica(data[1].trim(), data[2].trim(), GrauProficiencia.valueOf(data[3].trim()));
                    if (NIF.equalsIgnoreCase(data[0].trim())) {
                        if (!listaCompTecnica.contains(compTecnica)) {
                            listaCompTecnica.add(compTecnica);
                        }
                    }
                }
            } finally {
                in.close();
            }
        } catch (FileNotFoundException fne) {
            System.out.println("Ficheiro de Competencias Necessarias ao Freelancer não encontrado!");
        } catch (Exception e) {
            System.out.println("Falha de informação precisa no registo de Competencias Necessarias ao Freelancer!");
        }
        return listaCompTecnica;
    }

}
