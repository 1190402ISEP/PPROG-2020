package Escola;

public class Aluno extends Pessoa{
    private int numero;
    
    public static final int NUMERO_POR_OMISSAO = 0;
    
    public Aluno(String nome, int idCivil, int numero){
        super(nome, idCivil);
        this.numero = numero;        
    }
    
    public Aluno(String nome){
        super(nome);    
        numero = NUMERO_POR_OMISSAO;
    }

    
    public Aluno(){
        super();
        numero = NUMERO_POR_OMISSAO;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    @Override
    public String toString(){
        //return String.format("Aluno", args);
        return "A";
    }
}
