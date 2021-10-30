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

    fun registerUser(position: String, chatId: Long, name: String): String {
        val editPosition = position.removePrefix("/create_user ")
        return roomRepository.registerUser(editPosition, chatId, name)
    }

    fun enterRoom(command: String, userKey: Long): String {
        val roomName = command.removePrefix("/enter_room ")
        return roomRepository.addUsertoRoom(roomName, userKey)
    }

    fun getRoomsUsers(command: String, userKey: Long): String {
        val roomName = command.removePrefix("/room_users ")
        return roomRepository.getRoomsUsers(roomName, userKey)
    }

    fun setUserVote(command: String, userKey: Long): String {
        val vote = command.removePrefix("/vote ")
        return roomRepository.setUserVote(vote.toInt(), userKey)
    }

    fun showVoteResults(command: String, userKey: Long): String {
        val roomName = command.removePrefix("/show_results ")
        return roomRepository.showVoteResults(roomName, userKey)
    }

    fun dropResults(command: String, userKey: Long): String {
        val roomName = command.removePrefix("/drop_results ")
        return roomRepository.dropResults(roomName, userKey)
    }
}