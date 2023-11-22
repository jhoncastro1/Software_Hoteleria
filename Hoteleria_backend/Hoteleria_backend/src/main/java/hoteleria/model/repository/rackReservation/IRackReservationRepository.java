package hoteleria.model.repository.rackReservation;

import hoteleria.model.entity.rackReservation.RackReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRackReservationRepository extends JpaRepository<RackReservationEntity, Integer> {
}
