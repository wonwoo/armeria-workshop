package ml.wonwoo.armeriaworkshop.web

import ml.wonwoo.armeriaworkshop.domain.Post
import ml.wonwoo.armeriaworkshop.utils.MarkDownConverter
import ml.wonwoo.armeriaworkshop.utils.formatToEnglish

data class PostDto(

    val id: Long? = null,

    val title: String,

    val content: String,

    val addedAt: String,

    val author: String

)

fun Post.toDto(markdownConverter: MarkDownConverter) = PostDto(
    id,
    title,
    markdownConverter(content),
    regDate.formatToEnglish(),
    author
)
