package kr.dietfriends.back.todo.http

import java.io.Serializable

open class BaseResult : Serializable {
    var status: String? = null
    var error: String? = null

}