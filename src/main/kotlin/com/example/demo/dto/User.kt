package com.example.demo.dto

data class User(
    val name: String?,
    val position: String?,
    val chatId: Long,
    var vote: Int?
) {
    override fun toString(): String = "position: $position \t name: $name \t vote: $vote "
}
