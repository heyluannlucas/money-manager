package money.manager.service.exception;

/**
 * Uma exceção personalizada para representar erros relacionados a serviços.
 */
public class ServiceException extends RuntimeException {

    /**
     * Cria uma nova instância de ServiceException com a mensagem de erro especificada.
     *
     * @param aMessage A mensagem de erro que descreve a exceção.
     */
    public ServiceException(final String aMessage) {
        super(aMessage);
    }
}
