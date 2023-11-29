package hoteleria.model.entity.groupInstructions;

import com.fasterxml.jackson.annotation.JsonFormat;
import hoteleria.commons.constans.tables.ITables;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = ITables.TABLE_GROUP_INSTRUCTIONS)
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GroupInstructionsEntity {

    @Id
    @Column(name = "id_group_instructions")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer groupInstructionsId;

    @Column(name = "name_group")
    private String name_group;

    @Column(name = "name_owner_group")
    private String name_owner_group;

    @Column(name = "extra_account")
    private boolean extra_account;

    @Column(name = "master_account")
    private boolean master_account;

    @Column(name = "arrival")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate arrival;

    @Column(name = "arrival_time")
    private LocalDateTime arrival_time;

    @Column(name = "output")
    private LocalDate output;

    @Column(name = "output_time")
    private LocalDateTime output_time;

    @Column(name = "old_count")
    private Integer old_count;

    @Column(name = "young_count")
    private Integer young_count;

    @Column(name = "total")
    private double total;


    @Column(name = "simple_count")
    private Integer simple_count;


    @Column(name = "double_count")
    private Integer double_count;


    @Column(name = "twin_count")
    private Integer twin_count;


    @Column(name = "simple_paid")
    private double simple_paid;


    @Column(name = "double_paid")
    private double double_paid;


    @Column(name = "twin_paid")
    private double twin_paid;

    @Column(name = "name_student")
    private String name_student;
}
