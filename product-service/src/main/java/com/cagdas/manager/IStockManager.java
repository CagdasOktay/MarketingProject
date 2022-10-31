package com.cagdas.manager;


import com.cagdas.dto.request.NewCreateStockDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "stock-service", decode404 = true,url = "http://localhost:5051/stock" )
public interface IStockManager {

    @PostMapping("/create")
    public ResponseEntity<Boolean> create(@RequestBody NewCreateStockDto dto);

}
