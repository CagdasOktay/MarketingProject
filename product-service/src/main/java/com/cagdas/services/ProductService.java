package com.cagdas.services;


import com.cagdas.dto.request.RegisterRequestDto;
import com.cagdas.manager.IStockManager;
import com.cagdas.mapper.IProductMapper;
import com.cagdas.repository.IProductRepository;
import com.cagdas.repository.entities.Product;
import com.cagdas.utilities.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends ServiceManager<Product,Long> {

    private final IProductRepository productRepository;
    private final IStockManager stockManager;

    public ProductService(IProductRepository productRepository, IStockManager stockManager){
        super(productRepository);
        this.productRepository = productRepository;
        this.stockManager = stockManager;

    }

    public Product register(RegisterRequestDto dto) {

        Product product = IProductMapper.INSTANCE.toProduct(dto);
        save(product);
        stockManager.create(IProductMapper.INSTANCE.toNewCreateStockDto(product));

        return product;

    }



}
