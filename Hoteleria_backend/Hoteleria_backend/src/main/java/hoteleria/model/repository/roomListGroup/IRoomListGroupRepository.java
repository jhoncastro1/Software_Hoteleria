package hoteleria.model.repository.roomListGroup;

import hoteleria.model.entity.roomListGroup.RoomListGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoomListGroupRepository extends JpaRepository<RoomListGroupEntity, Integer> {
}
