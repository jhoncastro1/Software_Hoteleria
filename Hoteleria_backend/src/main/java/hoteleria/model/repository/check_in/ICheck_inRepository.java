package hoteleria.model.repository.check_in;


import hoteleria.model.entity.check_in.Check_inEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICheck_inRepository extends JpaRepository<Check_inEntity, Integer> {

    Optional<Check_inEntity> findByCheckInId(Integer checkInID);

}
