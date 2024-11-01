package money.manager.controller.activity.dto;

import java.util.List;

/**
 * Um Objeto de Transferência de Dados (DTO) que representa a resposta de listagem de atividades em um sistema de gerenciamento financeiro.
 */
public record ListActivitiesResponseDto (
        /**
         * Uma lista de objetos ActivityDto representando as atividades listadas.
         */
        List<ActivityDto> activities
){

}
