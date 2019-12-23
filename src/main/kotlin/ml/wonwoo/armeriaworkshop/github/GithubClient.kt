package ml.wonwoo.armeriaworkshop.github

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux
import reactor.core.publisher.Flux

@Component
class GithubClient(client: WebClient.Builder, properties: GithubProperties) {

    private val webClient = client.baseUrl(properties.uri).build()

    fun fetchEvents(orgName: String, repoName: String): Flux<RepositoryEvent> {
        return this.webClient.get().uri("/repos/{owner}/{repo}/issues/events", orgName, repoName)
            .retrieve()
            .bodyToFlux()
    }

}