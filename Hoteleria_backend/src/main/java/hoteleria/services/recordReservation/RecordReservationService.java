package hoteleria.services.recordReservation;

import hoteleria.commons.constans.response.IResponse;
import hoteleria.commons.converter.recordReservation.RecordReservationConverter;
import hoteleria.commons.domains.dto.recordReservation.RecordReservationDTO;
import hoteleria.model.entity.recordReservation.RecordReservationEntity;
import hoteleria.model.repository.recordReservation.IRecordReservationRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class RecordReservationService {


    @Autowired
    private RecordReservationConverter recordReservationConverter;
    @Autowired
    private IRecordReservationRepository iRecordReservationRepository;

    public String createRecordReservations(RecordReservationEntity recordReservationEntity){
        try {
            Optional<RecordReservationEntity> find = this.iRecordReservationRepository.findById(recordReservationEntity.getIdRecord());
            if (!find.isPresent()){
                this.iRecordReservationRepository.save(recordReservationEntity);
                return IResponse.OPERATION_SUCCESS;
            }else {
                return IResponse.OPERATION_FAIL;
            }
        }catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }

    public String deleteRecorReservations(Integer idRecord){
        try {
            Optional<RecordReservationEntity> find = this.iRecordReservationRepository.findById(idRecord);
            if (find.isPresent()){
                iRecordReservationRepository.delete(find.get());
                return IResponse.DELETE_SUCCESS;
            }else {
                return IResponse.DELETE_FAIL;
            }
        }
        catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;}
    }


    public String updateRecordReservations(RecordReservationDTO recordReservationDTO){
        try {
            if (recordReservationDTO == null || recordReservationDTO.getIdRecord() == null){
                return IResponse.NOT_FOUND;
            }
            Optional<RecordReservationEntity> find = this.iRecordReservationRepository.findById(recordReservationDTO.getIdRecord());
            if (find.isPresent()){
                RecordReservationEntity recordReservationEntity = recordReservationConverter.convertRecordReservationDTOToRecordReservationEntity(recordReservationDTO);
                iRecordReservationRepository.save(recordReservationEntity);
                return IResponse.OPERATION_SUCCESS;
            }else {
                return IResponse.OPERATION_FAIL;
            }
        }catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }


    public String findRecordReservation(Integer recordId){
        try {
            Optional<RecordReservationEntity> find = this.iRecordReservationRepository.findById(recordId);
            if (find.isPresent()){
                String findRecord = find.toString();
                return findRecord;
            }
            else {
                return IResponse.OPERATION_FAIL;
            }
        }catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }











}
