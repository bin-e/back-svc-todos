package kr.dietfriends.back.todo.service

import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import kr.dietfriends.back.todo.domain.Todo
import kr.dietfriends.back.todo.entity.TodoEntity
import kr.dietfriends.back.todo.http.CommonException
import kr.dietfriends.back.todo.repository.TodoRepository
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional
import java.util.*

@DisplayName("Todo Service Test")
class TodoServiceTest {
    private val todoRepository: TodoRepository = mockk(relaxed = true)
    lateinit var todoService: TodoService

    @BeforeEach
    fun setUp() {
        todoService = TodoService(todoRepository)
    }

    @ActiveProfiles("test")
    @Transactional
    @Nested
    inner class `전체 메소드 중` {

        @Test
        fun `add 메소드는 매개변수로 들어온 객체를 저장한다`() {
            val todo = Todo.TodoBasic("테스트", false)
            val slotTodo = slot<TodoEntity>()

            coEvery { todoRepository.save(capture(slotTodo)) } returns TodoEntity()

            todoService.add(todo) // trigger
            assertEquals(todo.name, slotTodo.captured.name)
        }

        @Test
        fun `listSimple 메소드는 Todo 목록을 리스트로 반환한다`() {
            val todoEntity1 = TodoEntity()
            val todoEntity2 = TodoEntity()

            every { todoRepository.findAll() } returns listOf(todoEntity1, todoEntity2)

            val actual = todoService.listSimple()
            assertEquals(2, actual.size)
        }

        @Test
        fun `getDetail 메소드는 매개변수 todoId 에 대응되는 데이터를 반환한다`() {
            val todoId = 1

            coEvery { todoRepository.getOne(todoId) } returns TodoEntity().apply { name = "테스트" }

            val actual = todoService.getDetail(todoId)
            assertEquals("테스트", actual.name)
        }

        @Test
        fun `update 메소드는 만약 todoId 에 대응되는 데이터가 없으면 CommonException 을 던진다`() {
            val todoId = 1

            every { todoRepository.findById(todoId) } returns Optional.empty()

            assertThrows(CommonException::class.java) { todoService.update(todoId, Todo.TodoBasic()) }
        }

        @Test
        fun `update 메소드는 대응되는 데이터를 매개변수 값으로 갱신한다`() {
            val todoId = 1
            val todoBasic = Todo.TodoBasic().apply { name = "테스트" }
            val todoEntity = TodoEntity().apply { name = "이전 테스트" }
            val slotTodoEntity = slot<TodoEntity>()

            every { todoRepository.findById(todoId) } returns Optional.of(todoEntity)
            coEvery { todoRepository.save(capture(slotTodoEntity)) } returns TodoEntity()

            todoService.update(todoId, todoBasic)
            assertEquals(todoBasic.name, slotTodoEntity.captured.name)
        }

        @Test
        fun `delete 메소드는 만약 todoId 에 대응되는 데이터가 없으면 CommonException 을 던진다`() {
            val todoId = 1

            every { todoRepository.findById(todoId) } returns Optional.empty()

            assertThrows(CommonException::class.java) { todoService.delete(todoId) }
        }

        @Test
        fun `update 메소드는 대응되는 데이터를 삭제한다`() {
            val todoId = 1
            val todoEntity = TodoEntity().apply { name = "테스트" }
            val slotTodoEntity = slot<TodoEntity>()

            every { todoRepository.findById(todoId) } returns Optional.of(todoEntity)
            coEvery { todoRepository.delete(capture(slotTodoEntity)) } returns Unit

            todoService.delete(todoId)
            assertEquals("테스트", slotTodoEntity.captured.name)
        }
    }

}