package hoteleria.commons.converter.groupInstructions;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.domains.dto.check_Out.Check_OutDTO;
import hoteleria.commons.domains.dto.groupInstructions.GroupInstructionsDTO;
import hoteleria.commons.helpers.HelperMapper;
import hoteleria.model.entity.check_out.Check_outEntity;
import hoteleria.model.entity.groupInstructions.GroupInstructionsEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class GroupInstructionsConverter {
    public GroupInstructionsEntity convertGroupInstructionsDTOToGroupInstructionsEntity(GroupInstructionsDTO groupInstructionsDTO){
        GroupInstructionsEntity GroupInstructions = new GroupInstructionsEntity();
        try {
            GroupInstructions = HelperMapper.modelMapper().map(groupInstructionsDTO, GroupInstructionsEntity.class);
        }
        catch (Exception e){
            log.error(IResponse.DOCUMENT_FAIL + e);
        }
        return GroupInstructions;
    }
}
