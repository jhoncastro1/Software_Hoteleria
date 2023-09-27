package hoteleria.services.check_out;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.converter.checkOut.CheckOutConverter;
import hoteleria.commons.domains.dto.check_Out.Check_OutDTO;
import hoteleria.model.entity.check_out.Check_outEntity;
import hoteleria.model.repository.check_out.ICheck_outRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Check_outService {

    @Autowired
    private CheckOutConverter checkOutConverter;

    @Autowired
    private ICheck_outRepository iCheckOutRepository;

    public String createCheckOut(Check_outEntity checkOutEntity){
        try{
            Optional<Check_outEntity> find = this.iCheckOutRepository.findById(checkOutEntity.getCheckOutId());
            if (!find.isPresent()){
                this.iCheckOutRepository.save(checkOutEntity);
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

    public String deleteCheckOut(Integer checkOutId){
        try{
            Optional<Check_outEntity> find = iCheckOutRepository.findById(checkOutId);
            if (find.isPresent()){
                iCheckOutRepository.delete(find.get());
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

    public String updateCheckOut(Check_OutDTO checkOutDTO) {
        try {
            if (checkOutDTO == null || checkOutDTO.getCheckOutId() == null) {
                return IResponse.NOT_FOUND;
            }
            Optional<Check_outEntity> find = this.iCheckOutRepository.findById(checkOutDTO.getCheckOutId());
            if (find.isPresent()) {
                Check_outEntity checkOutEntity = checkOutConverter.convertCheckOutDTOToCheckOutEntity(checkOutDTO);
                this.iCheckOutRepository.save(checkOutEntity);
                return IResponse.OPERATION_SUCCESS;
            } else {
                return IResponse.OPERATION_FAIL;
            }
        } catch (Exception e) {
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }


            public String findCheckOut (Integer checkOutId){
                try {
                    Optional<Check_outEntity> find = this.iCheckOutRepository.findById(checkOutId);
                    if (find.isPresent()) {
                        String findCheckOut = find.toString();
                        return findCheckOut;
                    } else {
                        return IResponse.OPERATION_FAIL;
                    }
                } catch (Exception e) {
                    return IResponse.INTERNAL_SERVER_ERROR;
                }
            }
        }