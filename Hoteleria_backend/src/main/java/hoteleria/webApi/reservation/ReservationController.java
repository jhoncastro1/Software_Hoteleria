package hoteleria.webApi.reservation;

import hoteleria.commons.constans.endPoints.reservation.IReservationEndPoints;
import hoteleria.commons.domains.dto.reservation.ReservationDTO;
import hoteleria.model.entity.reservation.Reservation_Entity;
import hoteleria.services.reservation.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IReservationEndPoints.RESERVATION_BASE_URL)
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping(IReservationEndPoints.RESERVATION_CREATE_URL)
    public String createReservation(@RequestBody Reservation_Entity reservationEntity){
        System.out.println("entro a el controlador " + reservationEntity.getContact_email());
        return this.reservationService.createReservation(reservationEntity);
    }

    @DeleteMapping(IReservationEndPoints.RESERVATION_DELETE_URL)
    public String deleteReservation(@PathVariable Integer reservation_id){
        return this.reservationService.deleteReservation(reservation_id);
    }

    @PutMapping(IReservationEndPoints.RESERVATION_UPDATE_URL)
    public String updateReservation(@RequestBody ReservationDTO reservationDTO){
        return this.reservationService.updateReservation(reservationDTO);
    }

    @GetMapping(IReservationEndPoints.RESERVATION_FIND_URL)
    public String findReservation(@PathVariable Integer reservation_id){
        return this.reservationService.findReservation(reservation_id);
    }
}
