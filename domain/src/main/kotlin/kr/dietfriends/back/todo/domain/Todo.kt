package kr.dietfriends.back.todo.domain

import io.swagger.annotations.ApiModel

object Todo {

    @ApiModel("Todo Partial")
    open class TodoBasic(
        var name: String = "",
        var completed: Boolean? = false
    )

    @ApiModel("Todo Full")
    class TodoDetail(
        name: String = "",
        completed: Boolean? = false
    ) : TodoBasic(name, completed) {

    }

}