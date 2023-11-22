package hoteleria.commons.converter.hotelRegistration;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.domains.dto.hotelRegistration.HotelRegistrationDTO;
import hoteleria.commons.helpers.HelperMapper;
import hoteleria.model.entity.check_out.Check_outEntity;
import hoteleria.model.entity.hotelRegistration.HotelRegistrationEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class HotelRegistrationConverter {
    public HotelRegistrationEntity convertHotelRegistrationDTOToHotelRegistrationEntity(HotelRegistrationDTO hotelRegistrationDTO){
        HotelRegistrationEntity hotelRegistrationEntity = new HotelRegistrationEntity();
        try {
            hotelRegistrationEntity = HelperMapper.modelMapper().map(hotelRegistrationDTO, HotelRegistrationEntity.class);
        }
        catch (Exception e){
            log.error(IResponse.DOCUMENT_FAIL + e);
        }
        return hotelRegistrationEntity;
    }
}
