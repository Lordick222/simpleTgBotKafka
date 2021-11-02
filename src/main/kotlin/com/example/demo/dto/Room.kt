package com.example.demo.dto

import java.time.LocalDateTime

data class Room(
    var users: MutableList<Long>?,
    var lastUpdate: LocalDateTime?,
    var name: String,
    var lockKey: Long
) {
    override fun toString(): String = "name: $name \t lastUpdate: $lastUpdate"
}
