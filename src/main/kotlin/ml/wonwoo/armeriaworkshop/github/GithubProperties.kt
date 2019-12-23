package ml.wonwoo.armeriaworkshop.github

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties("github")
@ConstructorBinding
data class GithubProperties(

    val uri: String
)