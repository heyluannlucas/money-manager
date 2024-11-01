package money.manager.controller.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import money.manager.controller.exception.handler.body.ExceptionResponseBody;
import money.manager.domain.exception.DomainException;
import money.manager.repository.activity.exception.PersistenceException;
import money.manager.service.exception.ServiceException;
import money.manager.utils.InstantUtils;

/**
 * Uma classe que lida com exceções específicas do controlador de atividades em um sistema de gerenciamento financeiro.
 */
@ControllerAdvice("money.manager.controller.activity")
public class ActivityControllerExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Lida com exceções do tipo DomainException.
     *
     * @param anException A exceção DomainException a ser tratada.
     * @param aRequest    O objeto HttpServletRequest da solicitação que causou a exceção.
     * @return Uma resposta ResponseEntity com o corpo de exceção apropriado.
     */
    @ExceptionHandler(value = { DomainException.class })
    protected ResponseEntity<ExceptionResponseBody> handleDomainExceptions(
            final DomainException anException,
            final HttpServletRequest aRequest) {

        final var aBody = new ExceptionResponseBody(
                InstantUtils.now(),
                HttpStatus.BAD_REQUEST.value(),
                anException.getMessage(),
                aRequest.getRequestURI());

        return ResponseEntity.badRequest().body(aBody);
    }

    /**
     * Lida com exceções do tipo PersistenceException.
     *
     * @param anException A exceção PersistenceException a ser tratada.
     * @param aRequest    O objeto HttpServletRequest da solicitação que causou a exceção.
     * @return Uma resposta ResponseEntity com o corpo de exceção apropriado.
     */
    @ExceptionHandler(value = { PersistenceException.class })
    protected ResponseEntity<ExceptionResponseBody> handleDomainExceptions(
            final PersistenceException anException,
            final HttpServletRequest aRequest) {

        final var aBody = new ExceptionResponseBody(
                InstantUtils.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                anException.getMessage(),
                aRequest.getRequestURI());

        return ResponseEntity.internalServerError().body(aBody);
    }

    /**
     * Lida com exceções do tipo ServiceException.
     *
     * @param anException A exceção ServiceException a ser tratada.
     * @param aRequest    O objeto HttpServletRequest da solicitação que causou a exceção.
     * @return Uma resposta ResponseEntity com o corpo de exceção apropriado.
     */
    @ExceptionHandler(value = { ServiceException.class })
    protected ResponseEntity<ExceptionResponseBody> handleDomainExceptions(
            final ServiceException anException,
            final HttpServletRequest aRequest) {

        final var aBody = new ExceptionResponseBody(
                InstantUtils.now(),
                HttpStatus.BAD_REQUEST.value(),
                anException.getMessage(),
                aRequest.getRequestURI());

        return ResponseEntity.badRequest().body(aBody);
    }

    /**
     * Lida com exceções genéricas do tipo Exception.
     *
     * @param anException A exceção Exception a ser tratada.
     * @param aRequest    O objeto HttpServletRequest da solicitação que causou a exceção.
     * @return Uma resposta ResponseEntity com o corpo de exceção apropriado.
     */
    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<ExceptionResponseBody> handleDomainExceptions(
            final Exception anException,
            final HttpServletRequest aRequest) {

        final var aBody = new ExceptionResponseBody(
                InstantUtils.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                anException.getMessage(),
                aRequest.getRequestURI());

        return ResponseEntity.internalServerError().body(aBody);
    }
}
