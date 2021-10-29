package com.example.demo.config

import com.example.demo.service.MyAmazingBot
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

@Configuration
open class AppConfig {

    @Bean
    open fun createBot(myAmazingBot: MyAmazingBot): TelegramBotsApi {
        val telegramBotsApi = TelegramBotsApi(DefaultBotSession::class.java)
        try {
            telegramBotsApi.registerBot(myAmazingBot)
        } catch (e: TelegramApiException) {
            e.printStackTrace()
        }
        return telegramBotsApi
    }
}