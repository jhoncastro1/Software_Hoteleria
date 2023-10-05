package hoteleria.model.repository.check_out;


import hoteleria.model.entity.check_out.Check_outEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICheck_outRepository extends JpaRepository<Check_outEntity, Integer> {
}
