package Tempo;

public class tempoMain {

    public static void main(String[] args) {
        Tempo t1 = new Tempo(15, 22, 48);
        Tempo t2 = new Tempo(16, 22, 48);
        
        System.out.println(t1);
        System.out.println(t1.toStringAMPM());
        
        t1.aumentarSeg();
        
        System.out.println(t1);
        
        System.out.println(t1.isMaior(t2));
        System.out.println(t1.isMaior(14, 22, 48));
        
        System.out.println(t1.isDiferençaSeg(t2) + " segundos");
        System.out.println(t1.isDiferençaTem(t2));
    }
}
