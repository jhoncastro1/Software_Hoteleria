package hoteleria.commons.domains.dto.check_Out;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Date;

@Data
@Getter
@Setter
@ToString
public class Check_OutDTO implements Serializable {
    private Integer checkOutId;
    private Integer checkInId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date checkOutDate;
    private Integer guestsCount;
    private String guestFirstName;
    private String guestLastName;
    private String roomStatus;
    private Integer totalCost;
    private String finalComments;
    private String nameStudent;

}
