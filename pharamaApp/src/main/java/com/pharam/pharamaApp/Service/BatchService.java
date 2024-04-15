package com.pharam.pharamaApp.Service;

import com.pharam.pharamaApp.DAO.BatchDAO;
import com.pharam.pharamaApp.DTO.BatchDTO;
import com.pharam.pharamaApp.Exception.PharmaBusinessException;
import com.pharam.pharamaApp.Mapper.Mapper;
import com.pharam.pharamaApp.Repository.BatchRepository;
import com.pharam.pharamaApp.Repository.ShippingMasterRepository;
import com.pharam.pharamaApp.Validation.BatchValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger(BatchService.class);
    public Boolean addBatch(BatchDTO batchDTO) throws PharmaBusinessException {
        final  String METHOD_NAME= "addBatch";
        Boolean response=false;
        logger.info("method invocked"+ METHOD_NAME + ":" + batchDTO);
        String str=batchValidation.addBatchValidation(batchDTO);
            if(str.equalsIgnoreCase("OK") && !batchDAO.checkBatchCode(batchDTO) && !batchDAO.checkMedicineCode(batchDTO.getMedicineCode()))
                {
                    response= batchAdd(batchDTO);
                }
//            return false;
       return response ;
    }
    public Boolean batchAdd(BatchDTO batchDTO) throws PharmaBusinessException {
        BigDecimal shippingCharge=batchDAO.getShippingCharge(batchDTO.getMedicineTypeCode(),batchValidation.weightToRangeConverter(batchDTO.getWeight()));
        if(batchDTO.getWeight()<=500) {
            if(batchDTO.getRefrigeration().equalsIgnoreCase("yes"))  {
                BigDecimal refrigerationCharge = shippingCharge.multiply(BigDecimal.valueOf(0.05));
                return batchDAO.addDetails(mapper.converToEntity(batchDTO,refrigerationCharge));
            }
            else {
                return batchDAO.addDetails(mapper.converToEntity(batchDTO,shippingCharge));
            }
        }
        if(batchDTO.getWeight()<=1000) {

            if(batchDTO.getRefrigeration().equalsIgnoreCase("yes"))  {
                BigDecimal refrigerationCharge = shippingCharge.multiply(BigDecimal.valueOf(0.05));
                return batchDAO.addDetails(mapper.converToEntity(batchDTO,refrigerationCharge));
            }
            else {
                return batchDAO.addDetails(mapper.converToEntity(batchDTO,shippingCharge));
            }

        }
        if(batchDTO.getWeight()>1000) {
            if(batchDTO.getRefrigeration().equalsIgnoreCase("yes"))  {
                BigDecimal refrigerationCharge = shippingCharge.multiply(BigDecimal.valueOf(0.05));
                return batchDAO.addDetails(mapper.converToEntity(batchDTO,refrigerationCharge));
            }
            else {
                return batchDAO.addDetails(mapper.converToEntity(batchDTO,shippingCharge));
            }
        }
            return false;
    }
}
