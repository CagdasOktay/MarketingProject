package com.cagdas.services;


import com.cagdas.dto.request.NewCreateStockDto;
import com.cagdas.dto.request.UpdateStockDto;
import com.cagdas.mapper.IStockMapper;
import com.cagdas.repository.IStockRepository;
import com.cagdas.repository.entities.Stock;
import com.cagdas.utilities.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockService extends ServiceManager<Stock,Long> {

    private final IStockRepository stockRepository;

    public StockService(IStockRepository stockRepository){
        super(stockRepository);
        this.stockRepository = stockRepository;

    }

    public Stock create(NewCreateStockDto dto) {

        return save(IStockMapper.INSTANCE.tostock(dto));

    }

    public boolean updateStock(UpdateStockDto dto) {
       Optional<Stock>stock= stockRepository.findOptionalByProductnameAndBarcode(dto.getProductname(), dto.getBarcode());
        if(stock.isPresent()){
            stock.get().setQuantity(stock.get().getQuantity()+ dto.getQuantity());
            save(stock.get());
            return true;

        }else {
            return false;
        }

    }
}
