package com.example.demo.dao

import lombok.AllArgsConstructor

class Rooms(
    var rooms: List<Any> = emptyList()
) {
    fun createNewRoom(text: String): String {
        rooms = listOf("a", "b", "c")
        return "a"
    }
}
