package hoteleria.webApi.user;

import hoteleria.commons.constans.endPoints.user.IUserEndPoints;
import hoteleria.model.entity.check_in.Check_inEntity;
import hoteleria.services.check_in.Check_inService;
import hoteleria.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(IUserEndPoints.USER_CHECK_IN_BASE_URL)
public class UserController {

    @Autowired
    private Check_inService checkInService;

    @Autowired
    private UserService userService;

    @PostMapping(IUserEndPoints.USER_CREATE_CHECK_IN_URL)
    public String createCheckInByUser(@RequestBody Check_inEntity checkInEntity){
        return this.checkInService.addCheckIn(checkInEntity);
    }

}
