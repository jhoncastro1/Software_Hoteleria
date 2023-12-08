package hoteleria.commons.converter.pay;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.domains.dto.pay.PayDTO;
import hoteleria.commons.helpers.HelperMapper;
import hoteleria.model.entity.pay.PayEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class PayConverter {
    public PayEntity convertPayDTOToPayEntity(PayDTO payDTO){
        PayEntity payEntity = new PayEntity();
        try{
            payEntity = HelperMapper.modelMapper().map(payDTO, PayEntity.class);
        }
        catch (Exception e){
            log.error(IResponse.DOCUMENT_FAIL + e);
        }
        return payEntity;
    }
}
