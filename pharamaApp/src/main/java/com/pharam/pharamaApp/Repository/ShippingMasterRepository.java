package com.pharam.pharamaApp.Repository;

import com.pharam.pharamaApp.Entity.ShippingMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingMasterRepository extends JpaRepository<ShippingMaster, String> {
    
    ShippingMaster findByMedicineTypeCodeAndWeightRange(String medicineTypeCode,String weight);
}
