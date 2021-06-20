package exception;

/**
 * Representa uma exceção para ser lançada quando uma aplicação tenta
 * criar/modificar uma instância de Data para representar um dia inválido.
 *
 * @author 1190402-1191045
 */
public class DiaInvalidoException extends Exception {

    /**
     * Constrói uma DiaInvalidoException com a mensagem "Dia é inválido!".
     */
    public DiaInvalidoException() {
        super("Dia é inválido!!");
    }

    /**
     * Constrói uma DiaInvalidoException contendo a mensagem recebida.
     *
     * @param mensagem a mensagem transmitida pela exceção
     */
    public DiaInvalidoException(String mensagem) {
        super(mensagem);
    }
}
