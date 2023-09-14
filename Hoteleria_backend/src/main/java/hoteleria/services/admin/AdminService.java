package hoteleria.services.admin;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.model.entity.user.UserEntity;
import hoteleria.model.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private IUserRepository iUserRepository;

    public String createUser(UserEntity userEntity) {
        try {
            Optional<UserEntity> find = this.iUserRepository.findById(userEntity.getUserId());
            if (find.isEmpty()) {
                this.iUserRepository.save(userEntity);
                return IResponse.CREATE_SUCCESS;
            } else {
                return IResponse.CREATE_FAIL;
            }
        } catch (Exception e) {
            return IResponse.CREATE_FAIL;
        }
    }

}