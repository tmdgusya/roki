package com.example.domain.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Users(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private var id: Long? = null,

    @Column(nullable = false, length = 100)
    private var email: String,

    @Column(nullable = false, length = 10)
    private var role: String
) {

    @Column(name = "auth_token", length = 200, nullable = true)
    private var authToken: String? = null
}
