package com.pharam.pharamaApp.Repository;

import com.pharam.pharamaApp.Entity.MedicineTypeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineTypeMasterRepository extends JpaRepository<MedicineTypeMaster,String> {
}
