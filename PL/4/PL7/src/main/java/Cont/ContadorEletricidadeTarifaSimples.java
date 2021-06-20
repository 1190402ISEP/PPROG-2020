
package Cont;

public class ContadorEletricidadeTarifaSimples extends ContadorEletricidade{
    private float potencia;
    
    private static final float POTENCIA_POR_OMISSAO = 6.9f;
    
    private float custoKwhHora1 = 0.13f;
    private float custoKwhHora2 = 0.16f;
    
    
    public ContadorEletricidadeTarifaSimples(String cliente, int consumo, float potencia){
        super(cliente, consumo);
        this.potencia = potencia;
    }
    
    public ContadorEletricidadeTarifaSimples(String cliente, float potencia){
        super(cliente);
        this.potencia = potencia;
    }
    
    public ContadorEletricidadeTarifaSimples(String cliente){
        super(cliente);
        potencia = POTENCIA_POR_OMISSAO;
    }
    
    public ContadorEletricidadeTarifaSimples(float potencia){
        super();
        this.potencia = potencia;
    }
    
    public ContadorEletricidadeTarifaSimples(){
        super();
        potencia = POTENCIA_POR_OMISSAO;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }
    
    @Override
    public String toString(){
        return String.format("%s Consumo: %d", super.toString(), super.getConsumo());
    }
    
    @Override
    public float CalcularCusto(){
        return DeterminarCustoKwhHora() * super.getConsumo();
    }
    
    public float DeterminarCustoKwhHora(){
        if (potencia < 6.9){
            return getCustoKwhHora1();
        } else {
            return getCustoKwhHora2();
        }
    }

    public float getCustoKwhHora1() {
        return custoKwhHora1;
    }

    public void setCustoKwhHora1(float custoKwhHora1) {
        this.custoKwhHora1 = custoKwhHora1;
    }

    public float getCustoKwhHora2() {
        return custoKwhHora2;
    }

    public void setCustoKwhHora2(float custoKwhHora2) {
        this.custoKwhHora2 = custoKwhHora2;
    }

}
