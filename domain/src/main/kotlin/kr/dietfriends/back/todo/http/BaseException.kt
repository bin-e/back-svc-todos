package kr.dietfriends.back.todo.http

open class BaseException(
    var status: String = "",
    var error: String = ""
) : Exception() {

    fun toResult() = BaseResult(status, error)

}
