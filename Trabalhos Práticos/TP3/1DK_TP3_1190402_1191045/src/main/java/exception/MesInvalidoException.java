package exception;

/**
 * Representa uma exceção para ser lançada quando uma aplicação tenta
 * criar/modificar uma instância de Data para representar um dia cujo mês é
 * inválido.
 *
 * @author 1190402-1191045
 */
public class MesInvalidoException extends Exception {

    /**
     * Constrói uma MesInvalidoException com a mensagem "Mês é inválido!".
     */
    public MesInvalidoException() {
        super("Mês é inválido!!");
    }

    /**
     * Constrói uma MesInvalidoException contendo a mensagem recebida.
     *
     * @param mensagem a mensagem transmitida pela exceção
     */
    public MesInvalidoException(String mensagem) {
        super(mensagem);
    }
}
