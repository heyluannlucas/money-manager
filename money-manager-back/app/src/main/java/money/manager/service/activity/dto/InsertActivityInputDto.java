package money.manager.service.activity.dto;

import java.time.Instant;

/**
 * Um registro de dados que representa as informações de entrada para inserir uma atividade.
 */
public record InsertActivityInputDto (
        Instant date,
        String description,
        float value,
        String type) {

    // Construtor automático, getters e métodos equals e hashCode são gerados automaticamente
}
