package com.cagdas.mapper;

import com.cagdas.dto.request.NewCreateStockDto;
import com.cagdas.repository.entities.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IStockMapper {

    IStockMapper INSTANCE= Mappers.getMapper(IStockMapper.class);

    Stock tostock(final NewCreateStockDto dto);


}
