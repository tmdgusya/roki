package com.example.domain.application

import com.example.domain.UseCase
import com.example.domain.entity.User
import com.example.domain.model.GetUserProfilePort
import com.example.domain.model.Role
import com.example.domain.service.UserCommandService
import com.example.domain.service.UserQueryService
import com.example.externalapi.clients.github.GithubClientAdapter
import com.example.externalapi.clients.github.GithubUserProfileInfo
import org.slf4j.LoggerFactory

@UseCase
class GithubLoginFacade(
    private val githubClient: GithubClientAdapter,
    private val userCommandService: UserCommandService,
    private val userQueryService: UserQueryService,
) {

    fun getUserProfile(clientId: String, clientSecret: String, code: String): GetUserProfilePort.Out {

        val authToken = githubClient.getAuthorizationToken(
            clientId = clientId,
            clientSecret = clientSecret,
            code = code
        )

        val userProfile = githubClient.getUserProfile(authToken = authToken)

        log.info("깃허브 가입을 요청 한 유저 정보: {}", userProfile)

        val user = createNewUserIfNotExist(userProfile, authToken)

        return userCommandService.register(user).let {
            GetUserProfilePort.Out(
                role = user.role,
                avatarUrl = user.avatarUrl,
                githubUrl = user.blogUrl,
                email = user.email
            )
        }
    }

    private fun createNewUserIfNotExist(
        userProfile: GithubUserProfileInfo,
        authToken: String
    ) = userQueryService.findOne(email = userProfile.email) ?: User(
        email = userProfile.email,
        role = Role.REGISTERED_USER,
        blogUrl = userProfile.githubUrl,
        avatarUrl = userProfile.avatarUrl,
    ).also { it.authToken = authToken }

    companion object {
        private val log = LoggerFactory.getLogger(GithubLoginFacade::class.java)
    }
}
