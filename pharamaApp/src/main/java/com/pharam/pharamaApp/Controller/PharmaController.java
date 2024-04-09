package com.pharam.pharamaApp.Controller;


import com.pharam.pharamaApp.DTO.BatchDTO;
import com.pharam.pharamaApp.Exception.PharmaBusinessException;
import com.pharam.pharamaApp.Service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PharmaController {

    @Autowired
    private BatchService batchService;
     @PostMapping("/addBatch")
     public Boolean addBatch(@RequestBody BatchDTO batchDTO) throws PharmaBusinessException {
        return batchService.addBatch(batchDTO);
    }
}
