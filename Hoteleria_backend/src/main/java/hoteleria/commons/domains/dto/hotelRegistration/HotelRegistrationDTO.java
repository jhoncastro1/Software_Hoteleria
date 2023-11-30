package hoteleria.commons.domains.dto.hotelRegistration;

import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;

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
    private String tel;
    private String transport;
    private Date arrive;
    private Date out;
    private String reservation;
    private String reasonForTravel;
    private String typeId;
    private String identification;
    private String oficio;
    private String empresa;
    private String telefonoEmpresa;
    private String provenance;
    private String stay;
    private String destination;
    private String signature;
    private String acceptAccommodationContract;
    private Double roomRate;

}
