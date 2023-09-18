package hoteleria.services.user;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.converter.user.UserConverter;
import hoteleria.commons.domains.dto.user.UserDTO;
import hoteleria.model.entity.check_in.Check_inEntity;
import hoteleria.model.entity.user.UserEntity;
import hoteleria.model.repository.check_in.ICheck_inRepository;
import hoteleria.model.repository.user.IUserRepository;
import hoteleria.webApi.check_in.Check_inController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private UserConverter userConverter;

    public String createUser(UserEntity userEntity){
        try{
            Optional<UserEntity> find = this.iUserRepository.findById(userEntity.getUserId());
            if (find.isEmpty()){
                this.iUserRepository.save(userEntity);
                return IResponse.CREATE_SUCCESS;
            }
            else {
                return IResponse.CREATE_FAIL + " YA SE ENCUENTRA CREADO ";
            }
        }
        catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }

    public String deleteUser(Integer userId){
        try {
            Optional<UserEntity> find = iUserRepository.findById(userId);
            if (find.isPresent()){
                iUserRepository.delete(find.get());
                return IResponse.DELETE_SUCCESS;
            }
            else {
                return IResponse.DELETE_FAIL;
            }
        }
        catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }

    public String updateUser(UserDTO userDTO){
        try{
            if (userDTO == null || userDTO.getUserId() == null){
                return IResponse.NOT_FOUND;
            }
            Optional<UserEntity> find = iUserRepository.findById(userDTO.getUserId());
            if (find.isPresent()){
                UserEntity userEntity = userConverter.convertUserDTOToUserEntity(userDTO);
                iUserRepository.save(userEntity);
                return IResponse.OPERATION_SUCCESS;
            }
            else {
                return IResponse.OPERATION_FAIL;
            }
        }
        catch (Exception e)
        {
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }

    public String findUser(Integer userId){
        try {
            Optional<UserEntity> find = iUserRepository.findById(userId);
            if (find.isPresent()){
                String findUserMethod = find.toString();
                return findUserMethod;
            }else {
                return IResponse.OPERATION_FAIL;
            }
        }
        catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }

}
