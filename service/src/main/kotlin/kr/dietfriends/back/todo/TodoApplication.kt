package kr.dietfriends.back.todo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["kr.dietfriends.back"])
class TodoApplication

fun main(args: Array<String>) {
    runApplication<TodoApplication>(*args)
}