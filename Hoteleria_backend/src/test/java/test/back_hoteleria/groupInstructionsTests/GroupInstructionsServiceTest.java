package test.back_hoteleria.groupInstructionsTests;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.converter.groupIntructions.GroupInstructionsConverter;
import hoteleria.commons.domains.dto.groupInstructions.GroupInstructionsDTO;
import hoteleria.model.entity.groupInstructions.GroupInstructionsEntity;
import hoteleria.model.repository.groupInstructions.IGroupInstructionsRepository;
import hoteleria.services.groupInstructions.GroupInstructionsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GroupInstructionsServiceTest {
    @Mock
    private IGroupInstructionsRepository iGroupInstructionsRepository;

    @Mock
    private GroupInstructionsConverter groupInstructionsConverter;

    @InjectMocks
    private GroupInstructionsService groupInstructionsService;

    @Test
    public void testCreateGroupInstructionsSuccess(){
        GroupInstructionsEntity groupInstructionsEntity = new GroupInstructionsEntity();
        when(iGroupInstructionsRepository.findById(groupInstructionsEntity.getGroupInstructionsId())).thenReturn(Optional.empty());

        String result = groupInstructionsService.createGroupInstructions(groupInstructionsEntity);

        assertEquals(IResponse.CREATE_SUCCESS, result);
        verify(iGroupInstructionsRepository, times(1)).save(groupInstructionsEntity);

    }
    @Test
    public void testCreateGroupInstructionsFail(){
        GroupInstructionsEntity groupInstructionsEntity = new GroupInstructionsEntity();
        when(iGroupInstructionsRepository.findById(groupInstructionsEntity.getGroupInstructionsId())).thenReturn(Optional.of(groupInstructionsEntity));

        String result = groupInstructionsService.createGroupInstructions(groupInstructionsEntity);

        assertEquals(IResponse.CREATE_FAIL, result);
        verify(iGroupInstructionsRepository,never()).save(any());
    }

    @Test
    public void testDeleteGroupInstructionsSuccess(){
        Integer idGroup = 1;

        GroupInstructionsEntity groupInstructionsEntity = new GroupInstructionsEntity();
        groupInstructionsEntity.setGroupInstructionsId(idGroup);

        when(iGroupInstructionsRepository.findById(idGroup)).thenReturn(Optional.of(groupInstructionsEntity));

        String result = groupInstructionsService.deleteGroupInstructions(idGroup);

        assertEquals(IResponse.DELETE_SUCCESS,result);
        verify(iGroupInstructionsRepository, times(1)).findById(idGroup);
        verify(iGroupInstructionsRepository, times(1)).delete(groupInstructionsEntity);
    }
    @Test
    public void testDeleteGroupInstructionsFail(){
        Integer idGroup = 1;
        when(iGroupInstructionsRepository.findById(idGroup)).thenReturn(Optional.empty());
        String result = groupInstructionsService.deleteGroupInstructions(idGroup);
        assertEquals(IResponse.DELETE_FAIL, result);

        verify(iGroupInstructionsRepository, times(1)).findById(idGroup);

    }


    @Test
    public void testUpdateGroupInstructionsSuccess(){
        GroupInstructionsDTO groupInstructionsDTO = new GroupInstructionsDTO();
        groupInstructionsDTO.setGroupInstructionsId(1);

        GroupInstructionsEntity groupInstructionsEntity = new GroupInstructionsEntity();
        when(iGroupInstructionsRepository.findById(any())).thenReturn(Optional.of(groupInstructionsEntity));
        when(groupInstructionsConverter.convertGroupInstructionsDTOToGroupInstructionsEntity(any())).thenReturn(groupInstructionsEntity);
        String result = groupInstructionsService.updateGroupInstructions(groupInstructionsDTO);

        assertEquals(IResponse.UPDATE_SUCCESS, result);
        verify(iGroupInstructionsRepository, times(1)).findById(any());
        verify(iGroupInstructionsRepository, times(1)).save(any());

    }

    @Test
    public void testUpdateGroupInstructionsFail() {
        GroupInstructionsDTO groupInstructionsDTO = new GroupInstructionsDTO();
        groupInstructionsDTO.setGroupInstructionsId(1);
        when(iGroupInstructionsRepository.findById(any())).thenReturn(Optional.empty());
        String result = groupInstructionsService.updateGroupInstructions(groupInstructionsDTO);

        assertEquals(IResponse.UPDATE_FAIL, result);
        verify(iGroupInstructionsRepository, times(1)).findById(any());
        verify(iGroupInstructionsRepository, never()).save(any());

    }

    @Test
    public void testFindGroupInstructionsSucces(){
        Integer groupId = 1;
        GroupInstructionsEntity groupInstructionsEntity = new GroupInstructionsEntity();
        when(iGroupInstructionsRepository.findById(any())).thenReturn(Optional.of(groupInstructionsEntity));

        String result = groupInstructionsService.findGroupInstructions(groupId);

        assertEquals(groupInstructionsEntity.toString(),Optional.of(groupInstructionsEntity).orElse(null).toString());
        verify(iGroupInstructionsRepository, times(1)).findById(any());

    }

    @Test
    public void testFindGroupInstructionsFail(){
        Integer groupId = 1;
        when(iGroupInstructionsRepository.findById(any())).thenReturn(Optional.empty());

        String result = groupInstructionsService.findGroupInstructions(groupId);

        assertEquals(IResponse.NOT_FOUND, result);
        verify(iGroupInstructionsRepository, times(1)).findById(any());
    }
}
