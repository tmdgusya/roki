package com.example.domain.entity

import com.example.domain.entity.converter.RoleConverter
import javax.persistence.Column
import javax.persistence.Convert
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "users")
@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, length = 100)
    var email: String,

    @Column(nullable = true, length = 255)
    var blogUrl: String? = null,

    @Column(nullable = true, length = 255)
    val avatarUrl: String? = null,

    @Convert(converter = RoleConverter::class)
    @Column(nullable = false, length = 10)
    var role: com.example.domain.model.Role
) {

    @Column(name = "auth_token", length = 200, nullable = true)
    var authToken: String? = null
}
