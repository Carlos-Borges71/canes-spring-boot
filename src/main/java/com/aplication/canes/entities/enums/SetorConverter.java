package com.aplication.canes.entities.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SetorConverter implements AttributeConverter<Setor, Integer>{

    @Override
    public Integer convertToDatabaseColumn(Setor status) {
        return status != null ? status.getCode() : null;
    }

    @Override
    public Setor convertToEntityAttribute(Integer code){
        return code != null ? Setor.fromCodigo(code) : null;
    }

}
