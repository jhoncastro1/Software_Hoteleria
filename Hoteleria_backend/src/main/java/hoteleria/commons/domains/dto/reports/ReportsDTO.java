package hoteleria.commons.domains.dto.reports;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Getter
@Setter
@ToString
public class ReportsDTO {
    private Integer idReport;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateReport;
    private Integer assignedRoom;
    private Integer idReservation;
    private Integer idCheckin;
    private Integer idCheckout;

}
