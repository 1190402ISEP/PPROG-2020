package exception;

/**
 * Representa uma exceção para ser lançada quando uma aplicação tenta introduzir
 * dados relativos a uma instancia que não foi encontrada.
 *
 * @author 1190402-1191045
 */
public class NaoEncontradoException extends Exception {

    /**
     * Constrói uma NaoEncontradoException com a mensagem "Não Encontrado!".
     */
    public NaoEncontradoException() {
        super("Não Encontrado!");
    }

    /**
     * Constrói uma NaoEncontradoException contendo a mensagem recebida.
     *
     * @param msg a mensagem transmitida pela exceção
     */
    public NaoEncontradoException(String msg) {
        super(msg);
    }
}
