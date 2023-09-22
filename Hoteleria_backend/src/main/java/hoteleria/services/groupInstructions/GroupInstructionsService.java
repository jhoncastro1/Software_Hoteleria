package hoteleria.services.groupInstructions;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.converter.groupInstructions.GroupInstructionsConverter;
import hoteleria.commons.domains.dto.groupInstructions.GroupInstructionsDTO;
import hoteleria.model.entity.groupInstructions.GroupInstructionsEntity;
import hoteleria.model.repository.groupInstructions.IGroupInstructionsRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
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
        try {
            Optional<GroupInstructionsEntity> find = this.iGroupInstructionsRepository.findById(groupInstructionsEntity.getIdGroupInstructions());
            if (!find.isPresent()){
                this.iGroupInstructionsRepository.save(groupInstructionsEntity);
                return IResponse.CREATE_SUCCESS;
            }else {
                return IResponse.CREATE_FAIL;
            }
        }catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }
    public String deleteGroupInstructions(Integer idGroupInstructions){
        try{
            Optional<GroupInstructionsEntity> find = this.iGroupInstructionsRepository.findById(idGroupInstructions);
            if (find.isPresent()){
                iGroupInstructionsRepository.delete(find.get());
                return IResponse.DELETE_SUCCESS;
            }else {
                return IResponse.DELETE_FAIL;
            }
        }catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }
    public String updateGroupInstructions(GroupInstructionsDTO groupInstructionsDTO){
        try {
            if (groupInstructionsDTO == null || groupInstructionsDTO.getIdGroupInstructions() == null){
                return IResponse.NOT_FOUND;
            }
            Optional<GroupInstructionsEntity> find = this.iGroupInstructionsRepository.findById(groupInstructionsDTO.getIdGroupInstructions());
            if (find.isPresent()){
                GroupInstructionsEntity groupInstructionsEntity = groupInstructionsConverter.convertGroupInstructionsDTOToGroupInstructionsEntity(groupInstructionsDTO);
                iGroupInstructionsRepository.save(groupInstructionsEntity);
                return IResponse.UPDATE_SUCCESS;
            }else {
                return IResponse.UPDATE_FAIL;
            }
        }catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }
    public String findGroupInstructions(Integer idGroupInstructions){
        try {
            Optional<GroupInstructionsEntity> find = this.iGroupInstructionsRepository.findById(idGroupInstructions);
            if (find.isPresent()){
                String findGroupInstructions = find.toString();
                return findGroupInstructions;
            }else {
                return IResponse.OPERATION_FAIL;
            }
        }catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }
}
