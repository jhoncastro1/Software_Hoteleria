package hoteleria.commons.domains.dto.rackReservation;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class RackReservationDTO {
    private Integer rackId;
    private String companyName;
    private Integer noRooms;
    private Integer month;
    private Integer day;
    private String nameStudent;

}
