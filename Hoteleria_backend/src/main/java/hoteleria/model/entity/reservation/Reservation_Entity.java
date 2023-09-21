package hoteleria.model.entity.reservation;

import com.fasterxml.jackson.annotation.JsonFormat;
import hoteleria.commons.constans.tables.ITables;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = ITables.TABLE_RESERVATIONS)
public class Reservation_Entity {

    @Id
    @Column(name = "reservation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservation_id;

    @Column(name = "reservation_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date reservation_date;

    @Column(name = "check_in_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date check_in_date;

    @Column(name = "check_out_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date check_out_date;

    @Column(name = "contact_first_name")
    private String contact_first_name;

    @Column(name = "contact_last_name")
    private String contact_last_name;

    @Column(name = "contact_email")
    private String contact_email;

    @Column(name = "contact_phone")
    private String contact_phone;

    @Column(name = "guests_total")
    private Integer guests_total;

    @Column(name = "reservation_status")
    private String reservation_status;

    @Column(name = "special_requests")
    private String special_requests;

    @Column(name = "id_assigned_room")
    private Integer id_assigned_room;

    @Column(name = "nights_count")
    private Integer nightsCount;

    @Column(name = "type_reservation")
    private boolean typeReservation;

    @Column(name = "name_student")
    private String nameStudent;

}
