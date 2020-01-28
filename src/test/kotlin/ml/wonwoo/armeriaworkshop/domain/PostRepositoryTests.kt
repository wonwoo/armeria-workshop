package ml.wonwoo.armeriaworkshop.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest
import reactor.kotlin.test.test

@DataR2dbcTest
class PostRepositoryTests(private val postRepository: PostRepository) {


    @Test
    fun `find by title test`() {

        postRepository.save(Post(title = "test web", content = "foo test", author = "wonwoo"))
            .then(postRepository.save(Post(title = "test web", content = "bar", author = "kevin")))
            .flatMapMany {
                postRepository.findByTitle("test web")
            }.test()
            .assertNext {
                assertThat(it.title).isEqualTo("test web")
                assertThat(it.content).isEqualTo("foo test")
                assertThat(it.author).isEqualTo("wonwoo")
            }.assertNext {
                assertThat(it.title).isEqualTo("test web")
                assertThat(it.content).isEqualTo("bar")
                assertThat(it.author).isEqualTo("kevin")
            }.verifyComplete()
    }
}