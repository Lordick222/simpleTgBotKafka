package com.example.demo.dao

import com.example.demo.dto.Room
import com.example.demo.dto.User
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.util.*

@Repository
class RoomRepository(
    var rooms: MutableMap<String, Room> = mutableMapOf(),
    var users: MutableMap<Long, User> = mutableMapOf()
) {

    fun createNewRoom(name: String, key: Long): String {
        val room = Room(mutableListOf(), LocalDateTime.now(), name, key)
        rooms.getOrPut(name) { room }
        return rooms.get(name).toString()
    }

    fun getAllRooms(): Map<String, Room> {
        return Collections.unmodifiableMap(rooms)
    }

    fun registerUser(position: String, key: Long, name: String): User? {
        val user = User(name, position, key, null)
        users.getOrPut(key) { user }
        return users.get(key)
    }

    fun addUsertoRoom(roomName: String, userKey: Long): String {
        val user = users.get(userKey) ?: return "user is not register"
        val room = rooms.get(roomName) ?: return "room is not register now"
        room.users?.add(userKey)
        return "sussesfully added to ${room.name}"
    }

    fun getRoomsUsers(roomName: String, userKey: Long): String {
        val room = rooms.get(roomName) ?: return "room is not register now"
        if (!room.lockKey.equals(userKey)) return "it's not your room"
        val sb = StringBuilder()
        sb.append(room.toString()).append(System.getProperty("line.separator"))
            .append("----------users----------").append(System.getProperty("line.separator"))
        room.users?.forEach {
            sb.append("position: ${users[it]?.position} name: ${users[it]?.name}").append(
                System.getProperty(
                    "line" +
                            ".separator"
                )
            )
        }
        return sb.toString()
    }

    fun setUserVote(vote: Int, userKey: Long): String {
        val user = users.get(userKey) ?: return "user is not register"
        user.vote = vote
        return "sussesfully vote for ${user.vote}"
    }

    fun isUsersVote(roomName: String, userKey: Long): String {
        val room = rooms.get(roomName) ?: return "room is not register now"
        if (!room.lockKey.equals(userKey)) return "it's not your room"
        val sb = StringBuilder()
        sb.append(room.toString()).append(System.getProperty("line.separator"))
            .append("----------users----------").append(System.getProperty("line.separator"))
        room.users?.forEach {
            val isVote = users[it]?.vote != null
            sb.append("position: ${users[it]?.position} name: ${users[it]?.name} isVote: $isVote").append(
                System.getProperty(
                    "line" +
                            ".separator"
                )
            )
        }
        return sb.toString()
    }

    fun showVoteResults(roomName: String, userKey: Long): String {
        val room = rooms.get(roomName) ?: return "room is not register now"
        if (!room.lockKey.equals(userKey)) return "it's not your room"
        val sb = StringBuilder()
        sb.append(room.toString()).append(System.getProperty("line.separator"))
            .append("----------users----------").append(System.getProperty("line.separator"))
        room.users?.forEach {
            sb.append("position: ${users[it]?.position} name: ${users[it]?.name} vote: ${users[it]?.vote}").append(
                System.getProperty(
                    "line" +
                            ".separator"
                )
            )
        }
        return sb.toString()
    }

    fun dropResults(roomName: String, userKey: Long): String {
        val room = rooms.get(roomName) ?: return "room is not register now"
        if (!room.lockKey.equals(userKey)) return "it's not your room"
        room.users?.forEach {
            users[it]?.vote = null
        }
        return "votes dropped"
    }
}
