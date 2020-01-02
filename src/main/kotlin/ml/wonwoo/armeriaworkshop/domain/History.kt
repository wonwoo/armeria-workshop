package ml.wonwoo.armeriaworkshop.domain

import org.springframework.data.annotation.Id
import java.time.LocalDateTime

data class History(

    @Id
    val id: Long? = null,
    val postId: Long,
    val regDate: LocalDateTime

)