package Cont;

public class ContadorEletricidadeBiHorario extends ContadorEletricidade{
    private int consumoHorasVazio;
    
    private static final int CONSUMO_HORAS_VAZIO_POR_OMISSAO = 0;
    
    private float custoKwhHoraVazio = 0.066f;
    private float custoKwhHoraForaVazio = 0.14f;
    
    
    public ContadorEletricidadeBiHorario(String cliente, int consumoHoraForaVazio, int consumoHorasVazio){
        super(cliente, consumoHoraForaVazio);
        this.consumoHorasVazio = consumoHorasVazio;
    }
    
    public ContadorEletricidadeBiHorario(int consumoHoraForaVazio, int consumoHorasVazio){
        super(consumoHoraForaVazio);
        this.consumoHorasVazio = consumoHorasVazio;
    }
    
    public ContadorEletricidadeBiHorario(String cliente){
        super(cliente);
        consumoHorasVazio = CONSUMO_HORAS_VAZIO_POR_OMISSAO;
    }
    
    public ContadorEletricidadeBiHorario(float potencia){
        super();
        consumoHorasVazio = CONSUMO_HORAS_VAZIO_POR_OMISSAO;
    }
    
    public int getConsumoHorasVazio() {
        return consumoHorasVazio;
    }

    public void setConsumoHorasVazio(int consumoHorasVazio) {
        this.consumoHorasVazio = consumoHorasVazio;
    }
    
    @Override
    public String toString(){
        return String.format("%s Consumo Fora Vazio: %d Consumo Vazio: %d", super.toString(), super.getConsumo(), consumoHorasVazio);
    }

    @Override
    public float CalcularCusto(){
        return (super.getConsumo() * getCustoKwhHoraForaVazio()) + (consumoHorasVazio * getCustoKwhHoraVazio());
    }

    public float getCustoKwhHoraVazio() {
        return custoKwhHoraVazio;
    }

    public float getCustoKwhHoraForaVazio() {
        return custoKwhHoraForaVazio;
    }

    public void setCustoKwhHoraVazio(float custoKwhHoraVazio) {
        this.custoKwhHoraVazio = custoKwhHoraVazio;
    }

    public void setCustoKwhHoraForaVazio(float custoKwhHoraForaVazio) {
        this.custoKwhHoraForaVazio = custoKwhHoraForaVazio;
    }    
}
