package com.example.domain.application

import com.example.domain.UseCase
import com.example.domain.entity.User
import com.example.domain.exception.ExceptionCode
import com.example.domain.model.Role
import com.example.domain.service.UserCommandService
import com.example.domain.service.UserQueryService
import com.example.externalapi.clients.github.GithubClientAdapter
import isFalse
import org.slf4j.LoggerFactory

@UseCase
class GithubLoginFacade(
    private val githubClient: GithubClientAdapter,
    private val userCommandService: UserCommandService,
    private val userQueryService: UserQueryService,
) {

    fun getUserProfile(authToken: String) {
        val userProfile = githubClient.getUserProfile(authToken = authToken)

        userQueryService.checkExist(userEmail = userProfile.email) isFalse {
            throw IllegalAccessException(ExceptionCode.DUPLICATE_USER.message)
        }

        val user = User(
            email = userProfile.email,
            role = Role.REGISTERED_USER,
            blogUrl = userProfile.githubUrl,
            avatarUrl = userProfile.avatarUrl,
        )

        userCommandService.register(user)
    }

    companion object {
        private val log = LoggerFactory.getLogger(GithubLoginFacade::class.java)
    }
}
