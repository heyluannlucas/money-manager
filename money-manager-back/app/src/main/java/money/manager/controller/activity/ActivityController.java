package money.manager.controller.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import money.manager.controller.activity.dto.*;
import money.manager.controller.activity.dto.mapper.*;
import money.manager.repository.activity.ActivityJpaGateway;
import money.manager.repository.activity.jpa.ActivityJpaRepository;
import money.manager.service.activity.implementation.ActivityServiceImplementation;

/**
 * Um controlador que lida com as operações relacionadas a atividades financeiras em um sistema de gerenciamento financeiro.
 */
@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityJpaRepository activityRepository;

    /**
     * Obtém a lista de atividades financeiras.
     *
     * @return Uma ResponseEntity contendo a lista de atividades.
     */
    @GetMapping
    public ResponseEntity<ListActivitiesResponseDto> listActivities() {
        // Cria um gateway e um serviço para operações com atividades.
        final var aGateway = ActivityJpaGateway.build(activityRepository);
        final var aService = ActivityServiceImplementation.build(aGateway);

        // Chama o serviço para obter a lista de atividades.
        final var aList = aService.listActivities();

        // Mapeia a lista de atividades para o formato de resposta.
        final var aResponse = ListActivitiesToListActivitiesResponseMapper
                .build()
                .apply(aList);

        return ResponseEntity.ok().body(aResponse);
    }

    /**
     * Insere uma nova atividade financeira.
     *
     * @param input Os dados da atividade a ser inserida.
     * @return Uma ResponseEntity contendo a resposta da inserção da atividade.
     */
    @PostMapping
    public ResponseEntity<InsertActivityResponseDto> insertActivity(@RequestBody InsertActivityRequestDto input) {
        // Cria um gateway e um serviço para operações com atividades.
        final var aGateway = ActivityJpaGateway.build(activityRepository);
        final var aService = ActivityServiceImplementation.build(aGateway);

        // Converte os dados da solicitação para o formato de entrada do serviço.
        final var aServiceInput = InsertActivityRequestToInsertActivityServiceMapper.build()
                .apply(input);

        // Chama o serviço para inserir a atividade.
        final var aServiceResponse = aService.insertActivity(aServiceInput);

        // Mapeia a resposta do serviço para o formato de resposta.
        final var aResponse = InsertActivityOutputServiceToInsertActivityResponseMapper.build()
                .apply(aServiceResponse);

        return ResponseEntity.ok().body(aResponse);
    }

    /**
     * Remove uma atividade financeira pelo ID.
     *
     * @param anId O ID da atividade a ser removida.
     * @return Uma ResponseEntity indicando o resultado da remoção.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivityById(@PathVariable("id") final String anId) {
        // Cria um gateway e um serviço para operações com atividades.
        final var aGateway = ActivityJpaGateway.build(activityRepository);
        final var aService = ActivityServiceImplementation.build(aGateway);

        // Chama o serviço para remover a atividade.
        aService.removeActivity(anId);

        return ResponseEntity.noContent().build();
    }

    /**
     * Calcula o saldo das atividades financeiras.
     *
     * @return Uma ResponseEntity contendo o saldo calculado.
     */
    @GetMapping("/balance")
    public ResponseEntity<CalculateBalanceResponseDto> calculateBalance() {
        // Cria um gateway e um serviço para operações com atividades.
        final var aGateway = ActivityJpaGateway.build(activityRepository);
        final var aService = ActivityServiceImplementation.build(aGateway);

        // Chama o serviço para calcular o saldo.
        final var aServiceResponse = aService.calculateBalance();

        // Mapeia a resposta do serviço para o formato de resposta.
        final var aResponse = new CalculateBalanceResponseDto(aServiceResponse);

        return ResponseEntity.ok().body(aResponse);
    }
}
