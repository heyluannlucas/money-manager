package money.manager.repository.activity.exception;

/**
 * Uma exceção personalizada que representa exceções relacionadas à persistência de dados em um sistema.
 */
public class PersistenceException extends RuntimeException {

    /**
     * Cria uma nova instância de PersistenceException com uma mensagem de erro.
     *
     * @param aMessage A mensagem de erro que descreve a exceção.
     */
    public PersistenceException(final String aMessage) {
        super(aMessage);
    }
}
