package money.manager.domain.gateway;

import money.manager.domain.activity.Activity;

import java.util.List;

/**
 * Uma interface que define operações para acessar atividades financeiras em um sistema de gerenciamento financeiro.
 */
public interface ActivityGateway {

    /**
     * Cria uma nova atividade financeira.
     *
     * @param anActivity A atividade a ser criada.
     */
    void create(final Activity anActivity);

    /**
     * Remove uma atividade financeira pelo ID.
     *
     * @param anId O ID da atividade a ser removida.
     */
    void delete(final String anId);

    /**
     * Obtém uma lista de todas as atividades financeiras.
     *
     * @return Uma lista de todas as atividades financeiras no sistema.
     */
    List<Activity> findAll();
}
