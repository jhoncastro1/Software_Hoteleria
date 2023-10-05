package hoteleria.webApi.hotelRegistration;

import hoteleria.commons.constans.endPoints.hotelRegistration.IHotelRegistrationEndPoints;
import hoteleria.commons.domains.dto.hotelRegistration.HotelRegistrationDTO;
import hoteleria.model.entity.hotelRegistration.HotelRegistrationEntity;
import hoteleria.services.hotelRegistration.HotelRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IHotelRegistrationEndPoints.HOTEL_REGISTRATION_BASE_URL)
public class HotelRegistrationController {

    @Autowired
    private HotelRegistrationService hotelRegistrationService;

    @PostMapping(IHotelRegistrationEndPoints.HOTEL_REGISTRATION_CREATE_URL)
    public String createHotelRegistration(@RequestBody HotelRegistrationEntity hotelRegistrationEntity){
        return this.hotelRegistrationService.createHotelRegistration(hotelRegistrationEntity);
    }

    @DeleteMapping(IHotelRegistrationEndPoints.HOTEL_REGISTRATION_DELETE_URL)
    public String deleteHotelRegistration(@PathVariable Integer idHotelRegistration){
        return this.hotelRegistrationService.deleteHotelRegistration(idHotelRegistration);
    }

    @PutMapping(IHotelRegistrationEndPoints.HOTEL_REGISTRATION_UPDATE_URL)
    public String updateHotelRegistration(@RequestBody HotelRegistrationDTO hotelRegistrationDTO){
        return this.hotelRegistrationService.updateHotelRegistration(hotelRegistrationDTO);
    }

    @GetMapping(IHotelRegistrationEndPoints.HOTEL_REGISTRATION_FIND_URL)
    public String findHotelRegistration(@PathVariable Integer idHotelRegistration ){
        return this.hotelRegistrationService.findHotelRegistration(idHotelRegistration);
    }
}
