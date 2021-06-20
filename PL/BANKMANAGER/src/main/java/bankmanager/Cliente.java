package bankmanager;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anton
 */
public class Cliente implements Comparable {

    private String nome;
    private String nif;
    private String morada;
    private int saldoContabilistico;
    private List <Cliente> clientes =new ArrayList <Cliente> ();
    private static final String NOME_POR_OMISSAO = "Sem Nome";
    private static final String NIF_POR_OMISSAO = "Sem Nif";

    private static final String MORADA_POR_OMISSAO = "Sem Morada";

    /**
     *
     * @param nome
     * @param nif
     * @param morada
     */
    public Cliente(String nome, String nif, String morada) {
        try{
          this.nome = nome;
        this.nif = nif;
        this.morada = morada;   
        }
       catch(IllegalArgumentException e){
           throw new IllegalArgumentException("ERRO CRÍTICO");
       }
    }

    /**
     *
     */
    public Cliente() {
        this.nome = NOME_POR_OMISSAO;
        this.nif = NIF_POR_OMISSAO;

        this.morada = MORADA_POR_OMISSAO;
    }

    /**
     *
     * @param outroCliente
     */
    public Cliente(Cliente outroCliente) {
        this.nome = outroCliente.nome;
        this.nif = outroCliente.nif;
        this.morada = outroCliente.morada;

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
    public String getNif() {
        return nif;
    }

    /**
     * @return the morada
     */
    public String getMorada() {
        return morada;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param nif the nif to set
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * @param morada the morada to set
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String toString() {
        return String.format("INFORMAÇÃO DO CLIENTE:\n NOME: %s\nNIF: %s\nMORADA: %s");
    }

    /**
     *
     * @param c
     */
    public void addCliente(Cliente c){
        clientes.add(c);
    }

    /**
     *
     * @param c
     */
    public void remCliente(Cliente c){
        clientes.remove(c);
    }

    public int compareTo(Object cliente) {
        Cliente cliente1= (Cliente) cliente;
        return nome.compareTo(cliente1.nome);
    }
    
    
    
    
    
    
    
    
    
    
}
