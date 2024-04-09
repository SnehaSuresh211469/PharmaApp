package com.pharam.pharamaApp.Mapper;

import com.pharam.pharamaApp.DTO.BatchDTO;
import com.pharam.pharamaApp.Entity.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Mapper {
    
    @Autowired
    private  Batch batch;
    public Batch converToEntity(BatchDTO batchDTO, BigDecimal shippingCharge){
          batch.setBatchCode(batchDTO.getBatchCode());
          batch.setCareLevel(batchDTO.getCareLevel());
          batch.setWeight(batchDTO.getWeight());
          batch.setMedicineCode(batchDTO.getMedicineCode());
          batch.setShippingCharge(shippingCharge);
          batch.setMedicineTypeCode(batchDTO.getMedicineTypeCode());
          batch.setPrice(batchDTO.getPrice());
          return  batch;
    }
}
