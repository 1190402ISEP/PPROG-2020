package exception;

/**
 * Representa uma exceção para ser lançada quando uma aplicação tenta introduzir
 * dados inválidos.
 *
 * @author 1190402-1191045
 */
public class DadosIntroduzidosInvalidosException extends IllegalArgumentException {

    /**
     * Constrói uma DadosIntroduzidosInvalidosException com a mensagem "Dados
     * Introduzidos Inválidos!".
     */
    public DadosIntroduzidosInvalidosException() {
        super("Dados Introduzidos Inválidos!");
    }

    /**
     * Constrói uma DadosIntroduzidosInvalidosException contendo a mensagem
     * recebida.
     *
     * @param msg a mensagem transmitida pela exceção
     */
    public DadosIntroduzidosInvalidosException(String msg) {
        super(msg);
    }
}
