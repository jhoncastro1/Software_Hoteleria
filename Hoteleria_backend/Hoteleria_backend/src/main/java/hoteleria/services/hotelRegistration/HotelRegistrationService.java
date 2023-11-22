package hoteleria.services.hotelRegistration;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.converter.hotelRegistration.HotelRegistrationConverter;
import hoteleria.commons.domains.dto.hotelRegistration.HotelRegistrationDTO;
import hoteleria.model.entity.hotelRegistration.HotelRegistrationEntity;
import hoteleria.model.repository.hotelRegistration.IHotelRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelRegistrationService {
    @Autowired
    private IHotelRegistrationRepository iHotelRegistrationRepository;
    @Autowired
    private HotelRegistrationConverter hotelRegistrationConverter;

    public String createHotelRegistration(HotelRegistrationEntity hotelRegistrationEntity){
        try {
            Optional<HotelRegistrationEntity> find = this.iHotelRegistrationRepository.findById(hotelRegistrationEntity.getIdHotelRegistration());
            if (!find.isPresent()){
                this.iHotelRegistrationRepository.save(hotelRegistrationEntity);
                return IResponse.CREATE_SUCCESS;
            }else {
                return IResponse.CREATE_FAIL;
            }
        }catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }
    public String deleteHotelRegistration(Integer idHotelRegistration){
        try {
            Optional<HotelRegistrationEntity> find = this.iHotelRegistrationRepository.findById(idHotelRegistration);
            if (find.isPresent()){
                this.iHotelRegistrationRepository.delete(find.get());
                return IResponse.DELETE_SUCCESS;
            }else {
                return IResponse.DELETE_FAIL;
            }
        }catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }
    public String updateHotelRegistration(HotelRegistrationDTO hotelRegistrationDTO){
        try{
            if (hotelRegistrationDTO == null || hotelRegistrationDTO.getIdHotelRegistration() == null){
                return IResponse.NOT_FOUND;
            }
            Optional<HotelRegistrationEntity> find = this.iHotelRegistrationRepository.findById(hotelRegistrationDTO.getIdHotelRegistration());
            if (find.isPresent()){
                HotelRegistrationEntity hotelRegistrationEntity = hotelRegistrationConverter.convertHotelRegistrationDTOToHotelRegistrationEntity(hotelRegistrationDTO);
                this.iHotelRegistrationRepository.save(hotelRegistrationEntity);
                return IResponse.UPDATE_SUCCESS;
            }
            else {
                return IResponse.UPDATE_FAIL;
            }

        }catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }
    public String findHotelRegistration(Integer idHotelRegistration){
        try {
            Optional<HotelRegistrationEntity> find = this.iHotelRegistrationRepository.findById(idHotelRegistration);
            if (find.isPresent()){
                String findHotel = find.toString();
                return findHotel;
            }else {
                return IResponse.NOT_FOUND;
            }
        }catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }
}
