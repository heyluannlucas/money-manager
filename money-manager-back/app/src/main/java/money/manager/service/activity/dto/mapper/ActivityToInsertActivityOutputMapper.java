package money.manager.service.activity.dto.mapper;

import money.manager.domain.activity.Activity;
import money.manager.service.activity.dto.InsertActivityOutputDto;

import java.util.function.Function;

/**
 * Uma classe que realiza a conversão de uma instância da classe Activity para InsertActivityOutputDto.
 */
public class ActivityToInsertActivityOutputMapper implements Function<Activity, InsertActivityOutputDto> {

    /**
     * Cria uma instância de ActivityToInsertActivityOutputMapper.
     *
     * @return Uma instância de ActivityToInsertActivityOutputMapper.
     */
    public static ActivityToInsertActivityOutputMapper build(){
        return new ActivityToInsertActivityOutputMapper();
    }

    /**
     * Converte uma instância da classe Activity para InsertActivityOutputDto.
     *
     * @param input A instância de Activity a ser convertida.
     * @return Uma instância de InsertActivityOutputDto.
     */
    @Override
    public InsertActivityOutputDto apply(final Activity input) {
        return new InsertActivityOutputDto(
                input.getId(),
                input.getDate(),
                input.getDescription(),
                input.getValue(),
                input.getType().getValue(),
                input.getCreatedAt(),
                input.getUpdatedAt());
    }
}
