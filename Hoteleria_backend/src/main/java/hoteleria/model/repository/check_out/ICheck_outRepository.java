package hoteleria.model.repository.check_out;


import hoteleria.model.entity.check_out.Check_outEntity;
import hoteleria.model.entity.reports.IReports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICheck_outRepository extends JpaRepository<Check_outEntity, Integer> {

    @Query(value = "SELECT co.check_out_id FROM checkout co;", nativeQuery = true)
    List<IReports> getCheckOutId();

}
