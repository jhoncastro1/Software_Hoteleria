package hoteleria.commons.converter.recordReservation;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.domains.dto.rackReservation.RackReservationDTO;
import hoteleria.commons.domains.dto.recordReservation.RecordReservationDTO;
import hoteleria.commons.helpers.HelperMapper;
import hoteleria.model.entity.rackReservation.RackReservationEntity;
import hoteleria.model.entity.recordReservation.RecordReservationEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class RecordReservationConverter {
    public RecordReservationEntity convertRecordReservationDTOToRecordReservationEntity(RecordReservationDTO recordReservationDTO){
        RecordReservationEntity recordReservationEntity = new RecordReservationEntity();
        try {
            recordReservationEntity = HelperMapper.modelMapper().map(recordReservationDTO, RecordReservationEntity.class);
        }
        catch (Exception e){
            log.error(IResponse.DOCUMENT_FAIL + e);
        }
        return recordReservationEntity;
    }

}
