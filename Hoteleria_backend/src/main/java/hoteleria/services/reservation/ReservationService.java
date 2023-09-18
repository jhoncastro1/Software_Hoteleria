package hoteleria.services.reservation;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.converter.reservation.ReservationConverter;
import hoteleria.commons.domains.dto.reservation.ReservationDTO;
import hoteleria.model.entity.reservation.Reservation_Entity;
import hoteleria.model.repository.reservation.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private IReservationRepository iReservationRepository;

    @Autowired
    private ReservationConverter reservationConverter;


    public String createReservation(Reservation_Entity reservationEntity){
        try {
            Optional<Reservation_Entity> find = this.iReservationRepository.findById(reservationEntity.getReservation_id());
            if (!find.isPresent()){
                this.iReservationRepository.save(reservationEntity);
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

    public String deleteReservation(Integer reservationId){
        try {
            Optional<Reservation_Entity> find = iReservationRepository.findById(reservationId);
            if (find.isPresent()){
                iReservationRepository.delete(find.get());
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

    public String updateReservation(ReservationDTO reservationDTO){
        try {
            if (reservationDTO == null || reservationDTO.getReservation_id() == null){
                return IResponse.NOT_FOUND;
            }
            Optional<Reservation_Entity> find = iReservationRepository.findById(reservationDTO.getReservation_id());
            if (find.isPresent()){
                Reservation_Entity reservationEntity = reservationConverter.convertReservationDTOToReservationEntity(reservationDTO);
                iReservationRepository.save(reservationEntity);
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

    public String findReservation(Integer reservationId){
        try {
            Optional<Reservation_Entity> find = iReservationRepository.findById(reservationId);
            if (find.isPresent()){
                String findReservationMethod = find.toString();
                return findReservationMethod;
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
