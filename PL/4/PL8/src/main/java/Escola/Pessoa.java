package Escola;

public class Pessoa {
    private String nome;
    private int idCivil;
    
    public static final String NOME_POR_OMISSAO = "Sem nome";
    public static final int IDCIVIL_POR_OMISSAO = 0;
    
    public Pessoa(String nome, int idCivil){
        this.nome = nome;
        this.idCivil = idCivil;        
    }
    
    public Pessoa(String nome){
        this.nome = nome;
        idCivil = IDCIVIL_POR_OMISSAO;        
    }
    
    public Pessoa(){
        nome = NOME_POR_OMISSAO;
        idCivil = IDCIVIL_POR_OMISSAO;        
    }

    public String getNome() {
        return nome;
    }

    public int getIdCivil() {
        return idCivil;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdCivil(int idCivil) {
        this.idCivil = idCivil;
    }
    
    @Override
    public String toString(){
        return "A";
    }
}
