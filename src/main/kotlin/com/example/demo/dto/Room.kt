package com.example.demo.dto

import java.time.LocalDateTime

data class Room(
    var users: User?,
    var lastUpdate: LocalDateTime?,
    var name: String,
    var lockKey: Long
)