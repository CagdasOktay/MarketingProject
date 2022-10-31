package com.cagdas.repository;


import com.cagdas.repository.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStockRepository extends JpaRepository<Stock,Long> {

    Optional<Stock> findOptionalByProductnameAndBarcode(String productname, String barcode);
}
