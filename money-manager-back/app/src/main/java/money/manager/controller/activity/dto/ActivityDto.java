package money.manager.controller.activity.dto;

import java.time.Instant;

/**
 * Um Objeto de Transferência de Dados (DTO) que representa uma atividade em um sistema de gerenciamento financeiro.
 */
public record ActivityDto (
        /**
         * O identificador único para a atividade.
         */
        String id,

        /**
         * A data e hora em que a atividade ocorreu.
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
        float value
){

}
