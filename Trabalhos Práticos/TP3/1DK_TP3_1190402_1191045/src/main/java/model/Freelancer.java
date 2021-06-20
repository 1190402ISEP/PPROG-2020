package model;

import exception.NumeroForaDosLimitesException;
import java.io.FileNotFoundException;

/**
 * Faz registo de Freelancers
 *
 * @author 1190402-1191045
 */
public class Freelancer {

    /**
     * O nome do Freelancer.
     */
    private String nome;
    /**
     * O NIF do Freelancer.
     */
    private String NIF;
    /**
     * O telefone do Freelancer.
     */
    private String telefone;
    /**
     * O email do Freelancer.
     */
    private String email;
    /**
     * Lista de Competências do Freelancer.
     */
    private ListaCompetencia reconhecimentosDeCompetencias;

    /**
     * Constrói uma instância de Freelancer recebendo o nome,nif,telefone e
     * email.
     *
     * @param nome Nome do Freelancer
     * @param NIF NIF do Freelancer
     * @param telefone Telefone do Freelancer
     * @param email Email do Freelancer
     * @throws java.io.FileNotFoundException Ficheiro Não Encontrado
     * @throws exception.NumeroForaDosLimitesException Número Fora Dos Limites permitidos
     */
    public Freelancer(String nome, String NIF, String telefone, String email) throws FileNotFoundException, NumeroForaDosLimitesException {
        setNome(nome);
        setNIF(NIF);
        setTelefone(telefone);
        setEmail(email);
        reconhecimentosDeCompetencias = new ListaCompetencia(NIF, true);
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the nif
     */
    public String getNIF() {
        return NIF;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the reconhecimentosDeCompetencias
     */
    public ListaCompetencia getReconhecimentosDeCompetencias() {
        return reconhecimentosDeCompetencias;
    }

    /**
     * @param nome the nome to set
     */
    public final void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome Inválido!");
        }
        this.nome = nome;
    }

    /**
     * @param NIF the NIF to set
     */
    public final void setNIF(String NIF) {
        if (NIF == null || NIF.trim().isEmpty()) {
            throw new IllegalArgumentException("Nif Inválido!");
        }
        this.NIF = NIF;
    }

    /**
     * @param telefone the telefone to set
     */
    public final void setTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("Telefone Inválido!");
        }
        this.telefone = telefone;
    }

    /**
     * @param email the email to set
     */
    public final void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email Inválido!");
        }
        this.email = email;
    }

    /**
     * @param reconhecimentosDeCompetencias the reconhecimentosDeCompetencias to
     * set
     */
    public void setReconhecimentosDeCompetencias(ListaCompetencia reconhecimentosDeCompetencias) {
        this.reconhecimentosDeCompetencias = reconhecimentosDeCompetencias;
    }

    /**
     * Devolve a descrição textual acerca do Freelancer.
     *
     * @return informação sobre o Freelancer
     */
    @Override
    public String toString() {
        return String.format("FREELANCER!!\nNome: %s\nNIF: %s\n"
                + "Telefone: %s\nEmail: %s\nLista de Competencias:\n%s\n", this.nome, this.NIF,
                this.telefone, this.email, this.reconhecimentosDeCompetencias);
    }

    /**
     * Compara o Freelancer com o objeto recebido
     *
     * @param outroObjeto o objeto a comparar com o Freelancer.
     * @return true se o objeto recebido representar um Freelancer equivalente
     * ao Freelancer. Caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Freelancer outroFreelancer = (Freelancer) outroObjeto;
        return this.nome.equalsIgnoreCase(outroFreelancer.nome) && this.NIF.equalsIgnoreCase(outroFreelancer.NIF) && this.telefone.equalsIgnoreCase(outroFreelancer.telefone) && this.email.equalsIgnoreCase(outroFreelancer.email);
    }

}
