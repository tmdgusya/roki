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
    var id: Long? = null,

    @Column(length = 200, nullable = false)
    var title: String,

    @Column(nullable = false)
    var content: String,

    @Column(nullable = false)
    var version: Int = 1

) {

    @CreatedDate
    @Column(name = "createdAt", updatable = false)
    var createdAt: LocalDateTime? = null

    @LastModifiedDate
    @Column(name = "updatedAt")
    var updatedAt: LocalDateTime? = null

    fun updatePost(
        title: String,
        content: String
    ) {
        this.title = title
        this.content = content
        updatePostVersion()
    }

    private fun updatePostVersion() = this.version + 1
}
