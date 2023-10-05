package hoteleria.commons.converter.user;


import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.domains.dto.user.UserDTO;
import hoteleria.commons.helpers.HelperMapper;
import hoteleria.model.entity.user.UserEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class UserConverter {

    public UserEntity convertUserDTOToUserEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        try {
            userEntity = HelperMapper.modelMapper().map(userDTO, UserEntity.class);
        }
        catch (Exception e){
            log.error(IResponse.DOCUMENT_FAIL + e);
        }
        return  userEntity;
    }
}
