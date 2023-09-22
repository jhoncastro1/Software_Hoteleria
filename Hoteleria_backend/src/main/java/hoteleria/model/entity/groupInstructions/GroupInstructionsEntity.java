package hoteleria.model.entity.groupInstructions;

import com.fasterxml.jackson.annotation.JsonFormat;
import hoteleria.commons.constans.tables.ITables;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@ToString
@Setter
@Getter
@Entity
@Table(name = ITables.TABLE_GROUP_INSTRUCTIONS)
public class GroupInstructionsEntity {
    @Id
    @Column(name = "id_group_instructions")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGroupInstructions;

    @Column(name = "name_group")
    private String nameGroup;

    @Column(name = "name_owner_group")
    private String nameOwnerGroup;

    @Column(name = "extra_account")
    private Boolean extraAccount;

    @Column(name = "master_account")
    private Boolean masterAccount;

    @Column(name = "arrival")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate arrival;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @Column(name = "output")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate output;

    @Column(name = "output_time")
    private LocalDateTime outputTime;

    @Column(name = "old_count")
    private Integer oldCount;

    @Column(name = "young_count")
    private Integer youngCount;

    @Column(name = "total")
    private double total;

    @Column(name = "simple_count")
    private Integer simpleCount;

    @Column(name = "double_count")
    private Integer doubleCount;

    @Column(name = "twin_count")
    private Integer twinCount;

    @Column(name = "simple_paid")
    private double simplePaid;

    @Column(name = "double_paid")
    private double doublePaid;

    @Column(name = "twin_paid")
    private double twinPaid;

    @Column(name = "name_student")
    private String nameStudent;

}
