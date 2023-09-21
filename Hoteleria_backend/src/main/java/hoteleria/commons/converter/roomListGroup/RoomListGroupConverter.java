package hoteleria.commons.converter.roomListGroup;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.domains.dto.reservation.ReservationDTO;
import hoteleria.commons.domains.dto.roomListGroup.RoomListGroupDTO;
import hoteleria.commons.helpers.HelperMapper;
import hoteleria.model.entity.reservation.Reservation_Entity;
import hoteleria.model.entity.roomListGroup.RoomListGroupEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class RoomListGroupConverter {
    public RoomListGroupEntity convertRoomListGroupDTOToRoomListGroupEntity(RoomListGroupDTO roomListGroupDTO){
        RoomListGroupEntity roomListGroupEntity = new RoomListGroupEntity();
        try {
            roomListGroupEntity = HelperMapper.modelMapper().map(roomListGroupDTO, RoomListGroupEntity.class);
        }
        catch (Exception e){
            log.error(IResponse.DOCUMENT_FAIL + e);
        }
        return roomListGroupEntity;
    }
}
