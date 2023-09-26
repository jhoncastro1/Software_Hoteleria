package hoteleria.model.entity.check_out;
import com.fasterxml.jackson.annotation.JsonFormat;
import hoteleria.commons.constans.tables.ITables;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Data
@Getter
@Setter
@ToString
@Entity
@Table(name = ITables.TABLE_CHECK_OUT)
public class Check_outEntity {

    @Id
    @Column(name = "check_out_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer checkOutId;

    @Column(name = "check_in_id")
    private Integer checkInId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "check_out_date")
    private Date checkOutDate;

    @Column(name = "guests_count")
    private Integer guestsCount;

    @Column(name = "guest_first_name")
    private String guestFirstName;

    @Column(name = "guest_last_name")
    private String guestLastName;

    @Column(name = "room_status")
    private String roomStatus;

    @Column(name = "total_cost")
    private Integer totalCost;

    @Column(name = "final_comments")
    private String finalComments;

    @Column(name = "name_student")
    private String nameStudent;

}
