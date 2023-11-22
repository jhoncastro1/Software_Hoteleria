package hoteleria.commons.domains.dto.hotelRegistration;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@Builder
public class HotelRegistrationDTO {

    private Integer idHotelRegistration;
    private String name;
    private String nationality;
    private String direction;
    private String city;
    private String country;
    private Integer tel;
    private String transport;
    private String reservation;
    private String reasonForTravel;
    private String provenance;
    private String stay;
    private String destination;
    private String signature;
    private Integer acceptAccommodationContract;
    private Double roomRate;

}
