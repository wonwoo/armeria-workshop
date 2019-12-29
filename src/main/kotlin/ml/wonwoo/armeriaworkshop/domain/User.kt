package ml.wonwoo.armeriaworkshop.domain

import org.springframework.data.annotation.Id


data class User(

    @Id
    val id: Long? = null,

    val name: String
)