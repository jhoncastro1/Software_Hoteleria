package hoteleria.model.repository.reservation;

import hoteleria.model.entity.reports.IReports;
import hoteleria.model.entity.reservation.Reservation_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation_Entity, Integer> {
    @Query(value = "SELECT rt.reservation_id FROM reservations rt", nativeQuery = true)
    List<IReports> getReservationId();
}
