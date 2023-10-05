package hoteleria.model.entity.hotelRegistration;

import hoteleria.commons.constans.tables.ITables;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Data
@Table(name = ITables.TABLE_HOTEL_REGISTRATION)
public class HotelRegistrationEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHotelRegistration;

    @Column(name = "name")
    private String name;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "direction")
    private String direction;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
    @Column(name = "tel")
    private Integer tel;
    @Column(name = "transport")
    private String transport;
    @Column(name = "reservation")
    private String reservation;
    @Column(name = "reason_for_travel")
    private String reasonForTravel;
    @Column(name = "provenance")
    private String provenance;
    @Column(name = "stay")
    private String stay;
    @Column(name = "destination")
    private String destination;
    @Column(name = "signature")
    private String signature;
    @Column(name = "accept_accommodation_contract")
    private Integer acceptAccommodationContract;
    @Column(name = "room_rate")
    private Double roomRate;

}
