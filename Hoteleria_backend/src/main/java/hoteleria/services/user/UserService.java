package hoteleria.services.user;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.model.entity.check_in.Check_inEntity;
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
    private ICheck_inRepository iCheckInRepository;

    @Autowired
    private Check_inController check_inController;


    public String createCheckInByUser (Check_inEntity checkInEntity){
        try{
            Optional<Check_inEntity> find = this.iCheckInRepository.findByCheckInId(checkInEntity.getCheckInId());
            if (!find.isPresent()){
                this.iCheckInRepository.save(checkInEntity);
                return IResponse.CREATE_SUCCESS;
            }
            else {
                return IResponse.CREATE_FAIL;
            }
        }
        catch (Exception e){
            return IResponse.INTERNAL_SERVER;
        }
    }



}
