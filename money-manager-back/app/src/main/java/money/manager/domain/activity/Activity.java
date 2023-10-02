package money.manager.domain.activity;

import java.time.Instant;
import java.util.UUID;

import money.manager.domain.activity.type.Type.ActivityType;
import money.manager.domain.exception.DomainException;
import money.manager.utils.InstantUtils;

/**
 * Uma classe que representa uma atividade financeira em um sistema de gerenciamento financeiro.
 */
public class Activity {
    private String id;
    private Instant date;
    private String description;
    private float value;
    private ActivityType type;
    private Instant createdAt;
    private Instant updatedAt;

    private Activity(final String anId, final Instant aDate, final String aDescription,
                     final float aValue, final ActivityType aType, final Instant aCreatedAt,
                     final Instant anUpdatedAt) {
        this.id = anId;
        this.date = aDate;
        this.description = aDescription;
        this.value = aValue;
        this.type = aType;
        this.createdAt = aCreatedAt;
        this.updatedAt = anUpdatedAt;

        this.validate();
    }

    /**
     * Cria uma nova instância de atividade com valores padrão.
     *
     * @param aDate        A data da atividade.
     * @param aDescription A descrição da atividade.
     * @param aValue       O valor da atividade.
     * @param aType        O tipo da atividade.
     * @return Uma nova instância de atividade.
     */
    public static Activity newActivity(final Instant aDate, final String aDescription,
                                       final float aValue, final ActivityType aType) {
        return new Activity(
                UUID.randomUUID().toString().toLowerCase(),
                aDate,
                aDescription,
                aValue,
                aType,
                InstantUtils.now(),
                InstantUtils.now()
        );
    }

    /**
     * Cria uma instância de atividade com valores fornecidos.
     *
     * @param anId         O ID da atividade.
     * @param aDate        A data da atividade.
     * @param aDescription A descrição da atividade.
     * @param aValue       O valor da atividade.
     * @param aType        O tipo da atividade.
     * @param aCreatedAt   A data e hora de criação da atividade.
     * @param anUpdatedAt  A data e hora da última atualização da atividade.
     * @return Uma instância de atividade com valores fornecidos.
     */
    public static Activity with(final String anId, final Instant aDate, final String aDescription,
                                final float aValue, final ActivityType aType, final Instant aCreatedAt,
                                final Instant anUpdatedAt) {
        return new Activity(
                anId,
                aDate,
                aDescription,
                aValue,
                aType,
                aCreatedAt,
                anUpdatedAt);
    }

    private void validate() {
        if (this.id.isBlank()) {
            throw new DomainException("O ID da atividade não pode estar em branco");
        } else if (this.id.length() != 36) {
            throw new DomainException("O ID da atividade deve ter um UUID válido de 36 caracteres");
        } else if (this.description.isBlank()) {
            throw new DomainException("A descrição não pode estar em branco");
        } else if (this.description.length() < 3) {
            throw new DomainException("A descrição da atividade deve ter pelo menos 3 caracteres");
        } else if (this.type != ActivityType.EXPENSE && this.type != ActivityType.REVENUE) {
            throw new DomainException("O tipo de atividade deve ser de despesa ou ganho");
        } else if (this.value < 0.1) {
            throw new DomainException("O valor da atividade deve ser maior que 0");
        } else if (this.createdAt.isAfter(this.updatedAt)) {
            throw new DomainException("A data de criação da atividade deve ser anterior à data de atualização");
        }
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the date
     */
    public Instant getDate() {
        return date;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the value
     */
    public float getValue() {
        return value;
    }

    /**
     * @return the type
     */
    public ActivityType getType() {
        return type;
    }

    /**
     * @return the createdAt
     */
    public Instant getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the updatedAt
     */
    public Instant getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "Activity [id=" + id + ", date=" + date + ", description=" + description + ", value=" + value + ", type="
                + type + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

}