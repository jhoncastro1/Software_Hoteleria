package hoteleria.webApi.check_out;

import hoteleria.commons.constans.endPoints.check_out.ICheckOutEndPoints;
import hoteleria.commons.constans.endPoints.front.IFrontHost;
import hoteleria.commons.domains.dto.check_Out.Check_OutDTO;
import hoteleria.model.entity.check_out.Check_outEntity;
import hoteleria.services.check_out.Check_outService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ICheckOutEndPoints.CHECK_OUT_BASE_URL)
@CrossOrigin(origins = IFrontHost.FRONT_URL)
public class Check_outController {

    @Autowired
    private Check_outService checkOutService;

    @PostMapping(ICheckOutEndPoints.CHECK_OUT_CREATE_URL)
    public String createCheckOut(@RequestBody Check_outEntity checkOutEntity){
        return this.checkOutService.createCheckOut(checkOutEntity);
    }

    @DeleteMapping(ICheckOutEndPoints.CHECK_OUT_DELETE_URL)
    public String deleteCheckOut(@PathVariable Integer checkOutId){
        return this.checkOutService.deleteCheckOut(checkOutId);
    }

    @PutMapping(ICheckOutEndPoints.CHECK_OUT_UPDATE_URL)
    public String updateCheckOut(@RequestBody Check_OutDTO checkOutDTO){
        return this.checkOutService.updateCheckOut(checkOutDTO);
    }

    @GetMapping(ICheckOutEndPoints.CHECK_OUT_FIND_URL)
    public String findCheckOut(@PathVariable Integer checkOutId){
        return this.checkOutService.findCheckOut(checkOutId);
    }

}
