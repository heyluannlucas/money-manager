package money.manager.service.activity.dto.mapper;

import java.util.function.Function;

import money.manager.domain.activity.Activity;
import money.manager.service.activity.dto.ListActivitiesOutputDto;

/**
 * Uma classe que realiza a conversão de uma instância da classe Activity para ListActivitiesOutputDto.
 */
public class ActivityToListActivitiesOutputMapper implements Function<Activity, ListActivitiesOutputDto> {

    /**
     * Cria uma instância de ActivityToListActivitiesOutputMapper.
     *
     * @return Uma instância de ActivityToListActivitiesOutputMapper.
     */
    public static ActivityToListActivitiesOutputMapper build() {
        return new ActivityToListActivitiesOutputMapper();
    }

    /**
     * Converte uma instância da classe Activity para ListActivitiesOutputDto.
     *
     * @param input A instância de Activity a ser convertida.
     * @return Uma instância de ListActivitiesOutputDto.
     */
    @Override
    public ListActivitiesOutputDto apply(final Activity input) {
        return new ListActivitiesOutputDto(
                input.getId(),
                input.getDate(),
                input.getDescription(),
                input.getValue(),
                input.getType().getValue(),
                input.getCreatedAt(),
                input.getUpdatedAt());
    }
}
