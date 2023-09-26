package hoteleria.model.entity.reports;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Getter
@Setter
@ToString
public class ReportsEntity {
    @Id
    @Column(name = "id_report_checkin")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReport;

    @Column(name = "date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateReport;

    @Column(name = "id_assigned_room")
    private Integer assignedRoom;

    @Column(name = "id_reservation")
    private Integer idReservation;

    @Column(name = "id_checkin")
    private Integer idCheckin;

    @Column(name = "id_Checkout")
    private Integer idCheckout;

}
