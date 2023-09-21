package hoteleria.commons.domains.dto.reservation;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;


@Data
@Getter
@Setter
@ToString
public class ReservationDTO {
    private Integer reservation_id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date reservation_date;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date check_in_date;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date check_out_date;
    private String contact_first_name;
    private String contact_last_name;
    private String contact_email;
    private String contact_phone;
    private Integer guests_total;
    private String reservation_status;
    private String special_requests;
    private Integer id_assigned_room;
    private Integer nightsCount;
    private boolean typeReservation;
    private String nameStudent;

}
