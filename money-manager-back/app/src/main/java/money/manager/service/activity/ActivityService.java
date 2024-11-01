package money.manager.service.activity;

import money.manager.service.activity.dto.InsertActivityInputDto;
import money.manager.service.activity.dto.InsertActivityOutputDto;
import money.manager.service.activity.dto.ListActivitiesOutputDto;

import java.util.List;

/**
 * Uma interface que define operações relacionadas a atividades financeiras.
 */
public interface ActivityService {

    /**
     * Insere uma nova atividade financeira com base nas informações de entrada.
     *
     * @param anInput As informações de entrada para inserir a atividade.
     * @return As informações de saída da atividade inserida.
     */
    public InsertActivityOutputDto insertActivity(final InsertActivityInputDto anInput);

    /**
     * Remove uma atividade financeira com base no ID fornecido.
     *
     * @param anId O ID da atividade a ser removida.
     */
    public void removeActivity(final String anId);

    /**
     * Lista todas as atividades financeiras.
     *
     * @return Uma lista de informações de saída das atividades financeiras.
     */
    public List<ListActivitiesOutputDto> listActivities();

    /**
     * Calcula o saldo total com base nas atividades financeiras.
     *
     * @return O saldo total.
     */
    public float calculateBalance();
}
