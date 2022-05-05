package kr.dietfriends.back.todo.http

import java.io.Serializable

open class BaseResult() : Serializable {
    var status: String? = null
    var error: String? = null

    constructor(status: String?, error: String?) : this() {
        this.status = status
        this.error = error
    }
}