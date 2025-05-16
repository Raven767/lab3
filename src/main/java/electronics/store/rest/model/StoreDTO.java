/*
 * this code is available under GNU GPL v3
 * https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package electronics.store.rest.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Магазин")
public class StoreDTO {
    @Schema(description = "Идентификатор магазина")
    private Integer id;
    @Schema(description = "Название магазина")
    private String name;
}
