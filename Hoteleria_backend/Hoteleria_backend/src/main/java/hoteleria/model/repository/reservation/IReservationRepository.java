package hoteleria.model.repository.reservation;

import hoteleria.model.entity.reservation.Reservation_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation_Entity, Integer> {
    }
