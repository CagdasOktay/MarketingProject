package com.cagdas.controller;


import com.cagdas.dto.request.RegisterRequestDto;
import com.cagdas.repository.entities.Product;
import com.cagdas.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

     @PostMapping("/register")
     public ResponseEntity<String> register(@RequestBody RegisterRequestDto dto) {
         productService.register(dto);
     return ResponseEntity.ok("Product Register Successfull");
    }
     @GetMapping("/getall")
    public ResponseEntity<List<Product>> getList() {

         return ResponseEntity.ok(productService.findAll());

     }

}
