package kr.dietfriends.back.todo.config

import kr.dietfriends.back.todo.http.BaseException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class DefaultControllerAdvice {

    @ExceptionHandler(BaseException::class)
    fun handleBaseException(req: HttpServletRequest, e: BaseException) =
        ResponseEntity(e.toResult(), HttpStatus.valueOf(e.status))

}