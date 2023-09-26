package hoteleria.webApi.user;

import hoteleria.commons.constans.endPoints.user.IUserEndPoints;
import hoteleria.commons.domains.dto.user.UserDTO;
import hoteleria.model.entity.check_in.Check_inEntity;
import hoteleria.model.entity.user.UserEntity;
import hoteleria.services.check_in.Check_inService;
import hoteleria.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IUserEndPoints.USER_BASE_URL)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(IUserEndPoints.USER_CREATE_URL)
    public String createUser(@RequestBody UserEntity userEntity){
        return this.userService.createUser(userEntity);
    }

    @DeleteMapping(IUserEndPoints.USER_DELETE_URL)
    public String deleteUser(@PathVariable Integer userId){
        return this.userService.deleteUser(userId);
    }

    @PutMapping(IUserEndPoints.USER_UPDATE_URL)
    public String updateUser(@RequestBody UserDTO userDTO){
        return this.userService.updateUser(userDTO);
    }

    @GetMapping(IUserEndPoints.USER_GET_URL)
    public String findUser(@PathVariable Integer userId){
        return this.userService.findUser(userId);
    }
}
