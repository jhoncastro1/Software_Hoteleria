package hoteleria.webApi.roomListGroup;

import hoteleria.commons.constans.endPoints.roomListGroup.IRoomListGroupEndPoints;
import hoteleria.commons.domains.dto.roomListGroup.RoomListGroupDTO;
import hoteleria.model.entity.roomListGroup.RoomListGroupEntity;
import hoteleria.model.repository.roomListGroup.IRoomListGroupRepository;
import hoteleria.services.roomListGroup.RoomListGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IRoomListGroupEndPoints.ROOM_LIST_GROUP_BASE_URL)
public class RoomListGroupController {
    @Autowired
    private RoomListGroupService roomListGroupService;

    @PostMapping(IRoomListGroupEndPoints.ROOM_LIST_GROUP_CREATE_URL)
    private String createRoomListGroup(@RequestBody RoomListGroupEntity roomListGroupEntity){
        return this.roomListGroupService.createRoomListGroup(roomListGroupEntity);
    }

    @DeleteMapping(IRoomListGroupEndPoints.ROOM_LIST_GROUP_DELETE_URL)
    public String deleteRoomListGroup(@PathVariable Integer idRoomListgroup){
        return this.roomListGroupService.deleteRoomListGroup(idRoomListgroup);
    }

    @PutMapping(IRoomListGroupEndPoints.ROOM_LIST_GROUP_UPDATE_URL)
    public String updateRoomListGroup(@RequestBody RoomListGroupDTO roomListGroupDTO){
        return this.roomListGroupService.updateRoomListGroup(roomListGroupDTO);
    }

    @GetMapping(IRoomListGroupEndPoints.ROOM_LIST_GROUP_FIND_URL)
    public String findRoomListGroup(@PathVariable Integer idRoomListGroup){
        return this.roomListGroupService.findRoomListGroup(idRoomListGroup);
    }
}
