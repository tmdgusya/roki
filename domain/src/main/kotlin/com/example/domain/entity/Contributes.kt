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
    private var id: Long? = null,

    @Column(nullable = false)
    private var email: String,

    @Column(length = 255, nullable = false)
    private var title: String,

    private var content: String? = null,

    @Column(nullable = false)
    private var postId: Long,

    @Column(nullable = false)
    private var postUrl: String,

)
