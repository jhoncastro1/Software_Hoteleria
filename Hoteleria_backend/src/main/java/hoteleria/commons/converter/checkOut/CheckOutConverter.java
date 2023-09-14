package hoteleria.commons.converter.checkOut;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.domains.dto.check_Out.Check_OutDTO;
import hoteleria.commons.helpers.HelperMapper;
import hoteleria.model.entity.check_out.Check_outEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class CheckOutConverter {
    public Check_OutDTO convertCheckOutEntityToCheckOutDTO(Check_outEntity checkOutEntity){
        Check_OutDTO checkOutDTO = new Check_OutDTO();
        try{
            checkOutDTO = HelperMapper.modelMapper().map(checkOutEntity, Check_OutDTO.class);
        }
        catch (Exception e)
        {
            log.error(IResponse.DOCUMENT_FAIL + e);
        }
        return checkOutDTO;
    }

        public Check_outEntity convertCheckOutDTOToCheckOutEntity(Check_OutDTO checkOutDTO){
        Check_outEntity checkOutEntity = new Check_outEntity();
        try {
            checkOutEntity = HelperMapper.modelMapper().map(checkOutDTO, Check_outEntity.class);
        }
        catch (Exception e){
            log.error(IResponse.DOCUMENT_FAIL + e);
        }
        return checkOutEntity;
        }

}
