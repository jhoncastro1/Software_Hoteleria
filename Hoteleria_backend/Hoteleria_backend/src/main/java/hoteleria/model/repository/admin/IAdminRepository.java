package hoteleria.model.repository.admin;

import hoteleria.model.entity.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {
}
