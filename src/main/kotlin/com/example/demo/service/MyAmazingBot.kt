package com.example.demo.service

import lombok.AllArgsConstructor
import org.springframework.stereotype.Service
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException


@Service
@AllArgsConstructor
class MyAmazingBot(private val roomCreator: RoomCreator) : TelegramLongPollingBot() {

    override fun getBotToken(): String {
        return "1969725133:AAGCOLwk-TCPhHYjC7-QH4l4wQC4Sp-Fozs"
    }

    override fun getBotUsername(): String {
        return "MyAmazingBot"
    }

    override fun onUpdateReceived(update: Update?) {
        if (update == null) return;
        if (update.hasMessage() && update.getMessage().hasText()) {
            val chatId = update.message.chatId
            val reply = getCommand(update)
            val message = SendMessage.builder().chatId(chatId.toString()).text(reply).build()
            try {
                execute(message)
            } catch (e: TelegramApiException) {
                e.stackTrace
                throw e
            }
        }
    }

    fun getCommand(update: Update): String {
        val messageText = update.message.text
        val chatId = update.message.chatId
        var reply = ""
        if (messageText.contains("/new_poker_room")) {
            reply = roomCreator.createNewRoom(messageText, chatId)
        }
        if (messageText.contains("/get_rooms")) {
            reply = roomCreator.getRooms()
        }
        if (messageText.contains("/create_user")) {
            reply = roomCreator.registerUser(messageText, chatId, update.message.from.userName)
        }
        if (messageText.contains("/enter_room")) {
            reply = roomCreator.enterRoom(messageText, chatId)
        }
        if (messageText.contains("/room_users")) {
            reply = roomCreator.getRoomsUsers(messageText, chatId)
        }
        if (messageText.contains("/vote")) {
            reply = roomCreator.setUserVote(messageText, chatId)
        }
        if (messageText.contains("/show_results")) {
            reply = roomCreator.showVoteResults(messageText, chatId)
        }
        if (messageText.contains("/drop_results")) {
            reply = roomCreator.dropResults(messageText, chatId)
        }
        if (messageText.contains("/is_vote")) {
            reply = roomCreator.isUsersVote(messageText, chatId)
        }
        return reply
    }
}