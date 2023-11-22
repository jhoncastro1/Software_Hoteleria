package hoteleria.model.repository.outletPass;

import hoteleria.model.entity.outletPass.OutletPassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOutletPassRepository extends JpaRepository<OutletPassEntity, Integer> {
    Optional<OutletPassEntity> findByNameCustomer(String nameCustomer);
}
