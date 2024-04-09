package com.pharam.pharamaApp.Entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Entity
@Table(name = "batch_info")
@Component
public class Batch
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private  Integer id;
    @Column(name = "BATCH_CODE")
    private  String batchCode;

    @Column(name = "MEDICINE_CODE")
    private String medicineCode;

    @Column(name ="WEIGHT")
    private Double weight;

    @Column(name ="MEDICINE_TYPE_CODE")
    private  String medicineTypeCode;

    @Column(name = "CARE_LEVEL")
    private  String careLevel;


    @Column(name = "SHIPPING_CHARGE")
     private  BigDecimal shippingCharge;

    @Column(name = "PRICE")
    private  BigDecimal price;


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getMedicineCode() {
        return medicineCode;
    }

    public String getMedicineTypeCode() {
        return medicineTypeCode;
    }

    public void setMedicineTypeCode(String medicineTypeCode) {
        this.medicineTypeCode = medicineTypeCode;
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

    public void setCareLevel(String careLevel) {
        this.careLevel = careLevel;
    }
    public BigDecimal getShippingCharge() {
        return shippingCharge;
    }

    public void setShippingCharge(BigDecimal shippingCharge) {
        this.shippingCharge = shippingCharge;
    }
}
