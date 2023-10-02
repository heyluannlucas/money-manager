package money.manager.controller.activity.dto;

import java.time.Instant;

/**
 * Um Objeto de Transferência de Dados (DTO) que representa uma solicitação de inserção de atividade em um sistema de gerenciamento financeiro.
 */
public record InsertActivityRequestDto(
        /**
         * A data e hora da atividade.
         */
        Instant date,

        /**
         * Uma breve descrição da atividade.
         */
        String description,

        /**
         * O tipo da atividade (por exemplo, renda, despesa, etc.).
         */
        String type,

        /**
         * O valor monetário associado à atividade.
         */
        float value) {

}
