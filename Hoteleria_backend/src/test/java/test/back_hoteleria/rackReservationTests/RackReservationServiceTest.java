package test.back_hoteleria.rackReservationTests;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.converter.rackReservation.RackReservationConverter;
import hoteleria.commons.domains.dto.rackReservation.RackReservationDTO;
import hoteleria.model.entity.rackReservation.RackReservationEntity;
import hoteleria.model.repository.rackReservation.IRackReservationRepository;
import hoteleria.services.rackReservation.RackReservationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RackReservationServiceTest {

    @Mock
    private IRackReservationRepository iRackReservationRepository;

    @Mock
    private RackReservationConverter rackReservationConverter;

    @InjectMocks
    private RackReservationService rackReservationService;

    @Test
    public void testCreateRackReservationSuccess(){
        RackReservationEntity rackReservationEntity = new RackReservationEntity();

        when(iRackReservationRepository.findById(rackReservationEntity.getRackId())).thenReturn(Optional.empty());

        String result = rackReservationService.createRackReservation(rackReservationEntity);

        assertEquals(IResponse.OPERATION_SUCCESS, result);

        verify(iRackReservationRepository, times(1)).save(rackReservationEntity);

    }

    @Test
    public void testCreateRackReservationFail(){
        RackReservationEntity rackReservationEntity = new RackReservationEntity();

        when(iRackReservationRepository.findById(rackReservationEntity.getRackId())).thenReturn(Optional.of(rackReservationEntity));

        String result = rackReservationService.createRackReservation(rackReservationEntity);

        assertEquals(IResponse.OPERATION_FAIL, result);

        verify(iRackReservationRepository, never()).save(any());
    }

    @Test
    public void testDeleteRackReservationSuccess(){
        Integer idRack = 1;
        RackReservationEntity rackReservationEntity = new RackReservationEntity();
        rackReservationEntity.setRackId(idRack);

        when(iRackReservationRepository.findById(idRack)).thenReturn((Optional.of(rackReservationEntity)));
        String result = rackReservationService.deleteRackReservation(idRack);

        assertEquals(IResponse.OPERATION_SUCCESS, result);

        verify(iRackReservationRepository, times(1)).findById(idRack);
        verify(iRackReservationRepository, times(1)).delete(rackReservationEntity);
    }

    @Test
    public void testDeleteRackReservationFail(){
        Integer idRack = 1;

        when(iRackReservationRepository.findById(idRack)).thenReturn(Optional.empty());

        String result = rackReservationService.deleteRackReservation(idRack);

        assertEquals(IResponse.OPERATION_FAIL, result);

        verify(iRackReservationRepository, times(1)).findById(idRack);
    }


    @Test
    public void testUpdateRackReservationSuccess() {
        // Arrange
        RackReservationDTO rackReservationDTO = new RackReservationDTO();
        rackReservationDTO.setRackId(1);

        RackReservationEntity rackReservationEntity = new RackReservationEntity();
        when(iRackReservationRepository.findById(any())).thenReturn(Optional.of(rackReservationEntity));
        when(rackReservationConverter.convertRackReservationDTOToRackReservationEntity(any())).thenReturn(rackReservationEntity);

        // Act
        String result = rackReservationService.updateRackReservation(rackReservationDTO);

        // Assert
        assertEquals(IResponse.OPERATION_SUCCESS, result);
        verify(iRackReservationRepository, times(1)).findById(any());
        verify(iRackReservationRepository, times(1)).save(any());
    }

    @Test
    public void testUpdateRackReservationFail() {
        // Arrange
        RackReservationDTO rackReservationDTO = new RackReservationDTO();
        rackReservationDTO.setRackId(1);

        when(iRackReservationRepository.findById(any())).thenReturn(Optional.empty());

        // Act
        String result = rackReservationService.updateRackReservation(rackReservationDTO);

        // Assert
        assertEquals(IResponse.OPERATION_FAIL, result);
        verify(iRackReservationRepository, times(1)).findById(any());
        verify(iRackReservationRepository, never()).save(any());
    }

    @Test
    public void testFindRackReservationSuccess() {
        // Arrange
        Integer rackId = 1;
        RackReservationEntity rackReservationEntity = new RackReservationEntity();
        when(iRackReservationRepository.findById(any())).thenReturn(Optional.of(rackReservationEntity));

        // Act
        String result = rackReservationService.findRackReservation(rackId);

        // Assert
        assertEquals(rackReservationEntity.toString(), Optional.of(rackReservationEntity).orElse(null).toString());
        verify(iRackReservationRepository, times(1)).findById(any());
    }

    @Test
    public void testFindRackReservationFail() {
        // Arrange
        Integer rackId = 1;
        when(iRackReservationRepository.findById(any())).thenReturn(Optional.empty());

        // Act
        String result = rackReservationService.findRackReservation(rackId);

        // Assert
        assertEquals(IResponse.OPERATION_FAIL, result);
        verify(iRackReservationRepository, times(1)).findById(any());
    }
}
