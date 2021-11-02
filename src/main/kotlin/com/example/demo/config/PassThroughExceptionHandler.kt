package com.example.demo.config

import com.example.demo.exception.NotAuthorizeException
import com.example.demo.service.MyAmazingBot
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class PassThroughExceptionHandler(private val myAmazingBot: MyAmazingBot) {

    @ExceptionHandler(NotAuthorizeException::class)
    fun customExceptionHandle(exception: NotAuthorizeException) {
        myAmazingBot.sendMessage(exception.message)
    }
}