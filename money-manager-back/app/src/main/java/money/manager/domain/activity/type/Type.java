package money.manager.domain.activity.type;

/**
 * Uma classe que define os tipos de atividades financeiras.
 */
public class Type {

    /**
     * Um enum que representa os tipos de atividades financeiras.
     */
    public enum ActivityType {

        /**
         * Representa o tipo de atividade como "receita".
         */
        REVENUE("revenue"),

        /**
         * Representa o tipo de atividade como "despesa".
         */
        EXPENSE("expense");

        private String value;

        /**
         * Construtor privado para definir o valor associado a cada tipo de atividade.
         *
         * @param aValue O valor do tipo de atividade.
         */
        ActivityType(final String aValue) {
            this.value = aValue;
        }

        /**
         * Obtém o valor associado a um tipo de atividade.
         *
         * @return O valor do tipo de atividade.
         */
        public String getValue() {
            return this.value;
        }
    }
}
