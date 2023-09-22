package hoteleria.commons.domains.dto.groupInstructions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@ToString
@Getter
@Setter
public class GroupInstructionsDTO {
    private Integer idGroupInstructions;
    private String nameGroup;
    private String nameOwnerGroup;
    private Boolean extraAccount;
    private Boolean masterAccount;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate arrival;
    private LocalDateTime arrivalTime;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate output;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime outputTime;
    private Integer oldCount;
    private Integer youngCount;
    private double total;
    private Integer simpleCount;
    private Integer doubleCount;
    private Integer twinCount;
    private double simplePaid;
    private double doublePaid;
    private double twinPaid;
    private String nameStudent;

}
