package test.back_hoteleria.reversationTests;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.converter.reservation.ReservationConverter;
import hoteleria.commons.domains.dto.reservation.ReservationDTO;
import hoteleria.model.entity.reservation.Reservation_Entity;
import hoteleria.model.repository.reservation.IReservationRepository;
import hoteleria.services.reservation.ReservationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceTest {

    @Mock
    private IReservationRepository iReservationRepository;

    @Mock
    private ReservationConverter reservationConverter;

    @InjectMocks
    private ReservationService reservationService;


    @Test
    public void testCreateReservationSuccess(){
        Reservation_Entity reservationEntity = new Reservation_Entity();
        when(iReservationRepository.findById(reservationEntity.getReservation_id())).thenReturn(Optional.empty());

        String result = reservationService.createReservation(reservationEntity);

        assertEquals(IResponse.CREATE_SUCCESS, result);
        verify(iReservationRepository, times(1)).save(reservationEntity);
    }

    @Test
    public void testCreateReservationFail(){
        Reservation_Entity reservationEntity = new Reservation_Entity();
        when(iReservationRepository.findById(reservationEntity.getReservation_id())).thenReturn(Optional.of(reservationEntity));

        String result = reservationService.createReservation(reservationEntity);

        assertEquals(IResponse.CREATE_FAIL, result);
        verify(iReservationRepository, never()).save(any());

    }

    @Test
    public void testDeleteReservationSuccess(){
        Integer idReservation = 1;

        Reservation_Entity reservationEntity = new Reservation_Entity();
        reservationEntity.setReservation_id(idReservation);

        when(iReservationRepository.findById(idReservation)).thenReturn(Optional.of(reservationEntity));

        String result = reservationService.deleteReservation(idReservation);

        assertEquals(IResponse.DELETE_SUCCESS, result);

        verify(iReservationRepository, times(1)).findById(idReservation);
        verify(iReservationRepository, times(1)).delete(reservationEntity);

    }

    @Test
    public void testDeleteReservationFail() {
        Integer idReservation = 1;
        when(iReservationRepository.findById(idReservation)).thenReturn(Optional.empty());

        String result = reservationService.deleteReservation(idReservation);

        assertEquals(IResponse.DELETE_FAIL, result);

        verify(iReservationRepository, times(1)).findById(idReservation);
    }

    @Test
    public void testUpdateReservationSuccess(){
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setReservation_id(1);

        Reservation_Entity reservationEntity = new Reservation_Entity();
        when(iReservationRepository.findById(any())).thenReturn(Optional.of(reservationEntity));
        when(reservationConverter.convertReservationDTOToReservationEntity(any())).thenReturn(reservationEntity);

        String result = reservationService.updateReservation(reservationDTO);

        assertEquals(IResponse.UPDATE_SUCCESS, result);
        verify(iReservationRepository, times(1)).findById(any());
        verify(iReservationRepository, times(1)).save(any());


    }

    @Test
    public void testUpdateReservationFail(){
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setReservation_id(1);

        when(iReservationRepository.findById(any())).thenReturn(Optional.empty());

        String result = reservationService.updateReservation(reservationDTO);

        assertEquals(IResponse.UPDATE_FAIL, result);
        verify(iReservationRepository, times(1)).findById(any());
        verify(iReservationRepository, never()).save(any());
    }

    @Test
    public void testFindReservationSuccess(){
        Integer reservationId = 1;
        Reservation_Entity reservationEntity = new Reservation_Entity();
        when(iReservationRepository.findById(any())).thenReturn(Optional.of(reservationEntity));

        String result = reservationService.findReservation(reservationId);

        assertEquals(reservationEntity.toString(), Optional.of(reservationEntity).orElse(null).toString());
        verify(iReservationRepository,times(1)).findById(any());
    }

    @Test
    public void testFindReservationFail(){
        Integer reservationId = 1;
        when(iReservationRepository.findById(any())).thenReturn(Optional.empty());

        String result = reservationService.findReservation(reservationId);

        assertEquals(IResponse.NOT_FOUND, result);
        verify(iReservationRepository, times(1)).findById(any());

    }
}
