package hoteleria.model.entity.rackReservation;

import hoteleria.commons.constans.tables.ITables;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = ITables.TABLE_RACK_RESERVATION)
public class RackReservationEntity {

    @Id
    @Column(name = "id_rack")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rackId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "no_rooms")
    private Integer noRooms;

    @Column(name = "month")
    private Integer month;

    @Column(name = "day")
    private Integer day;
}
