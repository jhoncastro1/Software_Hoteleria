package hoteleria.webApi.reservation;

import hoteleria.model.entity.reservation.Reservation_Entity;
import hoteleria.services.reservation.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/create")
    public String createReservation(@RequestBody Reservation_Entity reservationEntity){
        System.out.println("entro a el controlador " + reservationEntity.getContact_email());
        return this.reservationService.createReservation(reservationEntity);
    }

    @DeleteMapping("/delete/{reservation_id}")
    public String deleteReservation(@PathVariable Integer reservation_id){
        return this.reservationService.deleteReservation(reservation_id);
    }

    @PutMapping("/update")
    public String updateReservation(@RequestBody Reservation_Entity reservationEntity){
        return this.reservationService.updateReservation(reservationEntity);
    }

    @GetMapping("/buscar/{reservation_id}")
    public String findReservation(@PathVariable Integer reservation_id){
        return this.reservationService.findReservation(reservation_id);
    }
}
