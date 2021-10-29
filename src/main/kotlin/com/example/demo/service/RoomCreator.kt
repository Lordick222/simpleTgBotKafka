package com.example.demo.service

import com.example.demo.dao.RoomRepository
import lombok.AllArgsConstructor
import org.springframework.stereotype.Service

@Service
@AllArgsConstructor
class RoomCreator(private val roomRepository: RoomRepository) {

    fun createNewRoom(name: String, key: Long): String {
        val roomName = name.removePrefix("/new_poker_room ")
        roomRepository.createNewRoom(name, key)
        return roomName
    }

    fun getRooms(): String {
        return roomRepository.getAllRooms()
    }
}