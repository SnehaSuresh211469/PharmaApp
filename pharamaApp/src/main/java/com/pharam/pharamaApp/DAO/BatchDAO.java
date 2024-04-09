package com.pharam.pharamaApp.DAO;

import com.pharam.pharamaApp.DTO.BatchDTO;
import com.pharam.pharamaApp.Entity.Batch;
import com.pharam.pharamaApp.Entity.MedicineMaster;
import com.pharam.pharamaApp.Entity.ShippingMaster;
import com.pharam.pharamaApp.Exception.PharmaBusinessException;
import com.pharam.pharamaApp.Repository.BatchRepository;
import com.pharam.pharamaApp.Repository.MedicineMasterRepository;
import com.pharam.pharamaApp.Repository.MedicineTypeMasterRepository;
import com.pharam.pharamaApp.Repository.ShippingMasterRepository;
import com.pharam.pharamaApp.Validation.BatchValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class BatchDAO {
    @Autowired
    private BatchRepository batchRepository;
    
    @Autowired
    private MedicineMasterRepository medicineMasterRepository;


    @Autowired
    private MedicineTypeMasterRepository medicineTypeMasterRepository;

    @Autowired
    private BatchValidation batchValidation;
    @Autowired
    private ShippingMasterRepository shippingMasterRepository;

    Logger logger = LoggerFactory.getLogger(BatchDAO.class);
    public  Boolean addDetails(Batch batch){
        batchRepository.save(batch);
        return  true;
    }
    public Boolean checkBatchCode(BatchDTO batchDTO) throws PharmaBusinessException {
        //batchcode already exist
        Optional<Batch> batch1= Optional.ofNullable(batchRepository.findByBatchCode(batchDTO.getBatchCode()));
            if(!batch1.isEmpty()) {
                logger.error("511-Batchcode already exist");
                throw  new PharmaBusinessException(PharmaBusinessException.PharmaBusinessExceptionCode.B,"batchcode already exist");
            }
            return  false;
    }

    public  Boolean checkMedicineCode(String medicineCode) throws PharmaBusinessException {
        Optional<MedicineMaster> medicineMaster= Optional.ofNullable(medicineMasterRepository.findByMedicineCode(medicineCode));
        if(medicineMaster.isEmpty() ){
            logger.error("510-Medicine Code Does Not Exist");
            throw  new PharmaBusinessException(PharmaBusinessException.PharmaBusinessExceptionCode.A,"medicine code does not exist");
        }
        return  false;
    }

    public BigDecimal getShippingCharge(String medicineCode,String  weightRange,BatchDTO batchDTO){
        ShippingMaster shippingMaster= shippingMasterRepository.findByMedicineTypeCodeAndWeightRange(medicineCode,weightRange);
        if(batchDTO.getRefrigeration().equalsIgnoreCase("yes"))  {
            BigDecimal refrigerationCharge = shippingMaster.getShippingCharge().multiply(BigDecimal.valueOf(0.05));
            return  refrigerationCharge;
        }
        else {
            return  shippingMaster.getShippingCharge();
        }
    }
}
