package ml.wonwoo.armeriaworkshop.hello

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono


@RestController
class HelloController {

    @GetMapping("/")
    fun hello() : Mono<String> = Mono.just("hello world")

}
