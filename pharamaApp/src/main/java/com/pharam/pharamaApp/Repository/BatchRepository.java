package com.pharam.pharamaApp.Repository;

import com.pharam.pharamaApp.Entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends JpaRepository<Batch,String> {
    Batch findByBatchCode( String batchCode);
}
