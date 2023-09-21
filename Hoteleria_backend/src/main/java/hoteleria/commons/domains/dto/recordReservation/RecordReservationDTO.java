package hoteleria.commons.domains.dto.recordReservation;

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
public class RecordReservationDTO {
    private Integer idRecord;
    private String fullName;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate arrivalDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate departureDate;
    private String typeRoom;
    private Integer guestsCount;
    private double deposit;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate deadlineDate;
    private double rate;
    private Integer receiptNumber;
    private String nameEmploye;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private String remarks;
    private String nameStudent;

}
