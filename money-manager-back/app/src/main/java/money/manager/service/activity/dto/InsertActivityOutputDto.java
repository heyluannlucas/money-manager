package money.manager.service.activity.dto;

import java.time.Instant;

/**
 * Um registro de dados que representa as informações de saída após a inserção de uma atividade.
 */
public record InsertActivityOutputDto (
        String id,
        Instant date,
        String description,
        float value,
        String type,
        Instant createdAt,
        Instant updatedAt) {

    // Construtor automático, getters e métodos equals e hashCode são gerados automaticamente
}
