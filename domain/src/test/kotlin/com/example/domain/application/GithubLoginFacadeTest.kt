package com.example.domain.application

import com.example.domain.exception.ExceptionCode
import com.example.domain.service.UserCommandService
import com.example.domain.service.UserQueryService
import com.example.externalapi.clients.github.GithubClientAdapter
import com.example.externalapi.clients.github.GithubUserProfileInfo
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(value = [MockKExtension::class])
class GithubLoginFacadeTest {

    @MockK
    lateinit var githubClient: GithubClientAdapter

    @MockK
    lateinit var userCommandService: UserCommandService

    @MockK
    lateinit var userQueryService: UserQueryService

    @InjectMockKs
    lateinit var githubLoginFacade: GithubLoginFacade

    val userEmail = "dev0jsh@gmail.com"
    val githubUrl = "https://github.com/tmdgusya"
    val avatarUrl = "https://avatars.githubusercontent.com/u/57784077?v=4"
    val userId = "tmdgusya"

    @Test
    fun `중복된 유저가 존재할 경우 IllegalAccessException 을 전파한다`() {
        // given
        val clientId = "clientID"
        val clientSecret = "clientSecret"
        val code = "code"

        `깃허브 리스폰스 셋업`()

        every {
            userQueryService.checkExist(
                userEmail = userEmail
            )
        } returns true

        // when
        val result = shouldThrow<IllegalAccessException> {
            githubLoginFacade.getUserProfile(
                clientId = clientId,
                clientSecret = clientSecret,
                code = code
            )
        }

        // then
        result.message shouldBe ExceptionCode.DUPLICATE_USER.message
    }

    private fun `깃허브 리스폰스 셋업`() {
        every {
            githubClient.getAuthorizationToken(
                clientId = any(),
                clientSecret = any(),
                code = any(),
            )
        } returns "authToken"

        every {
            githubClient.getUserProfile(any())
        } returns GithubUserProfileInfo(
            email = userEmail,
            avatarUrl = avatarUrl,
            githubUrl = githubUrl,
            userId = userId,
        )
    }
}
