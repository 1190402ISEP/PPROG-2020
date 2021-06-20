package empregado;

import Utilitarios.Data;
import Utilitarios.Tempo;

/**
 *
 * @author Pedro
 */
public class Empregado {

    private String primeiroNome;
    private String ultimoNome;
    private Data dataContrato;
    private Tempo horaEntrada;
    private Tempo horaSaida;

    private final String PRIMEIRO_NOME_POR_OMISSAO = "Sem nome";
    private final String ULTIMO_NOME_POR_OMISSAO = "Sem nome";
    
    
    public Empregado(String primeiroNome, String ultimoNome, int anoContrato,
            int mesContrato, int diaContrato, int horaEntrada,
            int minutoEntrada, int horaSaida, int minutoSaida) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.dataContrato = new Data(anoContrato, mesContrato, diaContrato);
        this.horaEntrada = new Tempo(horaEntrada, minutoEntrada);
        this.horaSaida = new Tempo(horaSaida, minutoSaida);
    }

    public Empregado(String primeiroNome, String ultimoNome, Data dataContrato,
            Tempo horaEntrada, Tempo horaSaida) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.dataContrato = new Data(dataContrato);
        this.horaEntrada = new Tempo(horaEntrada);
        this.horaSaida = new Tempo(horaSaida);
    }
    
    public Empregado(String primeiroNome, String ultimoNome, Data dataContrato) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.dataContrato = new Data(dataContrato);
        horaEntrada = new Tempo();
        horaSaida = new Tempo();
    }

    public Empregado(String primeiroNome, String ultimoNome) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        dataContrato = new Data();
        horaEntrada = new Tempo();
        horaSaida = new Tempo();
    }
    
    public Empregado() {
        primeiroNome = PRIMEIRO_NOME_POR_OMISSAO;
        ultimoNome = ULTIMO_NOME_POR_OMISSAO;
        dataContrato = new Data();
        horaEntrada = new Tempo();
        horaSaida = new Tempo();
    }
    
    public Empregado(Empregado outroEmpregado) {
        primeiroNome = outroEmpregado.primeiroNome;
        ultimoNome = outroEmpregado.ultimoNome;
        dataContrato = new Data(outroEmpregado.dataContrato);
        horaEntrada = new Tempo(outroEmpregado.horaEntrada);
        horaSaida = new Tempo(outroEmpregado.horaSaida);
    }
    
    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public Data getDataContrato() {
        return new Data(dataContrato);
    }

    public Tempo getHoraEntrada() {
        return new Tempo(horaEntrada);
    }

    public Tempo getHoraSaida() {
        return new Tempo(horaSaida);
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public void setDataContrato(Data dataContrato) {
        this.dataContrato.setData(dataContrato.getAno(), dataContrato.getMes(), dataContrato.getDia());
    }

    public void setDataContrato(int ano, int mes, int dia) {
        this.dataContrato.setData(ano, mes, dia);
    }
    
    public void setHoraEntrada(Tempo horaEntrada) {
        this.horaEntrada.setTempo(horaEntrada.getHoras(), horaEntrada.getMinutos(), horaEntrada.getSegundos());
    }

    public void setHoraSaida(Tempo horaSaida) {
        this.horaSaida.setTempo(horaSaida.getHoras(), horaSaida.getMinutos(), horaSaida.getSegundos());
    }

    @Override
    public String toString() {
        return String.format("%s %s, contratado a %s, entra às %s e sai às %s.", this.primeiroNome, this.ultimoNome, this.dataContrato, this.horaEntrada, this.horaSaida);
    }
    
    @Override
    public boolean equals(Object outroObjeto){
        if (this == outroObjeto){
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Empregado outroEmpregado =(Empregado) outroObjeto;
        return primeiroNome.equalsIgnoreCase(outroEmpregado.primeiroNome)
                && ultimoNome.equalsIgnoreCase(outroEmpregado.ultimoNome)
                && dataContrato.equals(outroEmpregado.dataContrato)
                && horaEntrada.equals(outroEmpregado.horaEntrada)
                && horaSaida.equals(outroEmpregado.horaSaida);
    }
    
    public float calcularHorasSemanais(){
        final int NUMERO_HORAS_DO_DIA = 24;
        final int NUMERO_SEGUNDOS_DA_HORA = 3600;
        final int NUMERO_DIAS_TRABALHO_SEMANA = 5;
        
        int segundos = horaSaida.diferencaEmSegundos(horaEntrada);
        if (horaEntrada.isMaior(horaSaida)){
            segundos = NUMERO_HORAS_DO_DIA * NUMERO_SEGUNDOS_DA_HORA - segundos;
        }
        return (float) segundos / NUMERO_SEGUNDOS_DA_HORA * NUMERO_DIAS_TRABALHO_SEMANA;
    }
    
    public int calcularAntiguidade(){
        Data dataAtual = Data.dataAtual();
        
        int anos = dataAtual.getAno() - dataContrato.getAno();
        if (anos > 0 && (dataContrato.getMes() > dataAtual.getMes()
                || (dataContrato.getMes() == dataAtual.getMes() && dataContrato.getDia()
                > dataAtual.getDia()))) {
            anos--;
        }
        return anos;
    }
    
    public int determinarHorasTrabalho() {
        return (this.horaEntrada.diferencaEmSegundos(this.horaSaida) * 5) / 3600;
    }

    public int determinarTempoEmpregado() {
        return this.dataContrato.diferenca(Data.dataAtual());
    }

}
