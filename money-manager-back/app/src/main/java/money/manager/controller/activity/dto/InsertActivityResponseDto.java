package money.manager.controller.activity.dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Um Objeto de Transferência de Dados (DTO) que representa a resposta de inserção de atividade em um sistema de gerenciamento financeiro.
 */
public record InsertActivityResponseDto(
        /**
         * O identificador único da atividade inserida.
         */
        String id,

        /**
         * A data e hora da atividade.
         */
        Instant date,

        /**
         * Uma breve descrição da atividade.
         */
        String description,

        /**
         * O valor monetário associado à atividade.
         */
        float value,

        /**
         * O tipo da atividade (por exemplo, renda, despesa, etc.).
         */
        String type,

        /**
         * A data e hora de criação da atividade.
         */
        @JsonProperty("created_at")
        Instant createdAt,

        /**
         * A data e hora da última atualização da atividade.
         */
        @JsonProperty("updated_at")
        Instant updatedAt) {

}
