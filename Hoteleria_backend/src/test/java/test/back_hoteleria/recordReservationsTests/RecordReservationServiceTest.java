package test.back_hoteleria.recordReservationsTests;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.converter.recordReservation.RecordReservationConverter;
import hoteleria.commons.domains.dto.recordReservation.RecordReservationDTO;
import hoteleria.model.entity.recordReservation.RecordReservationEntity;
import hoteleria.model.repository.recordReservation.IRecordReservationRepository;
import hoteleria.services.recordReservation.RecordReservationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RecordReservationServiceTest {

    @Mock
    private IRecordReservationRepository iRecordReservationRepository;

    @Mock
    private RecordReservationConverter recordReservationConverter;

    @InjectMocks
    private RecordReservationService recordReservationService;


    @Test
    public void testCreateRecordReservationsSuccess() {
        RecordReservationEntity recordReservationEntity = new RecordReservationEntity();
        when(iRecordReservationRepository.findById(recordReservationEntity.getIdRecord())).thenReturn(Optional.empty());

        String result = recordReservationService.createRecordReservations(recordReservationEntity);

        assertEquals(IResponse.OPERATION_SUCCESS, result);
        verify(iRecordReservationRepository, times(1)).save(recordReservationEntity);
    }

    @Test
    public void testCreateRecordReservationsFail() {
        RecordReservationEntity recordReservationEntity = new RecordReservationEntity();
        when(iRecordReservationRepository.findById(recordReservationEntity.getIdRecord())).thenReturn(Optional.of(recordReservationEntity));

        String result = recordReservationService.createRecordReservations(recordReservationEntity);

        assertEquals(IResponse.OPERATION_FAIL, result);
        verify(iRecordReservationRepository, never()).save(any());
    }

    @Test
    public void testDeleteRecorReservationsSuccess(){
        //Arrange
        Integer idRecord = 1;
        RecordReservationEntity recordReservationEntity = new RecordReservationEntity();
        recordReservationEntity.setIdRecord(idRecord);

        when(iRecordReservationRepository.findById(idRecord)).thenReturn(Optional.of(recordReservationEntity));

        String result = recordReservationService.deleteRecorReservations(idRecord);

        assertEquals(IResponse.DELETE_SUCCESS, result);

        verify(iRecordReservationRepository, times(1)).findById(idRecord);
        verify(iRecordReservationRepository, times(1)).delete(recordReservationEntity);

    }

    @Test
    public void testDeleteRecorReservationsFail(){
        Integer idRecord = 1;

        when(iRecordReservationRepository.findById(idRecord)).thenReturn(Optional.empty());

        String result = recordReservationService.deleteRecorReservations(idRecord);

        assertEquals(IResponse.DELETE_FAIL, result);

        verify(iRecordReservationRepository, times(1)).findById(idRecord);
    }
}
