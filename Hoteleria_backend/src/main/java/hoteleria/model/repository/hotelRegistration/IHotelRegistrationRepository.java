package hoteleria.model.repository.hotelRegistration;

import hoteleria.model.entity.hotelRegistration.HotelRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHotelRegistrationRepository extends JpaRepository<HotelRegistrationEntity, Integer> {
}
