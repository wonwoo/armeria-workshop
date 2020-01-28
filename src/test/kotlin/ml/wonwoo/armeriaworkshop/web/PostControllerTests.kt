package ml.wonwoo.armeriaworkshop.web

import ml.wonwoo.armeriaworkshop.domain.Post
import ml.wonwoo.armeriaworkshop.domain.PostRepository
import ml.wonwoo.armeriaworkshop.utils.MarkDownConverter
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.any
import org.mockito.BDDMockito.given
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.mock.mockito.SpyBean
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody
import reactor.kotlin.core.publisher.toMono


@WebFluxTest(PostController::class)
internal class PostControllerTests(private val webTestClient: WebTestClient) {

    @MockBean
    private lateinit var postRepository: PostRepository

    @SpyBean
    private lateinit var markDownConverter: MarkDownConverter

    @Test
    internal fun `post page test`() {

        given(postRepository.findById(any<Long>())).willReturn(Post(title = "test web", content = "foo test", author = "wonwoo").toMono())

        webTestClient.get().uri("/{id}", 1)
            .exchange()
            .expectStatus().isOk
            .expectBody<String>()
            .consumeWith {

                val body = it.responseBody

                assertThat(body).contains("test web")
                assertThat(body).contains("foo test")
                assertThat(body).contains("wonwoo")

            }

    }
}