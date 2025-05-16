package electronics.store.rest;

import electronics.store.service.StoreService;
import electronics.store.rest.model.StoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/public/rest/stores")
@RequiredArgsConstructor
public class StoreRestController {
    @Autowired
    private StoreService storeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Operation(summary = "Получить перечень магазинов",
            description = "Получить перечень всех магазинов",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Успешное выполнение"),
                    @ApiResponse(responseCode = "401", description = "Требуется аутентификация"),
                    @ApiResponse(responseCode = "403", description = "Аутентификация предоставлена, но у пользователя нет доступа"),
                    @ApiResponse(responseCode = "404", description = "Ресурс не найден")
            })
    public ResponseEntity<Iterable<StoreDTO>> browse() {
        return ResponseEntity.ok(storeService.listAll());
    }

    @Operation(summary = "Удаление магазина",
            description = "Магазин может быть удален, если с ним не связаны продукты",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Успешное выполнение"),
                    @ApiResponse(responseCode = "401", description = "Требуется аутентификация"),
                    @ApiResponse(responseCode = "403", description = "Аутентификация предоставлена, но у пользователя нет доступа"),
                    @ApiResponse(responseCode = "404", description = "Ресурс не найден")
            })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id")
                       @Parameter(description = "Идентификатор магазина") Integer id) {
        storeService.delete(id);
    }

    @Operation(summary = "Создать новый магазин",
            description = "Создать новый магазин с указанным именем",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Успешное выполнение"),
                    @ApiResponse(responseCode = "401", description = "Требуется аутентификация"),
                    @ApiResponse(responseCode = "403", description = "Аутентификация предоставлена, но у пользователя нет доступа"),
                    @ApiResponse(responseCode = "404", description = "Ресурс не найден")
            })
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<StoreDTO> add(
            @Parameter(description = "Название магазина") String name) {
        return ResponseEntity.ok(storeService.add(name));
    }

    @Operation(summary = "Поиск магазина по идентификатору",
            description = "Поиск магазина по его идентификатору",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Успешное выполнение"),
                    @ApiResponse(responseCode = "401", description = "Требуется аутентификация"),
                    @ApiResponse(responseCode = "403", description = "Аутентификация предоставлена, но у пользователя нет доступа"),
                    @ApiResponse(responseCode = "404", description = "Ресурс не найден")
            })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<StoreDTO> findById(@PathVariable("id")
                                             @Parameter(description = "Идентификатор магазина") Integer id) {
        return ResponseEntity.ok(storeService.findById(id));
    }
}