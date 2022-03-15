package com.example.domain.service

import com.example.domain.entity.Post
import com.example.domain.model.PostUpdateModel
import com.example.domain.repository.PostRepository
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class PostCommandServiceTest {

    @MockK
    private lateinit var postRepository: PostRepository

    @InjectMockKs
    private lateinit var postCommandService: PostCommandService

    @Test
    fun `게시물이 없는 상황에서 게시물을 업데이트 하려하면 예외가 발생한다`() {
        // given
        val postId = 1L
        val given = PostUpdateModel.In(
            postId = postId,
            title = "updateTitle",
            content = "updateContent"
        )
        every { postRepository.findByPostId(postId) } returns null

        // when
        val result = shouldThrow<java.lang.IllegalArgumentException> {
            postCommandService.updatePost(given)
        }

        // then
        result.message shouldBe "해당 게시물이 존재하지 않습니다."
    }

    @Test
    fun `게시물이 업데이트 되면 Version 이 +1 이 된다`() {
        // given
        val postId = 1L
        val given = PostUpdateModel.In(
            postId = postId,
            title = "updateTitle",
            content = "updateContent"
        )
        val mockPost = mockk<Post>(relaxed = true)

        every { postRepository.findByPostId(postId) } returns mockPost
        every { postRepository.save(mockPost) } returns mockPost

        // when
        postCommandService.updatePost(given)

        // then
        verify { mockPost.updatePost(any(), any()) }
    }
}
