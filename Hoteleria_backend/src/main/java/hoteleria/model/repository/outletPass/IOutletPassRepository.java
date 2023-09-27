package hoteleria.model.repository.outletPass;

import hoteleria.model.entity.outletPass.OutletPassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOutletPassRepository extends JpaRepository<OutletPassEntity, Integer> {
}
