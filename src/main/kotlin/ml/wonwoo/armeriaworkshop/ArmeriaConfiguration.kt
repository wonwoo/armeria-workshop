package ml.wonwoo.armeriaworkshop

import com.linecorp.armeria.client.circuitbreaker.CircuitBreakerHttpClient
import com.linecorp.armeria.client.circuitbreaker.CircuitBreakerStrategy
import com.linecorp.armeria.server.docs.DocService
import com.linecorp.armeria.server.logging.AccessLogWriter
import com.linecorp.armeria.server.logging.LoggingService
import com.linecorp.armeria.spring.ArmeriaServerConfigurator
import com.linecorp.armeria.spring.web.reactive.ArmeriaClientConfigurator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration(proxyBeanMethods = false)
class ArmeriaConfiguration {

    @Bean
    fun armeriaServerConfigurator(): ArmeriaServerConfigurator =
        ArmeriaServerConfigurator {
            it.serviceUnder("/docs", DocService())
            it.decorator(LoggingService.newDecorator())
            it.accessLogWriter(AccessLogWriter.combined(), false)
        }

    @Bean
    fun armeriaClientConfigurator(): ArmeriaClientConfigurator {
        return ArmeriaClientConfigurator {
            val strategy = CircuitBreakerStrategy.onServerErrorStatus()
            it.decorator(CircuitBreakerHttpClient.builder(strategy).newDecorator())
        }
    }
}