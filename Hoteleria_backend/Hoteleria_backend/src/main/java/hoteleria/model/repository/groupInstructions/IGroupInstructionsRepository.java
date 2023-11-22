package hoteleria.model.repository.groupInstructions;

import hoteleria.model.entity.goupInstructions.GroupInstructionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGroupInstructionsRepository extends JpaRepository<GroupInstructionsEntity, Integer> {

}
