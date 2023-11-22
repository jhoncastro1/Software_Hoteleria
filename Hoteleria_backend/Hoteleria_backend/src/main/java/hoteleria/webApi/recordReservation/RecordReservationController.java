package hoteleria.webApi.recordReservation;

import hoteleria.commons.constans.endPoints.front.IFrontHost;
import hoteleria.commons.constans.endPoints.recordReservations.IRecordReservationEndPoints;
import hoteleria.commons.domains.dto.recordReservation.RecordReservationDTO;
import hoteleria.model.entity.recordReservation.RecordReservationEntity;
import hoteleria.services.recordReservation.RecordReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IRecordReservationEndPoints.BASE_RECORD_RESERVATIONS_URL)
@CrossOrigin(origins = IFrontHost.FRONT_URL)
public class RecordReservationController {
    @Autowired
    private RecordReservationService recordReservationService;

    @PostMapping(IRecordReservationEndPoints.RECORD_RESERVATIONS_CREATE_URL)
    public String createRecordReservations(@RequestBody RecordReservationEntity recordReservationEntity){
        return this.recordReservationService.createRecordReservations(recordReservationEntity);
    }

    @DeleteMapping(IRecordReservationEndPoints.RECORD_RESERVATIONS_DELETE_URL)
    public String deleteRecordReservation(@PathVariable Integer idRecord){
        return this.recordReservationService.deleteRecorReservations(idRecord);
    }

    @PutMapping(IRecordReservationEndPoints.RECORD_RESERVATIONS_UPDATE_URL)
    public String updateRecordReservations(@RequestBody RecordReservationDTO recordReservationDTO){
        return this.recordReservationService.updateRecordReservations(recordReservationDTO);
    }

    @GetMapping(IRecordReservationEndPoints.RECORD_RESERVATIONS_FIND_URL)
    public  String findRecordReservations(@PathVariable Integer idRecord){
        return this.recordReservationService.findRecordReservation(idRecord);
    }
}
