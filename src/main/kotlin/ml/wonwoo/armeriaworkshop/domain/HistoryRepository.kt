package ml.wonwoo.armeriaworkshop.domain

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface HistoryRepository : ReactiveCrudRepository<History, Long>