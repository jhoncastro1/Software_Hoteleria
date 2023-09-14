package hoteleria.services.reservation;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.model.entity.reservation.Reservation_Entity;
import hoteleria.model.repository.reservation.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private IReservationRepository iReservationRepository;



    public String createReservation(Reservation_Entity reservationEntity){
        try {
            System.out.println("entro a el servicio" + reservationEntity.getReservation_id());
            Optional<Reservation_Entity> find = this.iReservationRepository.findById(reservationEntity.getReservation_id());
            System.out.println("se encontro");
            if (!find.isPresent()){
                System.out.println("prueba if");
                this.iReservationRepository.save(reservationEntity);
                System.out.println("Se guardo");
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
            Optional<Reservation_Entity> find = this.iReservationRepository.findById(reservationId);
            if (find.isPresent()){
                Reservation_Entity deleteReservationMethod = new Reservation_Entity();
                deleteReservationMethod.setReservation_id(find.get().getReservation_id());
                deleteReservationMethod.setReservation_date(find.get().getReservation_date());
                deleteReservationMethod.setCheck_in_date(find.get().getCheck_in_date());
                deleteReservationMethod.setCheck_out_date(find.get().getCheck_out_date());
                deleteReservationMethod.setContact_first_name(find.get().getContact_first_name());
                deleteReservationMethod.setContact_last_name(find.get().getContact_last_name());
                deleteReservationMethod.setContact_email(find.get().getContact_email());
                deleteReservationMethod.setContact_phone(find.get().getContact_phone());
                deleteReservationMethod.setGuests_total(find.get().getGuests_total());
                deleteReservationMethod.setReservation_status(find.get().getReservation_status());
                deleteReservationMethod.setSpecial_requests(find.get().getSpecial_requests());
                deleteReservationMethod.setId_assigned_room(find.get().getId_assigned_room());
                iReservationRepository.delete(deleteReservationMethod);
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

    public String updateReservation(Reservation_Entity reservationEntity){
        try {
            Optional<Reservation_Entity> find = iReservationRepository.findById(reservationEntity.getReservation_id());
            if (find.isPresent()){
                Reservation_Entity updateReservationMethod = new Reservation_Entity();
                updateReservationMethod.setReservation_id(find.get().getReservation_id());
                updateReservationMethod.setReservation_date(find.get().getReservation_date());
                updateReservationMethod.setCheck_in_date(find.get().getCheck_in_date());
                updateReservationMethod.setCheck_out_date(find.get().getCheck_out_date());
                updateReservationMethod.setContact_first_name(find.get().getContact_first_name());
                updateReservationMethod.setContact_last_name(find.get().getContact_last_name());
                updateReservationMethod.setContact_email(find.get().getContact_email());
                updateReservationMethod.setContact_phone(find.get().getContact_phone());
                updateReservationMethod.setGuests_total(find.get().getGuests_total());
                updateReservationMethod.setReservation_status(find.get().getReservation_status());
                updateReservationMethod.setSpecial_requests(find.get().getSpecial_requests());
                updateReservationMethod.setId_assigned_room(find.get().getId_assigned_room());
                iReservationRepository.save(updateReservationMethod);
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



}
