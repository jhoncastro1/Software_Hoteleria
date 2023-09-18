package hoteleria.commons.converter.reservation;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.domains.dto.reservation.ReservationDTO;
import hoteleria.commons.helpers.HelperMapper;
import hoteleria.model.entity.reservation.Reservation_Entity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ReservationConverter {

    public ReservationDTO convertReservationEntityToReservationDTO(Reservation_Entity reservationEntity){
        ReservationDTO reservationDTO = new ReservationDTO();
        try {
            reservationDTO = HelperMapper.modelMapper().map(reservationEntity, ReservationDTO.class);
        }
        catch (Exception e){
            log.error(IResponse.DOCUMENT_FAIL + e);
        }
        return reservationDTO;
    }

    public Reservation_Entity convertReservationDTOToReservationEntity(ReservationDTO reservationDTO){
        Reservation_Entity reservationEntity = new Reservation_Entity();
        try {
            reservationEntity = HelperMapper.modelMapper().map(reservationDTO, Reservation_Entity.class);
        }
        catch (Exception e){
            log.error(IResponse.DOCUMENT_FAIL + e);
        }
        return reservationEntity;
    }

}
