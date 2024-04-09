package com.pharam.pharamaApp.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicine_master")
public class MedicineMaster {
    @Id
    @Column(name = "MEDICINE_CODE")
    private  String medicineCode;

    @Column(name = "MEDICINE_NAME")
    private  String  medicineName;

    public String getMedicineCode() {
        return medicineCode;
    }

    public void setMedicineCode(String medicineCode) {
        this.medicineCode = medicineCode;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }
}
