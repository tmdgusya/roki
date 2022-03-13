package com.example.domain.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Post(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private var id: Long? = null,

    @Column(length = 200, nullable = false)
    private var title: String,

    @Column(nullable = false)
    private var content: String,

    @Column(nullable = false)
    private var version: Int = 1

) {

    @CreatedDate
    @Column(updatable = false)
    private var createdAt: LocalDateTime? = null

    @LastModifiedDate
    private var updatedAt: LocalDateTime? = null
}
