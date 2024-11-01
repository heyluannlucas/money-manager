package money.manager.domain.exception;

/**
 * Uma exceção personalizada que representa exceções específicas do domínio em um sistema.
 */
public class DomainException extends RuntimeException {

    /**
     * Cria uma nova instância de DomainException com uma mensagem de erro.
     *
     * @param aMessage A mensagem de erro que descreve a exceção.
     */
    public DomainException(final String aMessage) {
        super(aMessage);
    }
}
