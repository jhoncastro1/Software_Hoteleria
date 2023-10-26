package hoteleria.commons.domains.dto.groupInstructions;

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
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@ToString
public class GroupInstructionsDTO {
    private Integer groupInstructionsId;
    private String name_group;
    private String name_owner_group;
    private boolean extra_account;
    private boolean master_account;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate arrival;
    private LocalDateTime arrival_time;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate output;
    private LocalDateTime output_time;
    private Integer old_count;
    private Integer young_count;
    private double total;
    private Integer simple_count;
    private Integer double_count;
    private Integer twin_count;
    private double simple_paid;
    private double double_paid;
    private double twin_paid;
    private String name_student;
}
