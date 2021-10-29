package com.example.demo.service

import org.springframework.stereotype.Service
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage

@Service
class RoomCreator {

    fun createNewRoom(text:String): String {
        val roomName = text.removePrefix("/new_poker_room ")
        return roomName
    }
}