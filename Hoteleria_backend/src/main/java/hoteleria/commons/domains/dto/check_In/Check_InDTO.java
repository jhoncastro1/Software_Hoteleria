package hoteleria.commons.domains.dto.check_In;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalTime;

@Data
@Getter
@Setter
@ToString
public class Check_InDTO implements Serializable {
    private Integer checkInId;
    private Integer reservationId;
    private LocalTime checkInTime;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date checkInDate;
    private Integer guestsCounts;
    private String guestFirstName;
    private String guestLastName;
    private String additionalComments;
    private Integer idAssignedRoom;
}
