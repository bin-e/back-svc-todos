package kr.dietfriends.back.todo.contract

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import kr.dietfriends.back.todo.contract.Endpoint.TODOS
import kr.dietfriends.back.todo.domain.Todo
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@Api(tags = ["Todos"])
interface TodoContract {

    @ApiOperation("Create Todo")
    @PostMapping(TODOS, produces = [MediaType.APPLICATION_JSON_VALUE])
    fun add(
        @RequestBody todoBasic: Todo.TodoBasic
    ): Todo.TodoDetail

    @ApiOperation("List Todos")
    @GetMapping(TODOS, produces = [MediaType.APPLICATION_JSON_VALUE])
    fun list(): List<Todo.TodoDetail>

    @ApiOperation("Get Todo")
    @GetMapping("$TODOS/{todoId}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun get(
        @PathVariable todoId: Int
    ): Todo.TodoDetail

    @ApiOperation("Update Todo")
    @PutMapping("$TODOS/{todoId}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun update(
        @PathVariable todoId: Int,
        @RequestBody todoBasic: Todo.TodoBasic
    ): Todo.TodoDetail

    @ApiOperation("Delete Todo")
    @DeleteMapping("$TODOS/{todoId}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun delete(
        @PathVariable todoId: Int
    )

}