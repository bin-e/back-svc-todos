package kr.dietfriends.back.todo.contract

import io.swagger.annotations.ApiOperation
import kr.dietfriends.back.todo.contract.Endpoint.TODOS
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

interface TodoContract {

    @ApiOperation("TODO 등록")
    @PostMapping(TODOS, produces = [MediaType.APPLICATION_JSON_VALUE])
    fun add() {

    }

    @ApiOperation("TODO 목록")
    @GetMapping(TODOS, produces = [MediaType.APPLICATION_JSON_VALUE])
    fun get () {

    }

}