package Escola;

public class AlunoBolseiro extends Aluno implements Pagavel{
    private float bolsaMensal;
    
    public static final float BOLSA_MENSAL_POR_OMISSAO = 0;
    
    public AlunoBolseiro(String nome, int idCivil, int numero, float bolsaMensal){
        super(nome, idCivil, numero);
        this.bolsaMensal = bolsaMensal;        
    }
    
    public AlunoBolseiro(String nome, int idCivil, int numero){
        super(nome, idCivil, numero);
        bolsaMensal = BOLSA_MENSAL_POR_OMISSAO;        
    }
    
    public AlunoBolseiro(String nome){
        super(nome);    
        bolsaMensal = BOLSA_MENSAL_POR_OMISSAO; 
    }
    
    public AlunoBolseiro(){
        super();
        bolsaMensal = BOLSA_MENSAL_POR_OMISSAO; 
    }
   
    public float getBolsaMensal() {
        return bolsaMensal;
    }

    public void setBolsaMensal(float bolsaMensal) {
        this.bolsaMensal = bolsaMensal;
    }
    
    @Override
    public String toString(){
        return "A";
    }
    
    @Override
    public float calcularPagamento(){
        return 0;
    }
}
