package com.example.domain.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Contributes(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var email: String,

    @Column(length = 255, nullable = false)
    var title: String,

    var content: String? = null,

    @Column(nullable = false)
    var postId: Long,

    @Column(nullable = false)
    var postUrl: String,

)
