package hoteleria.commons.converter.outletPass;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.domains.dto.check_In.Check_InDTO;
import hoteleria.commons.domains.dto.outletPass.OutletPassDTO;
import hoteleria.commons.helpers.HelperMapper;
import hoteleria.model.entity.check_in.Check_inEntity;
import hoteleria.model.entity.outletPass.OutletPassEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class OutletPassConverter {

    public OutletPassEntity convertOutletPassDTOToOutletPassEntity(OutletPassDTO outletPassDTO){
        OutletPassEntity outletPassEntity = new OutletPassEntity();
        try{
            outletPassEntity = HelperMapper.modelMapper().map(outletPassDTO, OutletPassEntity.class);
        }
        catch (Exception e){
            log.error(IResponse.DOCUMENT_FAIL + e);
        }
        return outletPassEntity;
    }
}
