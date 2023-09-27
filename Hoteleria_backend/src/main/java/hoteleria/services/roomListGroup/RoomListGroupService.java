package hoteleria.services.roomListGroup;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.converter.roomListGroup.RoomListGroupConverter;
import hoteleria.commons.domains.dto.roomListGroup.RoomListGroupDTO;
import hoteleria.model.entity.roomListGroup.RoomListGroupEntity;
import hoteleria.model.repository.roomListGroup.IRoomListGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomListGroupService {
    @Autowired
    private RoomListGroupConverter roomListGroupConverter;

    @Autowired
    private IRoomListGroupRepository iRoomListGroupRepository;

    public String createRoomListGroup(RoomListGroupEntity roomListGroupEntity){
        try {
            Optional<RoomListGroupEntity> find = this.iRoomListGroupRepository.findById(roomListGroupEntity.getIdRoomListGroup());
            if (!find.isPresent()){
                this.iRoomListGroupRepository.save(roomListGroupEntity);
                return IResponse.CREATE_SUCCESS;
            }else {
                return IResponse.CREATE_FAIL;
            }
        }catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }

    public String deleteRoomListGroup(Integer idRoomListgroup){
        try {
            Optional<RoomListGroupEntity> find = iRoomListGroupRepository.findById(idRoomListgroup);
            if (find.isPresent()){
                iRoomListGroupRepository.delete(find.get());
                return IResponse.DELETE_SUCCESS;
            }else {
                return IResponse.DELETE_FAIL;
            }
        }catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }

    public String updateRoomListGroup(RoomListGroupDTO roomListGroupDTO){
        try {
            if (roomListGroupDTO == null || roomListGroupDTO.getIdRoomListGroup() == null){
                return IResponse.NOT_FOUND;
            }
            Optional<RoomListGroupEntity> find = iRoomListGroupRepository.findById(roomListGroupDTO.getIdRoomListGroup());
            if (find.isPresent()){
                RoomListGroupEntity roomListGroupEntity = roomListGroupConverter.convertRoomListGroupDTOToRoomListGroupEntity(roomListGroupDTO);
                iRoomListGroupRepository.save(roomListGroupEntity);
                return IResponse.UPDATE_SUCCESS;
            }else {
                return IResponse.UPDATE_FAIL;
            }
        }catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }

    public String findRoomListGroup(Integer idRoomListGroup) {
        try {
            Optional<RoomListGroupEntity> find = iRoomListGroupRepository.findById(idRoomListGroup);
            if (find.isPresent()) {
                String findRoomList = find.toString();
                return findRoomList;
            }else {
                return IResponse.NOT_FOUND;
            }
        } catch (Exception e) {
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }

}
