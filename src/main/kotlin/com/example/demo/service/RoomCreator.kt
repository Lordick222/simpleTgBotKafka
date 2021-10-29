package com.example.demo.service

import com.example.demo.dao.RoomRepository
import lombok.AllArgsConstructor
import org.springframework.stereotype.Service

@Service
@AllArgsConstructor
class RoomCreator(private val roomRepository: RoomRepository) {

    fun createNewRoom(name: String, key: Long): String {
        val roomName = name.removePrefix("/new_poker_room ")
        val result = roomRepository.createNewRoom(roomName, key)
        return result
    }

    fun getRooms(): String {
        return roomRepository.getAllRooms()
    }

    fun registerInRoom(messageText: String, chatId: Long): String {
        val UserInfo = messageText.removePrefix("/register_user ")
        return roomRepository.getAllRooms()
    }
}