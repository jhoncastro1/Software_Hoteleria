package hoteleria.commons.domains.dto.roomListGroup;

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
public class RoomListGroupDTO {
    private Integer idRoomListGroup;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate arrivalDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate departureDate;
    private String nameCustomer;
    private Integer countRoom;
    private String typeRoom;
    private String noRoom;
    private String nameStudent;

}
