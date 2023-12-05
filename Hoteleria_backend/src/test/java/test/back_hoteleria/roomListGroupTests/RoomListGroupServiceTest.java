package test.back_hoteleria.roomListGroupTests;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.converter.roomListGroup.RoomListGroupConverter;
import hoteleria.commons.domains.dto.roomListGroup.RoomListGroupDTO;
import hoteleria.model.entity.roomListGroup.RoomListGroupEntity;
import hoteleria.model.repository.roomListGroup.IRoomListGroupRepository;
import hoteleria.services.roomListGroup.RoomListGroupService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RoomListGroupServiceTest {

    @Mock
    private IRoomListGroupRepository iRoomListGroupRepository;

    @Mock
    private RoomListGroupConverter roomListGroupConverter;

    @InjectMocks
    private RoomListGroupService roomListGroupService;

    @Test
    public void testCreateRoomListGroupSuccess(){
        RoomListGroupEntity roomListGroupEntity = new RoomListGroupEntity();
        when(iRoomListGroupRepository.findById(roomListGroupEntity.getIdRoomListGroup())).thenReturn(Optional.empty());

        String result = roomListGroupService.createRoomListGroup(roomListGroupEntity);

        assertEquals(IResponse.CREATE_SUCCESS, result);
        verify(iRoomListGroupRepository,times(1)).save(roomListGroupEntity);
    }

    @Test
    public void testCreateRoomListGroupFail(){
        RoomListGroupEntity roomListGroupEntity = new RoomListGroupEntity();
        when(iRoomListGroupRepository.findById(roomListGroupEntity.getIdRoomListGroup())).thenReturn(Optional.of(roomListGroupEntity));
        String result = roomListGroupService.createRoomListGroup(roomListGroupEntity);

        assertEquals(IResponse.CREATE_FAIL, result);
        verify(iRoomListGroupRepository, never()).save(any());
    }

    @Test
    public void testDeleteRoomListGroupSuccess(){
        Integer roomId = 1;

        RoomListGroupEntity roomListGroupEntity = new RoomListGroupEntity();
        roomListGroupEntity.setIdRoomListGroup(roomId);

        when(iRoomListGroupRepository.findById(roomId)).thenReturn(Optional.of(roomListGroupEntity));

        String result = roomListGroupService.deleteRoomListGroup(roomId);

        assertEquals(IResponse.DELETE_SUCCESS,result);

        verify(iRoomListGroupRepository, times(1)).findById(roomId);
        verify(iRoomListGroupRepository, times(1)).delete(roomListGroupEntity);

    }

    @Test
    public void testDeleteRoomListGroupFail(){
        Integer roomId = 1;
        when(iRoomListGroupRepository.findById(roomId)).thenReturn(Optional.empty());
        String result = roomListGroupService.deleteRoomListGroup(roomId);
        assertEquals(IResponse.DELETE_FAIL,result);
        verify(iRoomListGroupRepository, times(1)).findById(roomId);

    }

    @Test
    public void testUpdateRoomListGroupSuccess(){
        RoomListGroupDTO roomListGroupDTO = new RoomListGroupDTO(1, LocalDate.now(), LocalDate.now(), "Jhon", 2, "SGL", "No");

        RoomListGroupEntity roomListGroupEntity = new RoomListGroupEntity();

        when(iRoomListGroupRepository.findById(roomListGroupDTO.getIdRoomListGroup())).thenReturn(Optional.of(roomListGroupEntity));
        when(roomListGroupConverter.convertRoomListGroupDTOToRoomListGroupEntity(roomListGroupDTO)).thenReturn(roomListGroupEntity);

        String result = roomListGroupService.updateRoomListGroup(roomListGroupDTO);

        assertEquals(IResponse.UPDATE_SUCCESS, result);
        verify(iRoomListGroupRepository, times(1)).findById(roomListGroupDTO.getIdRoomListGroup());
        verify(iRoomListGroupRepository, times(1)).save(roomListGroupEntity);

    }

    @Test
    public void testUpdateRoomListGroupFail(){
        RoomListGroupDTO roomListGroupDTO = new RoomListGroupDTO(1, LocalDate.now(), LocalDate.now(), "Jhon", 2, "SGL", "No");

        when(iRoomListGroupRepository.findById(roomListGroupDTO.getIdRoomListGroup())).thenReturn(Optional.empty());

        String result = roomListGroupService.updateRoomListGroup(roomListGroupDTO);
        assertEquals(IResponse.UPDATE_FAIL, result);

        verify(iRoomListGroupRepository, times(1)).findById(roomListGroupDTO.getIdRoomListGroup());
        verify(iRoomListGroupRepository, never()).save(any());

    }

    @Test
    public void testFindRoomListGroupSuccess(){
        Integer roomId = 1;
        RoomListGroupEntity roomListGroupEntity = new RoomListGroupEntity();
        when(iRoomListGroupRepository.findById(any())).thenReturn(Optional.of(roomListGroupEntity));

        String result = roomListGroupService.findRoomListGroup(roomId);

        assertEquals(roomListGroupEntity.toString(),Optional.of(roomListGroupEntity).orElse(null).toString());
        verify(iRoomListGroupRepository, times(1)).findById(any());

    }

    @Test
    public void testFindRoomListGroupFail(){
        Integer roomId = 1;

        when(iRoomListGroupRepository.findById(roomId)).thenReturn(Optional.empty());

        String result = roomListGroupService.findRoomListGroup(roomId);

        assertEquals(IResponse.NOT_FOUND, result);
        verify(iRoomListGroupRepository, times(1)).findById(roomId);
    }


}
