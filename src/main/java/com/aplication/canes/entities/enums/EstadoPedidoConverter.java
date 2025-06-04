package com.aplication.canes.entities.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EstadoPedidoConverter implements AttributeConverter<EstadoPedido, Integer>{

     @Override
    public Integer convertToDatabaseColumn(EstadoPedido status) {
        return status != null ? status.getCode() : null;
    }

    @Override
    public EstadoPedido convertToEntityAttribute(Integer code){
        return code != null ? EstadoPedido.fromCodigo(code) : null;
    }
}
