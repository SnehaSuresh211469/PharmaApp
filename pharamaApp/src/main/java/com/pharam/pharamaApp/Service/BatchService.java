package com.pharam.pharamaApp.Service;

import com.pharam.pharamaApp.DAO.BatchDAO;
import com.pharam.pharamaApp.DTO.BatchDTO;
import com.pharam.pharamaApp.Exception.PharmaBusinessException;
import com.pharam.pharamaApp.Mapper.Mapper;
import com.pharam.pharamaApp.Repository.BatchRepository;
import com.pharam.pharamaApp.Repository.ShippingMasterRepository;
import com.pharam.pharamaApp.Validation.BatchValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BatchService {
    @Autowired
    private BatchValidation batchValidation;
    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private BatchDAO batchDAO;

    @Autowired
    private ShippingMasterRepository shippingMasterRepository;
    
    @Autowired
    private Mapper mapper;
    
    public Boolean addBatch(BatchDTO batchDTO) throws PharmaBusinessException {
        String str=batchValidation.addBatchValidation(batchDTO);
            if(str.equalsIgnoreCase("OK") && !batchDAO.checkBatchCode(batchDTO) && !batchDAO.checkMedicineCode(batchDTO.getMedicineCode()))
                {
                    return batchAdd(batchDTO);
                }
            return false;
    }
    public Boolean batchAdd(BatchDTO batchDTO) {
        BigDecimal shippingCharge=batchDAO.getShippingCharge(batchDTO.getMedicineTypeCode(),batchValidation.weightToRangeConverter(batchDTO.getWeight()),batchDTO);
        if(batchDTO.getWeight()<=500) {
               return batchDAO.addDetails(mapper.converToEntity(batchDTO,shippingCharge));
        }
        if(batchDTO.getWeight()<=1000) {

               return batchDAO.addDetails(mapper.converToEntity(batchDTO,shippingCharge));

        }
        if(batchDTO.getWeight()>1000) {
            return batchDAO.addDetails(mapper.converToEntity(batchDTO,shippingCharge));
        }
            return false;
    }
}
