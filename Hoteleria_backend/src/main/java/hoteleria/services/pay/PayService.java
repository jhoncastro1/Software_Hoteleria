package hoteleria.services.pay;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.converter.pay.PayConverter;
import hoteleria.commons.domains.dto.pay.PayDTO;
import hoteleria.model.entity.pay.PayEntity;
import hoteleria.model.repository.pay.IPayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PayService {

    @Autowired
    private IPayRepository iPayRepository;

    @Autowired
    private PayConverter payConverter;

    public String createPay(PayEntity payEntity){
        try{
            Optional<PayEntity> find = iPayRepository.findById(payEntity.getId_pay());
            if (!find.isPresent()){
                this.iPayRepository.save(payEntity);
                return IResponse.CREATE_SUCCESS;
            }else {
                return IResponse.CREATE_FAIL;
            }

        }catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }

    public String deletePay(Integer id_Pay){
        try{
            Optional<PayEntity> find = iPayRepository.findById(id_Pay);
            if (find.isPresent()){
                this.iPayRepository.delete(find.get());
                return IResponse.DELETE_SUCCESS;
            }else {
                return IResponse.DELETE_FAIL;
            }
        }catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }

    public String updatePay(PayDTO payDTO){
        try{
            if (payDTO == null || payDTO.getId_pay() == null){
                return IResponse.NOT_FOUND;
            }
            Optional<PayEntity> find = this.iPayRepository.findById(payDTO.getId_pay());
            if (find.isPresent()){
                PayEntity payEntity = payConverter.convertPayDTOToPayEntity(payDTO);
                this.iPayRepository.save(payEntity);
                return IResponse.UPDATE_SUCCESS;
            }else {return IResponse.UPDATE_FAIL;}
        }catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }

    public String findPay(Integer id_Pay){
        try{
            Optional<PayEntity> find = iPayRepository.findById(id_Pay);
            if (find.isPresent()){
                String pay = find.toString();
                return pay;
            }else {return IResponse.NOT_FOUND;}

        }catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }
}
