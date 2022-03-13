package com.example.domain.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "posts")
@Entity
@EntityListeners(AuditingEntityListener::class)
class Post(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null,

    @Column(length = 200, nullable = false)
    private var title: String,

    @Column(nullable = false)
    private var content: String,

    @Column(nullable = false)
    private var version: Int = 1

) {

    @CreatedDate
    @Column(name = "createdAt", updatable = false)
    private var createdAt: LocalDateTime? = null

    @LastModifiedDate
    @Column(name = "updatedAt")
    private var updatedAt: LocalDateTime? = null
}
