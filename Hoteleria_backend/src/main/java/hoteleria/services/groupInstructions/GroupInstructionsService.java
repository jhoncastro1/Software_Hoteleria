package hoteleria.services.groupInstructions;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.converter.groupIntructions.GroupInstructionsConverter;
import hoteleria.commons.domains.dto.groupInstructions.GroupInstructionsDTO;
import hoteleria.model.entity.groupInstructions.GroupInstructionsEntity;
import hoteleria.model.repository.groupInstructions.IGroupInstructionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupInstructionsService {

    @Autowired
    private IGroupInstructionsRepository iGroupInstructionsRepository;

    @Autowired
    private GroupInstructionsConverter groupInstructionsConverter;

    public String createGroupInstructions(GroupInstructionsEntity groupInstructionsEntity){
        try{
            Optional<GroupInstructionsEntity> find = this.iGroupInstructionsRepository.findById(groupInstructionsEntity.getGroupInstructionsId());
            if (!find.isPresent()){
                this.iGroupInstructionsRepository.save(groupInstructionsEntity);
                return IResponse.CREATE_SUCCESS;
            }else {return IResponse.CREATE_FAIL;}
        }catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }

    public String deleteGroupInstructions(Integer groupInstructionsId){
        try {
            Optional<GroupInstructionsEntity> find = this.iGroupInstructionsRepository.findById(groupInstructionsId);
            if (find.isPresent()){
                this.iGroupInstructionsRepository.delete(find.get());
                return IResponse.DELETE_SUCCESS;
            }else {return IResponse.DELETE_FAIL;}
        }catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }

    public String updateGroupInstructions(GroupInstructionsDTO groupInstructionsDTO){
        try{
            if (groupInstructionsDTO == null || groupInstructionsDTO.getGroupInstructionsId() == null ){
                return IResponse.NOT_FOUND;
            }
            Optional<GroupInstructionsEntity> find = this.iGroupInstructionsRepository.findById(groupInstructionsDTO.getGroupInstructionsId());
            if (find.isPresent()){
                GroupInstructionsEntity groupInstructionsEntity = groupInstructionsConverter.convertGroupInstructionsDTOToGroupInstructionsEntity(groupInstructionsDTO);
                this.iGroupInstructionsRepository.save(groupInstructionsEntity);
                return IResponse.UPDATE_SUCCESS;
            }else {return IResponse.UPDATE_FAIL;}
        }catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }

    public String findGroupInstructions(Integer groupInstructionsId){
        try{
            Optional<GroupInstructionsEntity> find = this.iGroupInstructionsRepository.findById(groupInstructionsId);
            if (find.isPresent()){
                String findGroupInstructions = find.toString();
                return findGroupInstructions;
            }else {return IResponse.NOT_FOUND;}
        }catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }
}
