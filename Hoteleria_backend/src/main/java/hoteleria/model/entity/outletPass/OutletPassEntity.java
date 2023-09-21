package hoteleria.model.entity.outletPass;

import com.fasterxml.jackson.annotation.JsonFormat;
import hoteleria.commons.constans.tables.ITables;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@Entity
@Table(name = ITables.TABLE_OUTLET_PASS)
public class OutletPassEntity {

    @Id
    @Column(name = "id_outlet_pass")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOutletPass;

    @Column(name = "name_customer")
    private String nameCustomer;

    @Column(name = "date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Column(name = "id_assigned_room")
    private Integer idAssignedRoom;

    @Column(name = "guests_count")
    private Integer guestsCount;

    @Column(name = "key_room")
    private boolean keyRoom;

    @Column(name = "name_student")
    private String nameStudent;

}
