package com.pharam.pharamaApp.Repository;

import com.pharam.pharamaApp.Entity.MedicineMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineMasterRepository extends JpaRepository<MedicineMaster,String> {
    MedicineMaster findByMedicineCode(String medicineCode);
}
