package Escola;

public class Professor extends Pessoa implements Pagavel{
    private String categoria;
    
    public static final String CATEGORIA_POR_OMISSAO = Professor.ASSISTENTE;
    
    public static final String ASSISTENTE = "Assistente";
    public static final String ADJUNTO = "Adjunto";
    public static final String COORDENADOR = "Coordenador";
    
    private static float vencimentoBase = 1500;
    private static float majoracaoAssistente = 0;
    private static float majoracaoAdjunto = 20;
    private static float majoracaoCoordenador = 50;
    
    public Professor(String nome, int idCivil){
        super(nome, idCivil);       
    }
    
    public Professor(String nome){
        super(nome); 
    }
    
    public Professor(){
        super();     
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    @Override
    public String toString(){
        return "A";
    }
    
    @Override
    public float calcularPagamento(){
        //return vencimento * (1 + calcularMajoracao() / 100);
        return 0;
    }
    
    private float calcularMajoracao(){
        return 0;
    }

    /**
     * @return the vencimentoBase
     */
    public static float getVencimentoBase() {
        return vencimentoBase;
    }

    /**
     * @return the majoracaoAssistente
     */
    public static float getMajoracaoAssistente() {
        return majoracaoAssistente;
    }

    /**
     * @return the majoracaoAdjunto
     */
    public static float getMajoracaoAdjunto() {
        return majoracaoAdjunto;
    }

    /**
     * @return the majoracaoCoordenador
     */
    public static float getMajoracaoCoordenador() {
        return majoracaoCoordenador;
    }

    /**
     * @param aVencimentoBase the vencimentoBase to set
     */
    public static void setVencimentoBase(float aVencimentoBase) {
        vencimentoBase = aVencimentoBase;
    }

    /**
     * @param aMajoracaoAssistente the majoracaoAssistente to set
     */
    public static void setMajoracaoAssistente(float aMajoracaoAssistente) {
        majoracaoAssistente = aMajoracaoAssistente;
    }

    /**
     * @param aMajoracaoAdjunto the majoracaoAdjunto to set
     */
    public static void setMajoracaoAdjunto(float aMajoracaoAdjunto) {
        majoracaoAdjunto = aMajoracaoAdjunto;
    }

    /**
     * @param aMajoracaoCoordenador the majoracaoCoordenador to set
     */
    public static void setMajoracaoCoordenador(float aMajoracaoCoordenador) {
        majoracaoCoordenador = aMajoracaoCoordenador;
    }
}
