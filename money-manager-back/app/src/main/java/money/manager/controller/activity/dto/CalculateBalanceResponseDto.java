package money.manager.controller.activity.dto;

/**
 * Um Objeto de Transferência de Dados (DTO) que representa a resposta para o cálculo de saldo em um sistema de gerenciamento financeiro.
 */
public record CalculateBalanceResponseDto(
        /**
         * O saldo calculado.
         */
        float balance) {

}
