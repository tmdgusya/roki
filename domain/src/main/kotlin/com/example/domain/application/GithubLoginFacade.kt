package com.example.domain.application

import com.example.domain.UseCase
import com.example.domain.entity.User
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

    /**
     * 일단 Github 가입은 잘됨.
     * 상세적인 정보나 개발은 프론트엔드 스펙에 맞춰서 뽑자.
     */
    fun getUserProfile(clientId: String, clientSecret: String, code: String) {

        val authToken = githubClient.getAuthorizationToken(
            clientId = clientId,
            clientSecret = clientSecret,
            code = code
        )

        val userProfile = githubClient.getUserProfile(authToken = authToken)

        log.info("깃허브 가입을 요청 한 유저 정보: {}", userProfile)

        userQueryService.checkExist(userEmail = userProfile.email) isFalse {
            TODO("생각해보면 에러 던지는게 아니라 그 정보로 로그인을 시켜야 하는거 아닌가?")
        }

        val user = User(
            email = userProfile.email,
            role = Role.REGISTERED_USER,
            blogUrl = userProfile.githubUrl,
            avatarUrl = userProfile.avatarUrl,
        ).also { it.authToken = authToken }

        userCommandService.register(user)
    }

    companion object {
        private val log = LoggerFactory.getLogger(GithubLoginFacade::class.java)
    }
}
