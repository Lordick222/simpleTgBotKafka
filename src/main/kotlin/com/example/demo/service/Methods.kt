package com.example.demo.service

import org.springframework.stereotype.Service
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException


@Service
class Methods : TelegramLongPollingBot() {
    override fun getBotToken(): String {
        return "1969725133:AAGCOLwk-TCPhHYjC7-QH4l4wQC4Sp-Fozs"
    }

    override fun getBotUsername(): String {
        return "MyAmazingBot"
    }

    override fun onUpdateReceived(update: Update?) {
        if (update == null) return;
        if (update.hasMessage() && update.message.hasText()) {
            val messageText = update.message.text
            val chatId = update.message.chatId
            val message = SendMessage.builder().chatId(chatId.toString()).text(messageText).build()
            try {
                execute(message)
            } catch (e: TelegramApiException) {
                e.stackTrace
                throw e
            }
        }
        if (update.hasMessage() && update.message.hasPhoto()){

        }
    }
}