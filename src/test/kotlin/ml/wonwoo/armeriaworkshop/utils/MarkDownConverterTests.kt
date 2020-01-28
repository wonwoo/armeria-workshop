package ml.wonwoo.armeriaworkshop.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MarkDownConverterTests {

    @Test
    fun `mark down apply test`() {

        val markdown = MarkDownConverter()("""
            |### spring boot test  
            | * @SpringBootTest
            | * @DataJpaTest
            | * @WebMvcTest
        """.trimMargin())

        assertThat(markdown).isEqualTo("""
            |<h3>spring boot test</h3>
            |<ul>
            |<li>@SpringBootTest</li>
            |<li>@DataJpaTest</li>
            |<li>@WebMvcTest</li>
            |</ul>
            |""".trimMargin())
    }

    @Test
    fun `mark down apply null test`() {

        val markdown = MarkDownConverter()(null)

        assertThat(markdown).isEqualTo("")
    }
}