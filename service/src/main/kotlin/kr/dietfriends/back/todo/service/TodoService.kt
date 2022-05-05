package kr.dietfriends.back.todo.service

import kr.dietfriends.back.todo.domain.Todo
import kr.dietfriends.back.todo.entity.TodoEntity
import kr.dietfriends.back.todo.repository.TodoRepository
import org.springframework.stereotype.Service
import java.time.format.DateTimeFormatter

@Service
class TodoService(
    private val todoRepository: TodoRepository
) {
    fun add(todoBasic: Todo.TodoBasic) =
        todoRepository.save(todoBasic.entityConverter())
            .toTodoDetail()

    fun listSimple() =
        todoRepository.findAll()
            .map { it.toTodoDetail() }

    fun getDetail(todoId: Int) =
        todoRepository.getOne(todoId)
            .toTodoDetail()

    fun update(todoId: Int, todoBasic: Todo.TodoBasic) =
        todoRepository.findById(todoId)
            .orElseThrow { throw Exception() } // TODO: Exception handling
            .run {
                this.name = todoBasic.name
                this.completed = todoBasic.completed

                todoRepository.save(this)
            }
            .toTodoDetail()

    fun delete(todoId: Int) {
        todoRepository.findById(todoId)
            .orElseThrow { throw Exception() } // TODO: Exception handling
            .also { todoRepository.delete(it) }
    }

    fun Todo.TodoBasic.entityConverter() = TodoEntity().also {
        it.name = this.name
        it.completed = this.completed
    }

    fun TodoEntity.toTodoDetail() = Todo.TodoDetail(name, completed).also {
        it.id = this.id
        it.completedAt = this.completedAt
        it.createdAt = this.createdAt
        it.updatedAt = this.updatedAt
//        it.completedAt = this.completedAt?.format(DateTimeFormatter.ISO_DATE_TIME)
//        it.createdAt = this.createdAt?.format(DateTimeFormatter.ISO_DATE_TIME)
//        it.updatedAt = this.updatedAt?.format(DateTimeFormatter.ISO_DATE_TIME)
    }

}