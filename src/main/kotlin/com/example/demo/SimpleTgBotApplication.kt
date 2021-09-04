package com.example.demo

import com.example.demo.service.MyAmazingBot
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession


@SpringBootApplication
class SimpleTgBotApplication

fun main(args: Array<String>) {
	runApplication<SimpleTgBotApplication>(*args)
	val telegramBotsApi = TelegramBotsApi(DefaultBotSession::class.java)
	try {
		telegramBotsApi.registerBot(MyAmazingBot())
	} catch (e: TelegramApiException) {
		e.printStackTrace()
	}
}
