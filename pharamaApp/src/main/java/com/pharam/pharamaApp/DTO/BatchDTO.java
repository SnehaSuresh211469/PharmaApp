package com.pharam.pharamaApp.DTO;


import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BatchDTO {

    private  String batchCode;

    private String medicineCode;

    private Double weight;

    private  String medicineTypeCode;
    private  String careLevel;

    private  String refrigeration;

    private BigDecimal price;

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getMedicineCode() {
        return medicineCode;
    }

    public String getRefrigeration() {
        return refrigeration;
    }


    public String getMedicineTypeCode() {
        return medicineTypeCode;
    }

    public void setMedicineTypeCode(String medicineTypeCode) {
        this.medicineTypeCode = medicineTypeCode;
    }

    public void setRefrigeration(String refrigeration) {
        this.refrigeration = refrigeration;
    }

    public void setMedicineCode(String medicineCode) {
        this.medicineCode = medicineCode;
    }


    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getCareLevel() {
        return careLevel;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCareLevel(String careLevel) {
        this.careLevel = careLevel;
    }


}
