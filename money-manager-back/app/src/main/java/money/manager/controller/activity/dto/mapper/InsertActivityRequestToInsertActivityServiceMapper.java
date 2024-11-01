package money.manager.controller.activity.dto.mapper;

import java.util.function.Function;

import money.manager.controller.activity.dto.InsertActivityRequestDto;
import money.manager.service.activity.dto.InsertActivityInputDto;

/**
 * Um mapper que converte objetos do tipo InsertActivityRequestDto em objetos do tipo InsertActivityInputDto.
 */
public class InsertActivityRequestToInsertActivityServiceMapper
        implements Function<InsertActivityRequestDto, InsertActivityInputDto> {

    /**
     * Construtor privado para criar uma instância do mapper.
     */
    private InsertActivityRequestToInsertActivityServiceMapper() {
        // Construtor privado para evitar a criação de instâncias externas.
    }

    /**
     * Método estático para criar uma instância do mapper.
     *
     * @return Uma instância do mapper.
     */
    public static InsertActivityRequestToInsertActivityServiceMapper build() {
        return new InsertActivityRequestToInsertActivityServiceMapper();
    }

    /**
     * Converte um objeto do tipo InsertActivityRequestDto em um objeto do tipo InsertActivityInputDto.
     *
     * @param input O objeto do tipo InsertActivityRequestDto a ser convertido.
     * @return Um objeto do tipo InsertActivityInputDto convertido.
     */
    @Override
    public InsertActivityInputDto apply(final InsertActivityRequestDto input) {

        return new InsertActivityInputDto(
                input.date(),
                input.description(),
                input.value(),
                input.type());
    }
}
