package hoteleria.model.repository.recordReservation;

import hoteleria.model.entity.recordReservation.RecordReservationEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecordReservationRepository extends JpaRepository<RecordReservationEntity, Integer> {
}
