package hoteleria.model.repository.check_in;


import hoteleria.commons.domains.dto.check_In.IForm;
import hoteleria.model.entity.check_in.Check_inEntity;
import hoteleria.model.entity.reports.IReports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICheck_inRepository extends JpaRepository<Check_inEntity, Integer> {

    Optional<Check_inEntity> findByCheckInId(Integer checkInID);

    @Query(value = "SELECT ck.check_in_id FROM checkin ck", nativeQuery = true)
    List<IReports> getCheckInId();
}
