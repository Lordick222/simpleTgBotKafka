package com.example.demo.dao

import com.example.demo.dto.Room
import com.example.demo.dto.User
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class RoomRepository(
    var rooms: MutableMap<String, Room> = mutableMapOf(),
    var users: MutableMap<Long, User> = mutableMapOf()
) {

    fun createNewRoom(name: String, key: Long): String {
        var room = Room(null, LocalDateTime.now(), name, key)
        rooms.getOrPut(name) { room }
        return rooms.get(name).toString()
    }

    fun getAllRooms(): String {
        val builder = StringBuilder()
        rooms.forEach { it ->
            builder.append("------------------------")
            builder.append(System.getProperty("line.separator"))
            builder.append(it)
            builder.append(System.getProperty("line.separator"))
            builder.append("------------------------")
        }
        return builder.toString()
    }

    fun registerUser(position: String, key: Long, name: String): String {
        val user = User(name, position, key, null)
        users.getOrPut(key) { user }
        return users.get(key).toString()
    }
}
