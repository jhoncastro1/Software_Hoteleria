package test.back_hoteleria.payTests;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.converter.pay.PayConverter;
import hoteleria.commons.domains.dto.pay.PayDTO;
import hoteleria.model.entity.pay.PayEntity;
import hoteleria.model.repository.pay.IPayRepository;
import hoteleria.services.pay.PayService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PayServiceTest {

    @Mock
    private IPayRepository iPayRepository;

    @Mock
    private PayConverter payConverter;

    @InjectMocks
    private PayService payService;

    @Test
    void testCreatePaySuccess(){
        PayEntity payEntity = new PayEntity();
        when(iPayRepository.findById(payEntity.getId_pay())).thenReturn(Optional.empty());

        String result = payService.createPay(payEntity);

        assertEquals(IResponse.CREATE_SUCCESS, result);
        verify(iPayRepository, times(1)).save(payEntity);
    }
    @Test
    void testCreatePayFail(){
        PayEntity payEntity = new PayEntity();
        when(iPayRepository.findById(payEntity.getId_pay())).thenReturn(Optional.of(payEntity));
        String result = payService.createPay(payEntity);
        assertEquals(IResponse.CREATE_FAIL, result);
        verify(iPayRepository, never()).save(any());
    }

    @Test
    void testDeletePaySuccess(){
        Integer payId = 1;
        PayEntity payEntity = new PayEntity();
        payEntity.setId_pay(payId);

        when(iPayRepository.findById(payId)).thenReturn(Optional.of(payEntity));

        String result = payService.deletePay(payId);

        assertEquals(IResponse.DELETE_SUCCESS, result);
        verify(iPayRepository, times(1)).findById(payId);
        verify(iPayRepository, times(1)).delete(payEntity);
    }

    @Test
    void testDeletePayFail(){
        Integer payId = 1;
        when(iPayRepository.findById(payId)).thenReturn(Optional.empty());

        String result = payService.deletePay(payId);
        assertEquals(IResponse.DELETE_FAIL, result);

        verify(iPayRepository, times(1)).findById(payId);

    }

    @Test
    void testUpdatePaySuccess(){
        PayDTO payDTO = new PayDTO();
        payDTO.setId_pay(1);
        PayEntity payEntity = new PayEntity();

        when(iPayRepository.findById(payDTO.getId_pay())).thenReturn(Optional.of(payEntity));
        when(payConverter.convertPayDTOToPayEntity(payDTO)).thenReturn(payEntity);

        String result = payService.updatePay(payDTO);

        assertEquals(IResponse.UPDATE_SUCCESS, result);

        verify(iPayRepository, times(1)).findById(payDTO.getId_pay());
        verify(iPayRepository, times(1)).save(payEntity);

    }
    @Test
    void testUpdatePayFail(){
        PayDTO payDTO = new PayDTO();
        payDTO.setId_pay(1);
        when(iPayRepository.findById(any())).thenReturn(Optional.empty());

        String result = payService.updatePay(payDTO);

        assertEquals(IResponse.UPDATE_FAIL, result);

        verify(iPayRepository, times(1)).findById(any());
        verify(iPayRepository, never()).save(any());
    }

    @Test
    void testFindPaySuccess(){
        Integer payId = 1;
        PayEntity payEntity = new PayEntity();
        when(iPayRepository.findById(any())).thenReturn(Optional.of(payEntity));

        String result = payService.findPay(payId);

        assertEquals(payEntity.toString(), Optional.of(payEntity).orElse(null).toString());
        verify(iPayRepository, times(1)).findById(any());
    }

    @Test
    void testFindPayFail(){
        Integer payId = 1;
        when(iPayRepository.findById(any())).thenReturn(Optional.empty());

        String result = payService.findPay(payId);

        assertEquals(IResponse.NOT_FOUND, result);
        verify(iPayRepository, times(1)).findById(any());

    }
}
