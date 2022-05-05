package kr.dietfriends.back.todo.domain

import com.fasterxml.jackson.annotation.JsonFormat
import io.swagger.annotations.ApiModel
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

object Todo {

    @ApiModel("Todo Partial")
    open class TodoBasic(
        var name: String = "",
        var completed: Boolean? = null
    )

    @ApiModel("Todo Full")
    class TodoDetail(
        name: String = "",
        completed: Boolean? = null
    ) : TodoBasic(name, completed) {
        var id: Int = 0

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
        var completedAt: LocalDateTime? = null

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
        var createdAt: LocalDateTime? = null

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
        var updatedAt: LocalDateTime? = null
    }

}