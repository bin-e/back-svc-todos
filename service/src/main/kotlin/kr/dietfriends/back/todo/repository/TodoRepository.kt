package kr.dietfriends.back.todo.repository

import kr.dietfriends.back.todo.entity.TodoEntity
import org.springframework.data.jpa.repository.support.SimpleJpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class TodoRepository(
    em: EntityManager
) : SimpleJpaRepository<TodoEntity, Int>(TodoEntity::class.java, em) {

}