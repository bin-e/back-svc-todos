package kr.dietfriends.back.todo.controller

import kr.dietfriends.back.todo.contract.TodoContract
import kr.dietfriends.back.todo.domain.Todo
import kr.dietfriends.back.todo.service.TodoService
import org.springframework.web.bind.annotation.RestController

@RestController
class TodoController(
    private val todoService: TodoService
) : TodoContract {

    override fun add(todoBasic: Todo.TodoBasic): Todo.TodoDetail = todoService.add(todoBasic)

    override fun list(): List<Todo.TodoDetail> = todoService.listSimple()

    override fun get(todoId: Int): Todo.TodoDetail = todoService.getDetail(todoId)

    override fun update(todoId: Int, todoBasic: Todo.TodoBasic): Todo.TodoDetail =
        todoService.update(todoId, todoBasic)

    override fun delete(todoId: Int) {
        todoService.delete(todoId)
    }

}