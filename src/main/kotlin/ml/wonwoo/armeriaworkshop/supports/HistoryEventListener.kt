package ml.wonwoo.armeriaworkshop.supports

import ml.wonwoo.armeriaworkshop.domain.History
import ml.wonwoo.armeriaworkshop.domain.HistoryRepository
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import java.time.LocalDateTime

@Component
class HistoryEventListener(private val historyRepository: HistoryRepository) {


    @EventListener
    fun onApplicationEvent(historyEvent: HistoryEvent): Mono<Void> {

        return historyRepository.save(historyEvent.toEvent()).then()

    }
}


data class HistoryEvent(

    val postId: Long

)

fun HistoryEvent.toEvent() = History(postId = this.postId, regDate = LocalDateTime.now())
