package hoteleria.services.rackReservation;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.converter.rackReservation.RackReservationConverter;
import hoteleria.commons.domains.dto.rackReservation.RackReservationDTO;
import hoteleria.model.entity.rackReservation.RackReservationEntity;
import hoteleria.model.entity.reservation.Reservation_Entity;
import hoteleria.model.repository.rackReservation.IRackReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RackReservationService {

    @Autowired
    private IRackReservationRepository iRackReservationRepository;

    @Autowired
    private RackReservationConverter rackReservationConverter;

    public String createRackReservation(RackReservationEntity rackReservationEntity){
        try {
            Optional<RackReservationEntity> find = this.iRackReservationRepository.findById(rackReservationEntity.getRackId());
            if (!find.isPresent()){
            this.iRackReservationRepository.save(rackReservationEntity);
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

    public String deleteRackReservation(Integer rackId){
        try {
            Optional<RackReservationEntity> find = iRackReservationRepository.findById(rackId);
            if (find.isPresent()){
                iRackReservationRepository.delete(find.get());
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

    public String updateRackReservation(RackReservationDTO rackReservationDTO){
        try {
            if (rackReservationDTO == null || rackReservationDTO.getRackId() == null){
                return IResponse.NOT_FOUND;
            }
            Optional<RackReservationEntity> find = iRackReservationRepository.findById(rackReservationDTO.getRackId());
            if (find.isPresent()){
                RackReservationEntity reservationEntity = rackReservationConverter.convertRackReservationDTOToRackReservationEntity(rackReservationDTO);
                iRackReservationRepository.save(reservationEntity);
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

    public String findRackReservation(Integer rackId){
        try {
            Optional<RackReservationEntity> find = iRackReservationRepository.findById(rackId);
            if (find.isPresent()){
                String findRackReservationMethod = find.toString();
                return findRackReservationMethod;
            }
            else {
                return IResponse.OPERATION_FAIL;
            }
        }
        catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }

}
