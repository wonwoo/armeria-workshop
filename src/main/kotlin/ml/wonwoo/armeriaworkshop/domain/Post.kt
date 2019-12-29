package ml.wonwoo.armeriaworkshop.domain

import org.springframework.data.annotation.Id
import java.time.LocalDateTime

data class Post(

    @Id
    val id: Long? = null,

    val title: String,

    val content: String,

    val regDate: LocalDateTime = LocalDateTime.now(),

    val author: String
)