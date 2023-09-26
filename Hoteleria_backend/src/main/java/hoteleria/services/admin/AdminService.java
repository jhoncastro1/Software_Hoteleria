package hoteleria.services.admin;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.converter.user.UserConverter;
import hoteleria.commons.domains.dto.user.UserDTO;
import hoteleria.model.entity.user.UserEntity;
import hoteleria.model.repository.user.IUserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private UserConverter userConverter;

    public String createUser(UserEntity userEntity) {
        try {
            Optional<UserEntity> find = this.iUserRepository.findById(userEntity.getUserId());
            if (!find.isPresent()) {
                this.iUserRepository.save(userEntity);
                return IResponse.CREATE_SUCCESS;
            } else {
                return IResponse.CREATE_FAIL;
            }
        } catch (Exception e) {
            return IResponse.CREATE_FAIL;
        }
    }

    public String setStatus(UserDTO userDTO){
        try{
            Optional<UserEntity> find = this.iUserRepository.findById(userDTO.getUserId());
            if (find.isPresent()){
                UserEntity userEntityUpdate = userConverter.convertUserDTOToUserEntity(userDTO);
                iUserRepository.save(userEntityUpdate);
                return IResponse.OPERATION_SUCCESS;
            }
            else {
                return IResponse.NOT_FOUND;
            }
        }
        catch (Exception e){
            return IResponse.NOT_FOUND;
        }
    }





}