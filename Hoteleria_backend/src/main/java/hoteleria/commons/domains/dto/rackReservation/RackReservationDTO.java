package hoteleria.commons.domains.dto.rackReservation;

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
    private Integer room;
    private String month;
    private Integer day;
}
