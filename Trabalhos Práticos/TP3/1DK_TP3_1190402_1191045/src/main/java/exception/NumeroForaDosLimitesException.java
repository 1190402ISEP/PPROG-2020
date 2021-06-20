package exception;

/**
 * Representa uma exceção para ser lançada quando uma aplicação tenta introduzir
 * um número fora dos limites estipulados.
 *
 * @author 1190402-1191045
 */
public class NumeroForaDosLimitesException extends Exception {

    /**
     * Constrói uma NumeroForaDosLimitesException com a mensagem "Nº Fora Dos
     * Limites!".
     */
    public NumeroForaDosLimitesException() {
        super("Nº Fora Dos Limites!");
    }

    /**
     * Constrói uma NumeroForaDosLimitesException contendo a mensagem recebida.
     *
     * @param msg a mensagem transmitida pela exceção
     */
    public NumeroForaDosLimitesException(String msg) {
        super(msg);
    }
}
