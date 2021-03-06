package ml.wonwoo.armeriaworkshop

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class ArmeriaWorkshopApplication

fun main(args: Array<String>) {
    runApplication<ArmeriaWorkshopApplication>(*args)
}
