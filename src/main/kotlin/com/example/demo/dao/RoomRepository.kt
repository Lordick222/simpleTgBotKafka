package com.example.demo.dao

import com.example.demo.dto.Room
import org.springframework.stereotype.Repository
import java.lang.StringBuilder
import java.time.LocalDateTime

@Repository
class RoomRepository(
    var rooms: MutableMap<String, Room> = mutableMapOf()
) {

    fun createNewRoom(name: String, key: Long): String {
        val room = Room(null, LocalDateTime.now(), name, key)
        rooms.getOrPut(name, room)
        return room.toString()
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

    fun createUser(roomName: String, key: Long): String {
        val room = Room(null, LocalDateTime.now(), name, key)
        rooms.add(room)
        return room.toString()
    }

}
