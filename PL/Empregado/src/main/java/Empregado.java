
/**
 *
 * @author ANTÓNIO DANIEL BARBOSA FERNANDES
 */
public class Empregado {

    private String primeiroNome;
    private String ultimoNome;
    private Data dataContrato;
    private Tempo horaEntrada;
    private Tempo horaSaida;

    private static final String PRIMEIRO_NOME_POR_OMISSAO = "";
    private static final String ULTIMO_NOME_POR_OMISSAO = "";

    public Empregado(String primeiroNome, String ultimoNome, int anoContrato, int mesContrato, int diaContrato, int horaEntrada, int minutoEntrada, int horaSaida, int minutoSaida) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.dataContrato = new Data(anoContrato, mesContrato, diaContrato);
        this.horaEntrada = new Tempo(horaEntrada, minutoEntrada);
        this.horaSaida = new Tempo(horaSaida, minutoSaida);
    }

    public Empregado(String primeiroNome, String ultimoNome, Data dataContrato, Tempo horaEntrada, Tempo horaSaida) {
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
        this.horaEntrada = new Tempo();
        this.horaSaida = new Tempo();
    }

    public Empregado(String primeiroNome, String ultimoNome) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.dataContrato = new Data();
        this.horaEntrada = new Tempo();
        this.horaSaida = new Tempo();
    }

    public Empregado() {
        this.primeiroNome = PRIMEIRO_NOME_POR_OMISSAO;
        this.ultimoNome = ULTIMO_NOME_POR_OMISSAO;
        this.dataContrato = new Data();
        this.horaEntrada = new Tempo();
        this.horaSaida = new Tempo();
    }

    //Construtor Cópia
    public Empregado(Empregado outroEmpregado) {
        this.primeiroNome = outroEmpregado.primeiroNome;
        this.ultimoNome = outroEmpregado.ultimoNome;
        this.dataContrato = new Data(outroEmpregado.getDataContrato());
        this.horaEntrada = new Tempo(outroEmpregado.getHoraEntrada());
        this.horaSaida = new Tempo(outroEmpregado.getHoraSaida());
    }

    /**
     * @return the primeiroNome
     */
    public String getPrimeiroNome() {
        return primeiroNome;
    }

    /**
     * @return the ultimoNome
     */
    public String getUltimoNome() {
        return ultimoNome;
    }

    /**
     * @return the dataContrato
     */
    public Data getDataContrato() {
        return new Data(dataContrato);
    }

    /**
     * @return the horaEntrada
     */
    public Tempo getHoraEntrada() {
        return new Tempo(horaEntrada);
    }

    /**
     * @return the horaSaida
     */
    public Tempo getHoraSaida() {
        return new Tempo(horaSaida);
    }

    /**
     * @param primeiroNome the primeiroNome to set
     */
    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    /**
     * @param ultimoNome the ultimoNome to set
     */
    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    /**
     * @param dataContrato the dataContrato to set
     */
    public void setDataContrato(Data dataContrato) {
        this.dataContrato.setData(dataContrato.getAno(), dataContrato.getMes(), dataContrato.getDia());
    }

    public void setDataContrato(int ano, int mes, int dia) {
        dataContrato.setData(ano, mes, dia);
    }

    /**
     * @param horaEntrada the horaEntrada to set
     */
    public void setHoraEntrada(Tempo horaEntrada) {
        this.horaEntrada.setTempo(horaEntrada.getHoras(), horaEntrada.getMinutos(), horaEntrada.getSegundos());
    }

    /**
     * @param horaSaida the horaSaida to set
     */
    public void setHoraSaida(Tempo horaSaida) {
        this.horaSaida.setTempo(horaSaida.getHoras(), horaSaida.getMinutos(), horaSaida.getSegundos());
    }

    @Override
    public String toString() {
        return String.format("O empregado %s %s foi contratado em %s, a hora de entrada foi: %s , a hora de saída foi: %s.", primeiroNome, ultimoNome, dataContrato, horaEntrada, horaSaida);
    }

    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Empregado outroEmpregado = (Empregado) outroObjeto;
        return primeiroNome.equalsIgnoreCase(outroEmpregado.primeiroNome)
                && ultimoNome.equalsIgnoreCase(outroEmpregado.ultimoNome)
                && dataContrato.equals(outroEmpregado.dataContrato)
                && horaEntrada.equals(outroEmpregado.horaEntrada)
                && horaSaida.equals(outroEmpregado.horaSaida);
    }

    public float calcularHorasSemanais() {
        final int NUMERO_HORAS_DO_DIA = 24;
        final int NUMERO_SEGUNDOS_DA_HORA = 3600;
        final int NUMERO_DIAS_TRABALHO_SEMANA = 5;

        int segundos = horaSaida.diferencaEmSegundos(horaEntrada);

        if (horaEntrada.isMaior(horaSaida)) {
            segundos = NUMERO_HORAS_DO_DIA * NUMERO_SEGUNDOS_DA_HORA - segundos;
        }
        return (float) segundos / NUMERO_SEGUNDOS_DA_HORA * NUMERO_DIAS_TRABALHO_SEMANA;

    }

    public int calcularAntiguidade() {
        Data dataAtual = Data.dataAtual();

        int anos = dataAtual.getAno() - dataContrato.getAno();

        if (anos > 0 && (dataContrato.getMes() > dataAtual.getMes()) || (dataContrato.getMes() == dataAtual.getMes() && dataContrato.getDia() > dataAtual.getDia())) {
            anos--;
        }

        return anos;

    }

}
