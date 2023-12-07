package test.back_hoteleria.hotelRegistrationTests;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.converter.hotelRegistration.HotelRegistrationConverter;
import hoteleria.commons.domains.dto.hotelRegistration.HotelRegistrationDTO;
import hoteleria.model.entity.hotelRegistration.HotelRegistrationEntity;
import hoteleria.model.repository.hotelRegistration.IHotelRegistrationRepository;
import hoteleria.services.hotelRegistration.HotelRegistrationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HotelRegistrationServiceTest {

    @Mock
    private IHotelRegistrationRepository iHotelRegistrationRepository;

    @Mock
    private HotelRegistrationConverter hotelRegistrationConverter;

    @InjectMocks
    private HotelRegistrationService hotelRegistrationService;


    @Test
    public void testCreateHotelRegistrationSuccess(){
        HotelRegistrationEntity hotelRegistrationEntity = new HotelRegistrationEntity();

        when(iHotelRegistrationRepository.findById(hotelRegistrationEntity.getIdHotelRegistration())).thenReturn(Optional.empty());

        String result = hotelRegistrationService.createHotelRegistration(hotelRegistrationEntity);

        assertEquals(IResponse.CREATE_SUCCESS,result);

        verify(iHotelRegistrationRepository, times(1)).save(hotelRegistrationEntity);

    }

    @Test
    public void testCreateHotelRegistrationFail(){
        HotelRegistrationEntity hotelRegistrationEntity = new HotelRegistrationEntity();
        when(iHotelRegistrationRepository.findById(hotelRegistrationEntity.getIdHotelRegistration())).thenReturn(Optional.of(hotelRegistrationEntity));

        String result = hotelRegistrationService.createHotelRegistration(hotelRegistrationEntity);

        assertEquals(IResponse.CREATE_FAIL, result);
        verify(iHotelRegistrationRepository, never()).save(any());
    }

    @Test
    public void testDeleteHotelRegistrationSuccess(){
        Integer idHotel = 1;
        HotelRegistrationEntity hotelRegistrationEntity = new HotelRegistrationEntity();
        hotelRegistrationEntity.setIdHotelRegistration(idHotel);

        when(iHotelRegistrationRepository.findById(idHotel)).thenReturn(Optional.of(hotelRegistrationEntity));
        String result = hotelRegistrationService.deleteHotelRegistration(idHotel);

        assertEquals(IResponse.DELETE_SUCCESS, result);

        verify(iHotelRegistrationRepository, times(1)).findById(idHotel);
        verify(iHotelRegistrationRepository, times(1)).delete(hotelRegistrationEntity);

    }

    @Test
    public void testDeleteHotelRegistrationFail(){
        Integer idHotel = 1;

        when(iHotelRegistrationRepository.findById(idHotel)).thenReturn(Optional.empty());

        String result = hotelRegistrationService.deleteHotelRegistration(idHotel);

        assertEquals(IResponse.DELETE_FAIL, result);

        verify(iHotelRegistrationRepository, times(1)).findById(idHotel);
    }

    @Test
    public void testUpdateHotelRegistrationSuccess() {
        //

        HotelRegistrationDTO hotelRegistrationDTO = new HotelRegistrationDTO(
                1, "Jhon", "Nacionalidad", "Dirección", "Ciudad", "País", "Teléfono",
                "Tipo de ID", new Date(), new Date(), "Empresa", "Teléfono de la empresa", "Transporte",
                "11111", "No se", "Reserva", "Motivo del viaje", "Proveniencia", "Estancia",
                "Destino", "Firma", "Aceptar contrato de alojamiento", 100.0
        );


        HotelRegistrationEntity hotelRegistrationEntity = new HotelRegistrationEntity();
        when(iHotelRegistrationRepository.findById(1)).thenReturn(Optional.of(hotelRegistrationEntity));
        when(hotelRegistrationConverter.convertHotelRegistrationDTOToHotelRegistrationEntity(hotelRegistrationDTO))
                .thenReturn(hotelRegistrationEntity);

        // Act
        String result = hotelRegistrationService.updateHotelRegistration(hotelRegistrationDTO);

        // Assert
        assertEquals(IResponse.UPDATE_SUCCESS, result);
        verify(iHotelRegistrationRepository, times(1)).findById(1);
        verify(iHotelRegistrationRepository, times(1)).save(hotelRegistrationEntity);
    }
    @Test
    public void testUpdateHotelRegistrationFail() {
        // Arrange
        HotelRegistrationDTO hotelRegistrationDTO = new HotelRegistrationDTO(
                1, "Jhon", "Nacionalidad", "Dirección", "Ciudad", "País", "Teléfono",
                "Tipo de ID", new Date(), new Date(), "Empresa", "Teléfono de la empresa", "Transporte",
                "11111", "No se", "Reserva", "Motivo del viaje", "Proveniencia", "Estancia",
                "Destino", "Firma", "Aceptar contrato de alojamiento", 100.0
        );
        when(iHotelRegistrationRepository.findById(hotelRegistrationDTO.getIdHotelRegistration())).thenReturn(Optional.empty());

        // Act
        String result = hotelRegistrationService.updateHotelRegistration(hotelRegistrationDTO);

        // Assert
        assertEquals(IResponse.UPDATE_FAIL, result);
       verify(iHotelRegistrationRepository, times(1)).findById(hotelRegistrationDTO.getIdHotelRegistration());
       verify(iHotelRegistrationRepository, never()).save(any());
    }
    @Test
    public void testFindHotelRegistrationSuccess(){
        Integer idHotelRegistration = 1;

        HotelRegistrationEntity hotelRegistrationEntity = new HotelRegistrationEntity();
        when(iHotelRegistrationRepository.findById(any())).thenReturn(Optional.of(hotelRegistrationEntity));

        String result = hotelRegistrationService.findHotelRegistration(idHotelRegistration);

        assertEquals(hotelRegistrationEntity.toString(), Optional.of(hotelRegistrationEntity).orElse(null).toString());
        verify(iHotelRegistrationRepository, times(1)).findById(any());
    }

    @Test
    public void testFindHotelRegistrationFail(){
        Integer idHotelRegistration = 1;

        when(iHotelRegistrationRepository.findById(idHotelRegistration)).thenReturn(Optional.empty());
        String result = hotelRegistrationService.findHotelRegistration(idHotelRegistration);

        assertEquals(IResponse.NOT_FOUND, result);
        verify(iHotelRegistrationRepository, times(1)).findById(idHotelRegistration);
    }
}
