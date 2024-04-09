package com.pharam.pharamaApp.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name ="shipping_master")
public class ShippingMaster {

    @Id
     @Column(name = "MEDICINE_TYPE_CODE")
    private  String  medicineTypeCode;
    @Column(name = "WEIGHT_RANGE")
    private  String  weightRange;

    @Column(name = "SHIPPING_CHARGE")
    private BigDecimal shippingCharge;
    public String getMedicineTypeCode() {
        return medicineTypeCode;
    }

    public void setMedicineTypeCode(String medicineTypeCode) {
        this.medicineTypeCode = medicineTypeCode;
    }
    public String getWeightRange() {
        return weightRange;
    }

    public void setWeightRange(String weightRange) {
        this.weightRange = weightRange;
    }
    public BigDecimal getShippingCharge() {
        return shippingCharge;
    }

    public void setShippingCharge(BigDecimal shippingCharge) {
        this.shippingCharge = shippingCharge;
    }

}
