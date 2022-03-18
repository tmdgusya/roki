package com.example.domain.repository

import com.example.domain.entity.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {

    /**
     * Query Optimization
     */
    @Query("SELECT EXISTS(SELECT 1 FROM users u WHERE u.email = :email)", nativeQuery = true)
    fun existsByUserEmail(email: String): Boolean
}
