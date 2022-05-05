package kr.dietfriends.back.todo.http

import java.io.Serializable

class SingleResult<T>(val value: T) : BaseResult(), Serializable