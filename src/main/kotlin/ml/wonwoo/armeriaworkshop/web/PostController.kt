package ml.wonwoo.armeriaworkshop.web

import ml.wonwoo.armeriaworkshop.domain.PostRepository
import ml.wonwoo.armeriaworkshop.supports.HistoryEvent
import ml.wonwoo.armeriaworkshop.utils.MarkDownConverter
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.reactive.result.view.Rendering

@Controller
class PostController(private val postRepository: PostRepository,
                     private val markDownConverter: MarkDownConverter,
                     private val applicationEventPublisher: ApplicationEventPublisher) {

    @GetMapping("/{id}")
    fun home(@PathVariable id: Long): Rendering {
        return Rendering
            .view("post")
            .modelAttribute("post", this.postRepository.findById(id)
                .map { it.toDto(markDownConverter) }
                .doFinally {
                    applicationEventPublisher.publishEvent(HistoryEvent(postId = id))
                }
            )
            .build()
    }
}
