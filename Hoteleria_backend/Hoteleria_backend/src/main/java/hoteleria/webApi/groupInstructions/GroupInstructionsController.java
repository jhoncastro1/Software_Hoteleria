package hoteleria.webApi.groupInstructions;

import hoteleria.commons.constans.endPoints.front.IFrontHost;
import hoteleria.commons.constans.endPoints.groupInstructions.IGroupInstructionsEndPoints;
import hoteleria.commons.domains.dto.groupInstructions.GroupInstructionsDTO;
import hoteleria.model.entity.goupInstructions.GroupInstructionsEntity;
import hoteleria.services.groupInstructions.GroupInstructionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IGroupInstructionsEndPoints.GROUP_INSTRUCTIONS_BASE_URL)
@CrossOrigin(origins = IFrontHost.FRONT_URL)
public class GroupInstructionsController {

    @Autowired
    private GroupInstructionsService groupInstructionsService;

    @PostMapping(IGroupInstructionsEndPoints.GROUP_INSTRUCTIONS_CREATE_URL)
    public String createGroupInstructions(@RequestBody GroupInstructionsEntity groupInstructionsEntity){
        return this.groupInstructionsService.createGroupInstructions(groupInstructionsEntity);
    }

    @DeleteMapping(IGroupInstructionsEndPoints.GROUP_INSTRUCTIONS_DELETE_URL)
    public String deleteGroupInstructions(@PathVariable Integer groupInstructionsId){
        return this.groupInstructionsService.deleteGroupInstructions(groupInstructionsId);
    }

    @PutMapping(IGroupInstructionsEndPoints.GROUP_INSTRUCTIONS_UPDATE_URL)
    public String updateGroupInstructions(@RequestBody GroupInstructionsDTO groupInstructionsDTO){
        return this.groupInstructionsService.updateGroupInstructions(groupInstructionsDTO);
    }

    @GetMapping(IGroupInstructionsEndPoints.GROUP_INSTRUCTIONS_FIND_URL)
    public String findGroupInstructions(@PathVariable Integer groupInstructionsId){
        return this.groupInstructionsService.findGroupInstructions(groupInstructionsId);
    }
}
