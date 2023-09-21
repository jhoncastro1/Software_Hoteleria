package hoteleria.model.repository.reports;

import hoteleria.model.entity.reports.ReportsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReportsRepository extends JpaRepository<ReportsEntity, Integer> {
}
