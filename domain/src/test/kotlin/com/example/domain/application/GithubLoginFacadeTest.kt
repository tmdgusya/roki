package com.example.domain.application

import com.example.domain.entity.User
import com.example.domain.service.UserCommandService
import com.example.domain.service.UserQueryService
import com.example.externalapi.clients.github.GithubClientAdapter
import com.example.externalapi.clients.github.GithubUserProfileInfo
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
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
    fun `기존에 가입되어 있던 유저라면 기존 아이디를 이용한다`() {

        // given

        `깃허브 리스폰스 셋업`()

        val mockUser = mockk<User>(relaxed = true)

        every {
            mockUser.email
        } returns userEmail

        every {
            userQueryService.findOne(email = any())
        } returns mockUser

        every {
            userCommandService.register(mockUser)
        } returns mockUser

        // when
        val userProfile = githubLoginFacade.getUserProfile(
            clientId = "clientId",
            clientSecret = "secret",
            code = "code"
        )

        // then
        userProfile.email shouldBe userEmail
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
