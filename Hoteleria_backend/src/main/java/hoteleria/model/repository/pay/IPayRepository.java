package hoteleria.model.repository.pay;

import hoteleria.model.entity.pay.PayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPayRepository extends JpaRepository<PayEntity, Integer> {
}
