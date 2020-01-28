package ml.wonwoo.armeriaworkshop.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class ExtensionsKtTests{

    @Test
    fun `format to english th test`() {

        val date = LocalDateTime.of(2019, 8, 12, 12,22)

        val formatToEnglish = date.formatToEnglish()

        assertThat(formatToEnglish).isEqualTo("August 12th 2019")

    }

    @Test
    fun `format to english th2 test`() {

        val date = LocalDateTime.of(2019, 8, 4, 12,22)

        val formatToEnglish = date.formatToEnglish()

        assertThat(formatToEnglish).isEqualTo("August 4th 2019")

    }

    @Test
    fun `format to english nd test`() {

        val date = LocalDateTime.of(2019, 8, 22, 12,22)

        val formatToEnglish = date.formatToEnglish()

        assertThat(formatToEnglish).isEqualTo("August 22nd 2019")

    }

    @Test
    fun `format to english st test`() {

        val date = LocalDateTime.of(2019, 8, 21, 12,22)

        val formatToEnglish = date.formatToEnglish()

        assertThat(formatToEnglish).isEqualTo("August 21st 2019")

    }


    @Test
    fun `format to english rd test`() {

        val date = LocalDateTime.of(2019, 8, 23, 12,22)

        val formatToEnglish = date.formatToEnglish()

        assertThat(formatToEnglish).isEqualTo("August 23rd 2019")

    }
}