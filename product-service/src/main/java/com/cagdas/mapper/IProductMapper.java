package com.cagdas.mapper;

import com.cagdas.dto.request.NewCreateStockDto;
import com.cagdas.dto.request.RegisterRequestDto;
import com.cagdas.repository.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IProductMapper {

    IProductMapper INSTANCE= Mappers.getMapper(IProductMapper.class);

    Product toProduct(final RegisterRequestDto dto);

    @Mapping(source = "id", target= "productid")
    NewCreateStockDto toNewCreateStockDto(final Product product);


}
