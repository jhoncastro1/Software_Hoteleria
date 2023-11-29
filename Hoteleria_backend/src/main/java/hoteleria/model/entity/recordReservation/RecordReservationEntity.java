package hoteleria.model.entity.recordReservation;


import com.fasterxml.jackson.annotation.JsonFormat;
import hoteleria.commons.constans.tables.ITables;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = ITables.TABLE_RECORD_RESERVATIONS)
public class RecordReservationEntity {

    @Id
    @Column(name = "id_record")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRecord;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Column(name = "direction")
    private String direction;

    @Column(name = "phone")
    private String phone;

    @Column(name = "reservation")
    private Integer reservation;

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @Column(name = "type_room")
    private String typeRoom;

    @Column(name = "guests_count")
    private Integer guestsCount;

    @Column(name = "deposit")
    private double deposit;

    @Column(name = "deadline_date")
    private LocalDate deadlineDate;

    @Column(name = "rate")
    private double rate;

    @Column(name = "receipt_number")
    private Integer receiptNumber;

    @Column(name = "name_employe")
    private String nameEmploye;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "remarks")
    private String remarks;
}
