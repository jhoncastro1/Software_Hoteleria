package hoteleria.webApi.outletPass;

import hoteleria.commons.constans.endPoints.outletPass.IOutletPassEndPoints;
import hoteleria.commons.constans.endPoints.recordReservations.IRecordReservationEndPoints;
import hoteleria.commons.domains.dto.outletPass.OutletPassDTO;
import hoteleria.model.entity.outletPass.OutletPassEntity;
import hoteleria.services.OutletPass.OutletPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IOutletPassEndPoints.OUTLET_PASS_BASE_URL)
public class OutletPassController {

    @Autowired
    private OutletPassService outletPassService;

    @PostMapping(IOutletPassEndPoints.OUTLET_PASS_CREATE_URL)
    public String createOutletPass(@RequestBody OutletPassEntity outletPassEntity){
        return this.outletPassService.createOutletPass(outletPassEntity);
    }

    @DeleteMapping(IOutletPassEndPoints.OUTLET_PASS_DELETE_URL)
    public String deleteOutletPass(@PathVariable Integer idOutletPass){
        return this.outletPassService.deleteOutletPass(idOutletPass);
    }

    @PutMapping(IOutletPassEndPoints.OUTLET_PASS_UPDATE_URL)
    public String updateOutletPass(@RequestBody OutletPassDTO outletPassDTO){
        return this.outletPassService.updateOutletPass(outletPassDTO);
    }

    @GetMapping(IOutletPassEndPoints.OUTLET_PASS_FIND_URL)
    public String findOutletPass(@PathVariable Integer idOutletPass){
        return this.outletPassService.findOutletPass(idOutletPass);
    }
}
