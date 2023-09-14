package hoteleria.commons.converter.checkIn;


import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.domains.dto.check_In.Check_InDTO;
import hoteleria.commons.helpers.HelperMapper;
import hoteleria.model.entity.check_in.Check_inEntity;
import jakarta.persistence.Convert;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class CheckInConverter {


    public Check_InDTO convertCheckInEntityToCheckInDTO(Check_inEntity checkInEntity){
        Check_InDTO checkInDTO = new Check_InDTO();
        try{
            checkInDTO = HelperMapper.modelMapper().map(checkInEntity, Check_InDTO.class);
        }
        catch (Exception e)
        {
            log.error(IResponse.DOCUMENT_FAIL + e);
        }
        return checkInDTO;
    }

    public Check_inEntity convertCheckInDTOToCheckInEntity(Check_InDTO checkInDTO){
        Check_inEntity checkInEntity = new Check_inEntity();
        try{
            checkInEntity = HelperMapper.modelMapper().map(checkInDTO, Check_inEntity.class);
        }
        catch (Exception e){
            log.error(IResponse.DOCUMENT_FAIL + e);
        }
        return checkInEntity;
    }

}
