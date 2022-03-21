package com.example.domain.entity.converter

import com.example.domain.model.Role
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class RoleConverter : AttributeConverter<Role, String> {

    override fun convertToDatabaseColumn(attribute: Role): String {
        return attribute.name
    }

    override fun convertToEntityAttribute(dbData: String): Role {
        return Role.valueOf(dbData)
    }
}
