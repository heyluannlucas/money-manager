package money.manager.repository.activity;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.OptimisticLockingFailureException;

import jakarta.persistence.PersistenceException;
import money.manager.domain.activity.Activity;
import money.manager.domain.gateway.ActivityGateway;
import money.manager.repository.activity.jpa.ActivityJpaEntity;
import money.manager.repository.activity.jpa.ActivityJpaRepository;

/**
 * Uma implementação de ActivityGateway que usa o Spring Data JPA para acessar atividades financeiras.
 */
public class ActivityJpaGateway implements ActivityGateway {

    private ActivityJpaRepository activityRepository;

    private ActivityJpaGateway(final ActivityJpaRepository aRepository) {
        this.activityRepository = aRepository;
    }

    /**
     * Cria uma instância de ActivityJpaGateway com o repositório JPA fornecido.
     *
     * @param aRepository O repositório JPA a ser usado para acessar atividades financeiras.
     * @return Uma instância de ActivityJpaGateway.
     */
    public static ActivityJpaGateway build(final ActivityJpaRepository aRepository) {
        return new ActivityJpaGateway(aRepository);
    }

    @Override
    public void create(final Activity anActivity) {
        final var anActivityEntity = ActivityJpaEntity.from(anActivity);

        try {
            this.activityRepository.save(anActivityEntity);
        } catch (IllegalArgumentException e) {
            throw new PersistenceException(e.getMessage());
        } catch (OptimisticLockingFailureException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(final String anId) {
        try {
            this.activityRepository.deleteById(anId);
        } catch (IllegalArgumentException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Activity> findAll() {
        final var aList = this.activityRepository.findAll();

        return aList.stream()
                .map(activityEntity -> activityEntity.toModel())
                .collect(Collectors.toList());
    }
}
