package hoteleria.commons.domains.dto.recordReservation;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class RecordReservationDTO {
    private Integer idRecord;
    private String fullName;
    private LocalDate arrivalDate;
    private String direction;
    private String phone;
    private Integer reservation;
    private LocalDate departureDate;
    private String typeRoom;
    private Integer guestsCount;
    private double deposit;
    private LocalDate deadlineDate;
    private double rate;
    private Integer receiptNumber;
    private String nameEmploye;
    private LocalDate date;
    private String remarks;
}
