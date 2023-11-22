package hoteleria.commons.domains.dto.outletPass;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class OutletPassDTO {
    private Integer idOutletPass;
    private String nameCustomer;
    private LocalDate date;
    private Integer idAssignedRoom;
    private Integer guestsCount;
    private boolean keyRoom;
    private String cashierName;
    private String cashier;
}
