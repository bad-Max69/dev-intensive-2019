package ru.skillbranch.devintensive.models

import android.service.voice.AlwaysOnHotwordDetector
import java.util.*

abstract class BaseMessage (
    val id:String,
    val from: User?,
    val chat:Chat,
    val isIncomming: Boolean = false,
    val date: Date = Date()
) {
    abstract fun formatMessage():String
    companion object AbstractFactory{
        var lastid= -1
        fun makeMessage (from: User?, chat: Chat, date: Date = Date(), type:String ="text", payload: Any?):BaseMessage{
            lastid++
            return when(type){
                "image"-> ImageMessage("$lastid", from, chat, date = date,image = payload as String)
                else -> TextMesage("$lastid", from, chat, date = date,text = payload as String)
            }
        }
    }
}