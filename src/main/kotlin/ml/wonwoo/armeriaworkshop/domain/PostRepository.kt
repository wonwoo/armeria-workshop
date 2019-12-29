package ml.wonwoo.armeriaworkshop.domain

import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface PostRepository : ReactiveCrudRepository<Post, Long> {

    @Query("""
            select 
                id, title, content, reg_date, author 
            from 
                post 
            where 
                title = :title""")
    fun findByTitle(title: String): Flux<Post>

}