package com.example.domain.entity

import com.example.domain.entity.converter.RoleConverter
import javax.management.relation.Role
import javax.persistence.Column
import javax.persistence.Convert
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, length = 100)
    var email: String,

    @Column(nullable = false, length = 30)
    var password: String,

    @Convert(converter = RoleConverter::class)
    @Column(nullable = false, length = 10)
    var role: Role
) {

    @Column(name = "auth_token", length = 200, nullable = true)
    var authToken: String? = null
}
