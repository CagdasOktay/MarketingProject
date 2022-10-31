package com.cagdas.controller;


import com.cagdas.dto.request.NewCreateStockDto;
import com.cagdas.dto.request.UpdateStockDto;
import com.cagdas.repository.entities.Stock;
import com.cagdas.services.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stock")
public class StockController {

    private final StockService stockService;

    @PostMapping("/create")
    public ResponseEntity<Boolean> create(@RequestBody NewCreateStockDto dto) {

        try {
            stockService.create(dto);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }

    }

    @PostMapping("/update")
    public ResponseEntity<Boolean> update(@RequestBody UpdateStockDto dto) {

        return ResponseEntity.ok(stockService.updateStock(dto));

    }


    @GetMapping("/findall")
    public ResponseEntity<List<Stock>> findall(){
        return ResponseEntity.ok(stockService.findAll()) ;

    }


}
