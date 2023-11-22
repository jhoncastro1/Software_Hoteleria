package hoteleria.webApi.admin;

import hoteleria.commons.domains.dto.user.UserDTO;
import hoteleria.model.entity.user.UserEntity;
import hoteleria.model.repository.user.IUserRepository;
import hoteleria.services.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/controller")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private IUserRepository iUserRepository;

    @GetMapping("/user")
    public List<UserEntity> getAllUser() {
        return iUserRepository.findAll();
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody UserEntity userEntity){
        return this.adminService.createUser(userEntity);
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody UserDTO userDTO){
        return this.adminService.setStatus(userDTO);
    }
}
