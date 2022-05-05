package kr.dietfriends.back.todo.entity

import kr.dietfriends.back.todo.common.Constant
import org.hibernate.envers.Audited
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "todos")
@EntityListeners(AuditingEntityListener::class)
class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0

    var name: String = ""

    @Audited
    var completed: Boolean? = null
        set(value) {
            field = value
            if (value == true) completedAt = LocalDateTime.now()
        }

    var completedAt: LocalDateTime? = null

    @CreatedDate
    var createdAt: LocalDateTime = Constant.EMPTY_LOCAL_DATETIME

    @LastModifiedDate
    var updatedAt: LocalDateTime = Constant.EMPTY_LOCAL_DATETIME

}