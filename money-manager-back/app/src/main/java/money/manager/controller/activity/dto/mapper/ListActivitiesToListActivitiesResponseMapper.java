package money.manager.controller.activity.dto.mapper;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import money.manager.controller.activity.dto.ActivityDto;
import money.manager.controller.activity.dto.ListActivitiesResponseDto;
import money.manager.service.activity.dto.ListActivitiesOutputDto;

/**
 * Um mapper que converte uma lista de objetos do tipo ListActivitiesOutputDto em um objeto do tipo ListActivitiesResponseDto.
 */
public class ListActivitiesToListActivitiesResponseMapper implements
        Function<List<ListActivitiesOutputDto>, ListActivitiesResponseDto> {

    /**
     * Construtor privado para criar uma instância do mapper.
     */
    private ListActivitiesToListActivitiesResponseMapper() {
        // Construtor privado para evitar a criação de instâncias externas.
    }

    /**
     * Método estático para criar uma instância do mapper.
     *
     * @return Uma instância do mapper.
     */
    public static ListActivitiesToListActivitiesResponseMapper build() {
        return new ListActivitiesToListActivitiesResponseMapper();
    }

    /**
     * Converte uma lista de objetos do tipo ListActivitiesOutputDto em um objeto do tipo ListActivitiesResponseDto.
     *
     * @param input A lista de objetos do tipo ListActivitiesOutputDto a ser convertida.
     * @return Um objeto do tipo ListActivitiesResponseDto convertido.
     */
    @Override
    public ListActivitiesResponseDto apply(final List<ListActivitiesOutputDto> input) {
        final var activityList = input.stream()
                .map(a -> new ActivityDto(
                        a.id(),
                        a.date(),
                        a.description(),
                        a.type(),
                        a.value()))
                .collect(Collectors.toList());

        return new ListActivitiesResponseDto(activityList);
    }
}
