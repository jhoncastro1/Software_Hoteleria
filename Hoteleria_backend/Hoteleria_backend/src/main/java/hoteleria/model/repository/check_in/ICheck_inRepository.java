package hoteleria.model.repository.check_in;


import hoteleria.commons.domains.dto.check_In.IForm;
import hoteleria.model.entity.check_in.Check_inEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICheck_inRepository extends JpaRepository<Check_inEntity, Integer> {

    Optional<Check_inEntity> findByCheckInId(Integer checkInID);

    @Query(value = "SELECT ck.id_assigned_room AS noHabitacion, ck.guest_first_name AS nombre, ck.guest_last_name AS apellido, ck.guests_count AS numeroPersonas FROM checkin ck WHERE ck.check_in_date = CURRENT_DATE();", nativeQuery = true)
    List<IForm> customFind();
}
