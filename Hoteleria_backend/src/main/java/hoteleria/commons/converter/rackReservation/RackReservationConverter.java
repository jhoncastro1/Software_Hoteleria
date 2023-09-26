package hoteleria.commons.converter.rackReservation;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.domains.dto.rackReservation.RackReservationDTO;
import hoteleria.commons.helpers.HelperMapper;
import hoteleria.model.entity.rackReservation.RackReservationEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class RackReservationConverter {
        public RackReservationEntity convertRackReservationDTOToRackReservationEntity(RackReservationDTO rackReservationDTO){
        RackReservationEntity rackReservationEntity = new RackReservationEntity();
        try {
            rackReservationEntity = HelperMapper.modelMapper().map(rackReservationDTO, RackReservationEntity.class);
        }
        catch (Exception e){
            log.error(IResponse.DOCUMENT_FAIL + e);
        }
        return rackReservationEntity;
    }

}
