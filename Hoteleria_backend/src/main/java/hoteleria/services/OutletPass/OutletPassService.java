package hoteleria.services.OutletPass;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.converter.outletPass.OutletPassConverter;
import hoteleria.commons.domains.dto.outletPass.OutletPassDTO;
import hoteleria.model.entity.outletPass.OutletPassEntity;
import hoteleria.model.repository.outletPass.IOutletPassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OutletPassService {
    @Autowired
    private IOutletPassRepository iOutletPassRepository;

    @Autowired
    private OutletPassConverter outletPassConverter;

    public String createOutletPass(OutletPassEntity outletPassEntity){
        try {
            Optional<OutletPassEntity> find = iOutletPassRepository.findByNameCustomer(outletPassEntity.getNameCustomer());
            if (!find.isPresent()){
                this.iOutletPassRepository.save(outletPassEntity);
                return IResponse.CREATE_SUCCESS;
            }else {return IResponse.CREATE_FAIL;}
        }catch (Exception e){return IResponse.INTERNAL_SERVER_ERROR;}
    }

    public String deleteOutletPass(Integer idOutletPass){
        try {
            Optional<OutletPassEntity> find = iOutletPassRepository.findById(idOutletPass);
            if (find.isPresent()){
                this.iOutletPassRepository.delete(find.get());
                return IResponse.DELETE_SUCCESS;
            }else {return IResponse.DELETE_FAIL;}
        }catch (Exception e){return IResponse.INTERNAL_SERVER_ERROR;}
    }

    public String updateOutletPass(OutletPassDTO outletPassDTO){
        try {
            if (outletPassDTO == null || outletPassDTO.getIdOutletPass() == null){
                return IResponse.NOT_FOUND;
            }
            Optional<OutletPassEntity> find = iOutletPassRepository.findById(outletPassDTO.getIdOutletPass());
            if (find.isPresent()){
                OutletPassEntity outletPassEntity = outletPassConverter.convertOutletPassDTOToOutletPassEntity(outletPassDTO);
                return IResponse.UPDATE_SUCCESS;
            }else {return IResponse.UPDATE_FAIL;}
        }catch (Exception e){return IResponse.INTERNAL_SERVER_ERROR;}
    }

    public String findOutletPass(Integer idOutletPass){
        try {
            Optional<OutletPassEntity> find = iOutletPassRepository.findById(idOutletPass);
            if (find.isPresent()){
                String findOutlet = find.toString();
                return findOutlet;
            }else {
                return IResponse.NOT_FOUND;
            }
        }catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }



}
