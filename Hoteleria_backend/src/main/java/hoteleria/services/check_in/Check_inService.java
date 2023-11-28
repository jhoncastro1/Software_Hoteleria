package hoteleria.services.check_in;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.converter.checkIn.CheckInConverter;
import hoteleria.commons.domains.dto.check_In.Check_InDTO;
import hoteleria.commons.domains.dto.check_In.IForm;
import hoteleria.model.entity.check_in.Check_inEntity;
import hoteleria.model.repository.check_in.ICheck_inRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class Check_inService {


    @Autowired
    private CheckInConverter checkInConverter;

    @Autowired
    private ICheck_inRepository iCheckInRepository;

    public List<Check_inEntity> getAllCheckIns(){
        return iCheckInRepository.findAll();
    }


    public String createCheckIn(Check_inEntity checkInEntity){
        try{
            Optional<Check_inEntity> find = this.iCheckInRepository.findByCheckInId(checkInEntity.getCheckInId());
            if(!find.isPresent()){
                this.iCheckInRepository.save(checkInEntity);
                return IResponse.OPERATION_SUCCESS;
            }
            else {
                return IResponse.OPERATION_FAIL;
            }
        }
        catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }

    public String deleteCheckIn(Integer checkInId){
        try{
            Optional<Check_inEntity> checkInOptional = iCheckInRepository.findById(checkInId);
            if (checkInOptional.isPresent()) {
                iCheckInRepository.delete(checkInOptional.get());
                return IResponse.OPERATION_SUCCESS;
            } else {
                return IResponse.OPERATION_FAIL;
            }
        } catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }


    public String updateCheckIn(Check_InDTO checkInDTO){
        try {
            if (checkInDTO == null || checkInDTO.getCheckInId() == null) {
                return IResponse.NOT_FOUND;
            }
            Optional<Check_inEntity> find = iCheckInRepository.findByCheckInId(checkInDTO.getCheckInId());
            if (find.isPresent()) {
                Check_inEntity checkInEntity = checkInConverter.convertCheckInDTOToCheckInEntity(checkInDTO);
                iCheckInRepository.save(checkInEntity);
                return IResponse.OPERATION_SUCCESS;
            } else {
                return IResponse.NOT_FOUND;
            }
        } catch (Exception e) {
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }


    public String findCheckIn(Integer checkInId){
        try{
            Optional<Check_inEntity> find = iCheckInRepository.findByCheckInId(checkInId);
            if (find.isPresent()){
                String findCheckIn = find.toString();
                return findCheckIn;
            }
            else {
                return IResponse.OPERATION_FAIL;
            }
        }
        catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }

    public List<IForm> customFind(){
        try {
            List<IForm> find = this.iCheckInRepository.customFind();

            if (!find.isEmpty()){
                System.out.println(find.get(0).getNoHabitacion());
                System.out.println(find.get(0).getNombre() + find.get(0).getApellido());
                System.out.println(find.get(0).getNumeroPersonas());
                 return find;
            }else {
                return find;
            }

        }catch (Exception e)
        {
            return null;
        }
    }

}
