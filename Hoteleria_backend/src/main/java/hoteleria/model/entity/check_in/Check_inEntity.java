package hoteleria.model.entity.check_in;

import com.fasterxml.jackson.annotation.JsonFormat;
import hoteleria.commons.constans.tables.ITables;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Getter
@Setter
@ToString
@Entity
@Table(name = ITables.TABLE_CHECK_IN)
public class Check_inEntity {

    @Id
    @Column(name = "check_in_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer checkInId;

    @Column(name = "reservation_id")
    private Integer reservationId;

    @Column(name = "check_in_time")
    private LocalTime checkInTime;

    @Column(name = "check_in_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate checkInDate;

    @Column(name = "guests_count")
    private Integer guestsCounts;

    @Column(name = "guest_first_name")
    private String guestFirstName;

    @Column(name = "guest_last_name")
    private String guestLastName;

    @Column(name = "additional_comments")
    private String additionalComments;

    @Column(name = "id_assigned_room")
    private Integer idAssignedRoom;

    @Column(name = "name_student")
    private String nameStudent;

}
