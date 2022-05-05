package kr.dietfriends.back.todo.http

class CommonException(errorMessage: String) : BaseException("404", errorMessage)