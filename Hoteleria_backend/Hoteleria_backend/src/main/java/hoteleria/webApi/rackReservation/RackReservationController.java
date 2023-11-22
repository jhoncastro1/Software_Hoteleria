package hoteleria.webApi.rackReservation;

import hoteleria.commons.constans.endPoints.front.IFrontHost;
import hoteleria.commons.constans.endPoints.rackReservation.IRackReservationEndPoints;
import hoteleria.commons.domains.dto.rackReservation.RackReservationDTO;
import hoteleria.model.entity.rackReservation.RackReservationEntity;
import hoteleria.services.rackReservation.RackReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IRackReservationEndPoints.RACK_RESERVATION_BASE_URL)
@CrossOrigin(origins = IFrontHost.FRONT_URL)
public class RackReservationController {

    @Autowired
    private RackReservationService reservationService;

    @PostMapping(IRackReservationEndPoints.RACK_RESERVATION_CREATE_URL)
    public String createRackReservation(@RequestBody RackReservationEntity rackReservationEntity){
        return this.reservationService.createRackReservation(rackReservationEntity);
    }

    @DeleteMapping(IRackReservationEndPoints.RACK_RESERVATION_DELETE_URL)
    public String deleteRackReservation(@PathVariable Integer rackId){
        return this.reservationService.deleteRackReservation(rackId);
    }

    @PutMapping(IRackReservationEndPoints.RACK_RESERVATION_UPDATE_URL)
    public String updateRackReservation(@RequestBody RackReservationDTO rackReservationDTO){
        return this.reservationService.updateRackReservation(rackReservationDTO);
    }

    @GetMapping(IRackReservationEndPoints.RACK_RESERVATION_FIND_URL)
    public String findRackReservation(@PathVariable Integer rackId){
        return this.reservationService.findRackReservation(rackId);
    }

}
