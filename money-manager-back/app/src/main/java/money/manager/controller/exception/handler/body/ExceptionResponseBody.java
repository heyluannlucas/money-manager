package money.manager.controller.exception.handler.body;

import java.time.Instant;

/**
 * Um objeto que representa o corpo de uma resposta de exceção em um controlador.
 */
public record ExceptionResponseBody(
        /**
         * O carimbo de data e hora em que a exceção ocorreu.
         */
        Instant timestamp,

        /**
         * O código de status HTTP da resposta.
         */
        Integer status,

        /**
         * A mensagem de erro associada à exceção.
         */
        String error,

        /**
         * O caminho da solicitação que levou à exceção.
         */
        String path) {

}
