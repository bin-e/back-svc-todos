package kr.dietfriends.back.todo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication(scanBasePackages = ["kr.dietfriends.back"])
@EnableJpaAuditing
class TodoApplication

fun main(args: Array<String>) {
    runApplication<TodoApplication>(*args)
}