package Tempo;

public class Tempo {
    private int hora;
    private int minuto;
    private int segundo;
    
    private static final int HORA_POR_OMISSÃO=0;
    private static final int MINUTO_POR_OMISSÃO=0;
    private static final int SEGUNDO_POR_OMISSÃO=0;
    
    public Tempo(){
        this.hora = HORA_POR_OMISSÃO;
        this.minuto = MINUTO_POR_OMISSÃO;
        this.segundo = SEGUNDO_POR_OMISSÃO;
    }
    
    public Tempo(int hora, int minuto, int segundo){
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }
    
    public int getHora(){
        return hora;
    }
    
    public int getMinuto(){
        return minuto;
    }
    
    public int getSegundo(){
        return segundo;
    }
    
    public void setHora(int hora){
        this.hora = hora;
    }
    
    public void setMinuto(int minuto){
        this.minuto = minuto;
    }
    
    public void setSegundo(int segundo){
        this.segundo = segundo;
    }
    
    public String toStringAMPM(){
        String tempo = AMPM();
        return String.format("%s", tempo);
    }
    
    public String toString(){
        return String.format("%d:%d:%d", hora, minuto, segundo);
    }
    
    public void aumentarSeg(){
        if(segundo<59){
            segundo += 1;
        } else {
            segundo = 0;
            if (minuto < 59){
                minuto += 1;
            } else {
                minuto = 0;
                if (hora < 23){
                    hora += 1;
                } else {
                    hora = 0;
                }
            }
        }
    }
    
    private String AMPM(){
        String fim;
        
        if(hora==0 || hora==24){
            int hora1 = 12;
            fim = "AM";
            return String.format("%d:%d:%d %s", hora1, minuto, segundo, fim);
        } else {
            if (hora<12){
                fim = "AM";
                return String.format("%d:%d:%d %s", hora, minuto, segundo, fim);
            } else {
                int hora1 = hora - 12;
                fim = "PM";
                return String.format("%d:%d:%d %s", hora1, minuto, segundo, fim);
            }
        }
    }
    
    public boolean isMaior(Tempo outroTempo) {
        int totalSeg = totalSegundos();
        int totalSeg1 = outroTempo.totalSegundos();

        return totalSeg > totalSeg1;
    }
    
    public boolean isMaior(int hora, int minuto, int segundo) {
        int totalSeg = totalSegundos();
        Tempo outroTempo = new Tempo(hora, minuto, segundo);
        int totalSeg1 = outroTempo.totalSegundos();

        return totalSeg > totalSeg1;
    }
    
    public int isDiferençaSeg(Tempo outroTempo) {
        int totalSeg = totalSegundos();
        int totalSeg1 = outroTempo.totalSegundos();

        return Math.abs(totalSeg-totalSeg1);
    }
    
    public Tempo isDiferençaTem(Tempo outroTempo) {
        int dif = isDiferençaSeg(outroTempo);
        int s = dif % 60;
        dif = dif / 60;
        int n = dif % 60;
        int h = dif / 60;
        
        return new Tempo(h, n, s);
    }
       
    private int totalSegundos(){
        int total = (hora*3600) + (minuto*60);
        return total;
    }
}
