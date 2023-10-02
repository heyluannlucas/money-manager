package money.manager.service.activity.implementation;

import java.util.List;
import java.util.stream.Collectors;

import money.manager.domain.activity.type.Type.ActivityType;
import money.manager.domain.gateway.ActivityGateway;
import money.manager.service.activity.ActivityService;
import money.manager.service.activity.dto.InsertActivityInputDto;
import money.manager.service.activity.dto.InsertActivityOutputDto;
import money.manager.service.activity.dto.ListActivitiesOutputDto;
import money.manager.service.activity.dto.mapper.ActivityToInsertActivityOutputMapper;
import money.manager.service.activity.dto.mapper.ActivityToListActivitiesOutputMapper;
import money.manager.service.activity.dto.mapper.InsertActivityInputToActivityMapper;

/**
 * Uma classe que implementa o serviço relacionado a atividades financeiras.
 */
public class ActivityServiceImplementation implements ActivityService {

    private ActivityGateway activityGateway;

    private ActivityServiceImplementation(final ActivityGateway aGateway) {
        this.activityGateway = aGateway;
    }

    /**
     * Cria uma instância de ActivityServiceImplementation.
     *
     * @param aGateway O gateway para acessar as atividades financeiras.
     * @return Uma instância de ActivityServiceImplementation.
     */
    public static ActivityServiceImplementation build(final ActivityGateway aGateway) {
        return new ActivityServiceImplementation(aGateway);
    }

    /**
     * Insere uma nova atividade financeira com base nas informações de entrada.
     *
     * @param anInput As informações de entrada para inserir a atividade.
     * @return As informações de saída da atividade inserida.
     */
    @Override
    public InsertActivityOutputDto insertActivity(final InsertActivityInputDto anInput) {
        final var anActivity = InsertActivityInputToActivityMapper.build().apply(anInput);

        this.activityGateway.create(anActivity);

        return ActivityToInsertActivityOutputMapper.build().apply(anActivity);
    }

    /**
     * Remove uma atividade financeira com base no ID fornecido.
     *
     * @param anId O ID da atividade a ser removida.
     */
    @Override
    public void removeActivity(final String anId) {
        this.activityGateway.delete(anId);
    }

    /**
     * Lista todas as atividades financeiras.
     *
     * @return Uma lista de informações de saída das atividades financeiras.
     */
    @Override
    public List<ListActivitiesOutputDto> listActivities() {
        final var aList = this.activityGateway.findAll();

        return aList.stream()
                .map(a -> ActivityToListActivitiesOutputMapper.build()
                        .apply(a))
                .collect(Collectors.toList());
    }

    /**
     * Calcula o saldo total com base nas atividades financeiras.
     *
     * @return O saldo total.
     */
    @Override
    public float calculateBalance() {
        final var aList = this.activityGateway.findAll();

        if (aList == null || aList.size() == 0) {
            return 0;
        }

        return (float) aList.stream()
                .mapToDouble(
                        a -> a.getType() == ActivityType.REVENUE
                                ? a.getValue()
                                : -a.getValue())
                .sum();
    }
}
