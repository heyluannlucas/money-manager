package money.manager.repository.activity.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Uma interface que estende JpaRepository para operações de acesso a dados relacionadas às atividades financeiras.
 */
public interface ActivityJpaRepository extends JpaRepository<ActivityJpaEntity, String> {
}
