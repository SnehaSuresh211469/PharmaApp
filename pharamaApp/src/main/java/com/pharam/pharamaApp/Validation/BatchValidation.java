package com.pharam.pharamaApp.Validation;

import com.pharam.pharamaApp.DTO.BatchDTO;
import com.pharam.pharamaApp.Entity.Batch;
import com.pharam.pharamaApp.Entity.MedicineMaster;
import com.pharam.pharamaApp.Exception.PharmaBusinessException;
import com.pharam.pharamaApp.Repository.BatchRepository;
import com.pharam.pharamaApp.Repository.MedicineMasterRepository;
import com.pharam.pharamaApp.Repository.MedicineTypeMasterRepository;
import com.pharam.pharamaApp.Repository.ShippingMasterRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

import java.util.Optional;

@Component
public class BatchValidation {

    @Autowired
    private BatchRepository batchRepository;
    @Autowired
    private MedicineMasterRepository medicineMasterRepository;


    @Autowired
    private MedicineTypeMasterRepository medicineTypeMasterRepository;

    @Autowired
    private ShippingMasterRepository shippingMasterRepository;

    Logger logger = LoggerFactory.getLogger(BatchValidation.class);
    
    public  String addBatchValidation(BatchDTO batch) throws PharmaBusinessException {
        //batch weight <100
        if(batch.getWeight()<100) {
            logger.error("512-Batch Weight Should be greater than 100");
            throw  new PharmaBusinessException(PharmaBusinessException.PharmaBusinessExceptionCode.C,"batch weight <100");
        }
        
        //batch code not in the format “BTC-”
        if(!batch.getBatchCode().startsWith("BTC-"))   {
            logger.error("513-Batch format wrong.It should be in the format “BTC-1234”");
            throw  new PharmaBusinessException(PharmaBusinessException.PharmaBusinessExceptionCode.D,"wrong batch format");
        }
       return  "Ok";
    }

    public  String weightToRangeConverter(Double weight){
        
         if(weight<=500){
             return "W1";
         }
         
         if(weight<=1000){
             return  "W2";
         }
         else
             return  "W3";
    }
}
