package money.manager.service.activity.dto.mapper;

import com.google.common.base.Function;

import money.manager.domain.activity.Activity;
import money.manager.domain.activity.type.Type.ActivityType;
import money.manager.service.activity.dto.InsertActivityInputDto;
import money.manager.service.exception.ServiceException;

/**
 * Uma classe que realiza a conversão de uma instância da classe InsertActivityInputDto para Activity.
 */
public class InsertActivityInputToActivityMapper implements Function<InsertActivityInputDto, Activity> {

    /**
     * Cria uma instância de InsertActivityInputToActivityMapper.
     *
     * @return Uma instância de InsertActivityInputToActivityMapper.
     */
    public static InsertActivityInputToActivityMapper build() {
        return new InsertActivityInputToActivityMapper();
    }

    /**
     * Converte uma instância da classe InsertActivityInputDto para Activity.
     *
     * @param input A instância de InsertActivityInputDto a ser convertida.
     * @return Uma instância de Activity.
     * @throws ServiceException Se o tipo de atividade for inválido.
     */
    @Override
    public Activity apply(final InsertActivityInputDto input) {

        if (input.type().trim().toUpperCase().equals(ActivityType.REVENUE.toString())) {
            final var anActivity = Activity.newActivity(
                    input.date(),
                    input.description(),
                    input.value(),
                    ActivityType.REVENUE);

            return anActivity;
        } else if (input.type().trim().toUpperCase().equals(ActivityType.EXPENSE.toString())) {
            final var anActivity = Activity.newActivity(
                    input.date(),
                    input.description(),
                    input.value(),
                    ActivityType.EXPENSE);

            return anActivity;
        } else {
            throw new ServiceException("Tipo de atividade inválido");
        }

    }

}
