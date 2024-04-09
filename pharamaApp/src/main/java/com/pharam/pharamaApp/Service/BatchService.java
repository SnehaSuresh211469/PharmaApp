package com.pharam.pharamaApp.Service;

import com.pharam.pharamaApp.DTO.BatchDTO;
import com.pharam.pharamaApp.Entity.ShippingMaster;
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
    private ShippingMasterRepository shippingMasterRepository;
    
    @Autowired
    private Mapper mapper;
    
    public Boolean addBatch(BatchDTO batchDTO) throws PharmaBusinessException {
        String str=batchValidation.addBatchValidation(batchDTO);
        if(str.equalsIgnoreCase("OK"))   {
            batchAdd(batchDTO);
            return  true;
        }
        return false;
    }
    public void batchAdd(BatchDTO batchDTO) {
        if(batchDTO.getWeight()<=500) {
            ShippingMaster shippingMaster= shippingMasterRepository.findByMedicineTypeCodeAndWeightRange(batchDTO.getMedicneTypeCode(),batchValidation.weightToRangeConverter(batchDTO.getWeight()));
            if(batchDTO.getRefrigeration().equalsIgnoreCase("yes"))  {
                 BigDecimal refrigerationCharge = shippingMaster.getShippingCharge().multiply(BigDecimal.valueOf(0.05));
                batchRepository.save( mapper.converToEntity(batchDTO,refrigerationCharge));
             }
             else {
                 batchRepository.save(mapper.converToEntity(batchDTO,shippingMaster.getShippingCharge()));
             }

        }
        if(batchDTO.getWeight()<=1000) {
            ShippingMaster shippingMaster = shippingMasterRepository.findByMedicineTypeCodeAndWeightRange(batchDTO.getMedicneTypeCode(), batchValidation.weightToRangeConverter(batchDTO.getWeight()));
            if (batchDTO.getRefrigeration().equalsIgnoreCase("yes")) {
                BigDecimal refrigerationCharge = shippingMaster.getShippingCharge().multiply(BigDecimal.valueOf(0.05));
                batchRepository.save(mapper.converToEntity(batchDTO, refrigerationCharge));
            } else {
               batchRepository.save( mapper.converToEntity(batchDTO, shippingMaster.getShippingCharge()));
            }
        }
            if(batchDTO.getWeight()>1000) {
                ShippingMaster shippingMaster= shippingMasterRepository.findByMedicineTypeCodeAndWeightRange(batchDTO.getMedicneTypeCode(),batchValidation.weightToRangeConverter(batchDTO.getWeight()));
                if(batchDTO.getRefrigeration().equalsIgnoreCase("yes"))  {
                    BigDecimal refrigerationCharge = shippingMaster.getShippingCharge().multiply(BigDecimal.valueOf(0.05));
                   batchRepository.save( mapper.converToEntity(batchDTO,refrigerationCharge));
                }
                else {
                    batchRepository.save(mapper.converToEntity(batchDTO,shippingMaster.getShippingCharge()));
                }
        }
    }
}
