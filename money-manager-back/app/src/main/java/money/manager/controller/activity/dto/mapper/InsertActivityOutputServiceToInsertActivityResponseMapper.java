package money.manager.controller.activity.dto.mapper;

import java.util.function.Function;

import money.manager.controller.activity.dto.InsertActivityResponseDto;
import money.manager.service.activity.dto.InsertActivityOutputDto;

/**
 * Um mapper que converte objetos do tipo InsertActivityOutputDto em objetos do tipo InsertActivityResponseDto.
 */
public class InsertActivityOutputServiceToInsertActivityResponseMapper
        implements Function<InsertActivityOutputDto, InsertActivityResponseDto> {

    /**
     * Construtor privado para criar uma instância do mapper.
     */
    private InsertActivityOutputServiceToInsertActivityResponseMapper() {
        // Construtor privado para evitar a criação de instâncias externas.
    }

    /**
     * Método estático para criar uma instância do mapper.
     *
     * @return Uma instância do mapper.
     */
    public static InsertActivityOutputServiceToInsertActivityResponseMapper build() {
        return new InsertActivityOutputServiceToInsertActivityResponseMapper();
    }

    /**
     * Converte um objeto do tipo InsertActivityOutputDto em um objeto do tipo InsertActivityResponseDto.
     *
     * @param input O objeto do tipo InsertActivityOutputDto a ser convertido.
     * @return Um objeto do tipo InsertActivityResponseDto convertido.
     */
    @Override
    public InsertActivityResponseDto apply(final InsertActivityOutputDto input) {
        return new InsertActivityResponseDto(
                input.id(),
                input.date(),
                input.description(),
                input.value(),
                input.type(),
                input.updatedAt(),
                input.createdAt());
    }
}
