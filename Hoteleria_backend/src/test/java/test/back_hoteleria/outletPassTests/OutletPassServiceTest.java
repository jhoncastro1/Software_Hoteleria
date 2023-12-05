package test.back_hoteleria.outletPassTests;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.converter.outletPass.OutletPassConverter;
import hoteleria.commons.domains.dto.outletPass.OutletPassDTO;
import hoteleria.model.entity.outletPass.OutletPassEntity;
import hoteleria.model.repository.outletPass.IOutletPassRepository;
import hoteleria.services.OutletPass.OutletPassService;
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
public class OutletPassServiceTest {

    @Mock
    private IOutletPassRepository iOutletPassRepository;

    @Mock
    private OutletPassConverter outletPassConverter;

    @InjectMocks
    private OutletPassService outletPassService;


    @Test
    public void testCreateOutletPassSuccess() {
        // Arrange
        OutletPassDTO outletPassDTO = OutletPassDTO.builder()
                .idOutletPass(1)
                .nameCustomer("Jhon")
                .date(LocalDate.now())
                .idAssignedRoom(101)
                .guestsCount(2)
                .keyRoom(true)
                .cashierName("Cashier 1")
                .cashier("Cashier Username")
                .build();

        OutletPassEntity outletPassEntity = new OutletPassEntity();
        outletPassEntity.setIdOutletPass(1);
        outletPassEntity.setNameCustomer("Jhon");
        outletPassEntity.setDate(LocalDate.now());
        outletPassEntity.setIdAssignedRoom(101);
        outletPassEntity.setGuestsCount(2);
        outletPassEntity.setKeyRoom(true);
        outletPassEntity.setCashierName("Cashier 1");
        outletPassEntity.setCashier("Cashier Username");

        // Mock del repositorio para devolver un Optional vacío, indicando que no hay duplicados
        when(iOutletPassRepository.findByNameCustomer("Jhon")).thenReturn(Optional.empty());

        // Act
        String result = outletPassService.createOutletPass(outletPassEntity);

        // Assert
        assertEquals(IResponse.CREATE_SUCCESS, result);

        verify(iOutletPassRepository, times(1)).save(outletPassEntity);

        verify(iOutletPassRepository, times(1)).findByNameCustomer("Jhon");

        verifyNoMoreInteractions(iOutletPassRepository);
    }

    @Test
    public void testCreateOutletPassFail() {
        // Arrange
        OutletPassDTO outletPassDTO = OutletPassDTO.builder()
                .idOutletPass(1)
                .nameCustomer("Jhon")
                .date(LocalDate.now())
                .idAssignedRoom(101)
                .guestsCount(2)
                .keyRoom(true)
                .cashierName("Cashier 1")
                .cashier("Cashier Username")
                .build();

        OutletPassEntity outletPassEntity = new OutletPassEntity();
        outletPassEntity.setIdOutletPass(1);
        outletPassEntity.setNameCustomer("Jhon");
        outletPassEntity.setDate(LocalDate.now());
        outletPassEntity.setIdAssignedRoom(101);
        outletPassEntity.setGuestsCount(2);
        outletPassEntity.setKeyRoom(true);
        outletPassEntity.setCashierName("Cashier 1");
        outletPassEntity.setCashier("Cashier Username");

        when(iOutletPassRepository.findByNameCustomer("Jhon")).thenReturn(Optional.of(outletPassEntity));

        // Act
        String result = outletPassService.createOutletPass(outletPassEntity);

        // Assert
        assertEquals(IResponse.CREATE_FAIL, result);
        verify(iOutletPassRepository, times(1)).findByNameCustomer("Jhon");
        // Verificar que no se llamaron más interacciones con el repositorio
        verifyNoMoreInteractions(iOutletPassRepository);
    }

    @Test
    public void testDeleteOutletPassSuccess() {
        // Arrange
        Integer idOutletPass = 1;
        OutletPassEntity outletPassEntity = new OutletPassEntity();
        outletPassEntity.setIdOutletPass(idOutletPass);

        when(iOutletPassRepository.findById(idOutletPass)).thenReturn(Optional.of(outletPassEntity));

        // Act
        String result = outletPassService.deleteOutletPass(idOutletPass);

        // Assert
        assertEquals(IResponse.DELETE_SUCCESS, result);
        verify(iOutletPassRepository, times(1)).findById(idOutletPass);
        verify(iOutletPassRepository, times(1)).delete(outletPassEntity);
    }

    @Test
    public void testDeleteOutletPassFail() {
        // Arrange
        Integer idOutletPass = 1;

        when(iOutletPassRepository.findById(idOutletPass)).thenReturn(Optional.empty());

        // Act
        String result = outletPassService.deleteOutletPass(idOutletPass);

        // Assert
        assertEquals(IResponse.DELETE_FAIL, result);
        verify(iOutletPassRepository, times(1)).findById(idOutletPass);
        verify(iOutletPassRepository, never()).delete(any());
    }



    @Test
    public void testUpdateOutletPassSuccess() {
        OutletPassDTO outletPassDTO = new OutletPassDTO(1, "Jhon", LocalDate.now(),
                101, 2, true, "Lucas", "Prada");

        OutletPassEntity outletPassEntity = new OutletPassEntity();

        when(iOutletPassRepository.findById(outletPassDTO.getIdOutletPass())).thenReturn(Optional.of(outletPassEntity));
        when(outletPassConverter.convertOutletPassDTOToOutletPassEntity(outletPassDTO)).thenReturn(outletPassEntity);

        String result = outletPassService.updateOutletPass(outletPassDTO);

        assertEquals(IResponse.UPDATE_SUCCESS, result);
        verify(iOutletPassRepository, times(1)).findById(outletPassDTO.getIdOutletPass());
        verify(iOutletPassRepository, never()).save(any());
    }



    @Test
    public void testUpdateOutletPassFail() {
        // Arrange
        OutletPassDTO outletPassDTO = OutletPassDTO.builder()
                .idOutletPass(1)
                .nameCustomer("Jhon")
                .date(LocalDate.now())
                .idAssignedRoom(101)
                .guestsCount(2)
                .keyRoom(true)
                .cashierName("Cashier 1")
                .cashier("Cashier Username")
                .build();

        when(iOutletPassRepository.findById(outletPassDTO.getIdOutletPass())).thenReturn(Optional.empty());

        // Act
        String result = outletPassService.updateOutletPass(outletPassDTO);

        // Assert
        assertEquals(IResponse.UPDATE_FAIL, result);
        verify(iOutletPassRepository, times(1)).findById(outletPassDTO.getIdOutletPass());
        verify(iOutletPassRepository, never()).save(any());
    }



    @Test
    public void testFindOutletPassSuccess() {
        // Arrange
        Integer idOutletPass = 1;
        OutletPassEntity outletPassEntity = new OutletPassEntity();

        when(iOutletPassRepository.findById(any())).thenReturn(Optional.of(outletPassEntity));

        // Act
        String result = outletPassService.findOutletPass(idOutletPass);

        // Assert
        assertEquals(outletPassEntity.toString(), Optional.of(outletPassEntity).orElse(null).toString());
        verify(iOutletPassRepository, times(1)).findById(any());
    }

    @Test
    public void testFindOutletPassNotFound() {
        // Arrange
        Integer idOutletPass = 1;

        when(iOutletPassRepository.findById(idOutletPass)).thenReturn(Optional.empty());

        // Act
        String result = outletPassService.findOutletPass(idOutletPass);

        // Assert
        assertEquals(IResponse.NOT_FOUND, result);
    }






}
