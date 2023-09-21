package hoteleria.model.entity.roomListGroup;

import com.fasterxml.jackson.annotation.JsonFormat;
import hoteleria.commons.constans.tables.ITables;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@Table(name = ITables.TABLE_ROOM_LIST_GROUP)
public class RoomListGroupEntity {

    @Id
    @Column(name = "id_room_list")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRoomListGroup;

    @Column(name = "arrival_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate arrivalDate;

    @Column(name = "departure_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate departureDate;

    @Column(name = "name_customer")
    private String nameCustomer;

    @Column(name = "count_room")
    private Integer countRoom;

    @Column(name = "type_room")
    private String typeRoom;

    @Column(name = "no_room")
    private String noRoom;

}
