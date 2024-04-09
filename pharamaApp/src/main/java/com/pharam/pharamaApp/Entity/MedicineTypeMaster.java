package com.pharam.pharamaApp.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medicine_type_master")
public class MedicineTypeMaster {

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column(name = "MEDICINE_TYPE_CODE")
    private  String medicineTypeCode;

    @Column(name = "MEDICINE_TYPE_NAME")
    private  String medicineTypeName;

    public String getMedicineTypeCode() {
        return medicineTypeCode;
    }

    public void setMedicineTypeCode(String medicineTypeCode) {
        this.medicineTypeCode = medicineTypeCode;
    }

    public String getMedicineTypeName() {
        return medicineTypeName;
    }

    public void setMedicineTypeName(String medicineTypeName) {
        this.medicineTypeName = medicineTypeName;
    }
}
