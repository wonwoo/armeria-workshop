package ml.wonwoo.armeriaworkshop.issue

import ml.wonwoo.armeriaworkshop.github.GithubClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class IssueController(private val githubClient: GithubClient) {


    @GetMapping("/{orgName}/{repoName}")
    fun issue(@PathVariable orgName: String, @PathVariable repoName: String) =
        githubClient.fetchEvents(orgName, repoName)

}