package money.manager.utils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * Uma classe utilitária para operações relacionadas a objetos Instant.
 */
public class InstantUtils {

    /**
     * Obtém o valor atual da data e hora até microssegundos.
     *
     * @return O valor atual da data e hora.
     */
    public static Instant now() {
        return Instant.now().truncatedTo(ChronoUnit.MICROS);
    }
}
