package hoteleria.webApi.check_in;

import hoteleria.commons.constans.endPoints.check_in.ICheckInEndPoints;
import hoteleria.commons.domains.dto.check_In.Check_InDTO;
import hoteleria.commons.domains.dto.check_In.IForm;
import hoteleria.model.entity.check_in.Check_inEntity;
import hoteleria.services.check_in.Check_inService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ICheckInEndPoints.CHECK_IN_BASE_URL)
public class Check_inController {

    @Autowired
    private Check_inService checkInService;


    @GetMapping(ICheckInEndPoints.CHECK_IN_FIND_ALL_URL)
    public List<Check_inEntity> getAllCheckIns() {
        return checkInService.getAllCheckIns();
    }

    @PostMapping(ICheckInEndPoints.CHECK_IN_CREATE_URL)
    public String createCheckIn(@RequestBody Check_inEntity checkInEntity){
        return this.checkInService.addCheckIn(checkInEntity);
    }

    @DeleteMapping(ICheckInEndPoints.CHECK_IN_DELETE_URL)
    public String deleteCheckIn(@PathVariable Integer checkInId){
        return this.checkInService.deleteCheckIn(checkInId);
    }

    @PutMapping(ICheckInEndPoints.CHECK_IN_UPDATE_URL)
    public String updateCheckIn(@RequestBody Check_InDTO checkInDTO){
        return this.checkInService.updateCheckIn(checkInDTO);
    }

    @GetMapping(ICheckInEndPoints.CHECK_IN_GET_URL)
    public String findCheckIn(@PathVariable Integer checkInId){
        return this.checkInService.findCheckIn(checkInId);
    }

    @GetMapping("/custom")
    public List<IForm> customFind(){
        return this.checkInService.customFind();
    }
}
