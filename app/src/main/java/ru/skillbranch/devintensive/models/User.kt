package ru.skillbranch.devintensive.models


import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User (
    val id:String,
    var firstName:String?,
    var lastName:String?,
    var avatar:String?,
    var rating:Int = 0,
    var respect:Int = 0,
    val lastVisit: Date? = Date(),
    val isOnline:Boolean = false)

{
    constructor(id: String, firstName: String?, lastName: String?):
            this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null)


    constructor(id: String) : this(id, "John", "Doe $id")

    init {
        println(
            "It's Allive!!! \n "
                    + "${if (lastName === "Doe") "Hiss name id $ $firstName $lastName" 
            else "And his name is $firstName $lastName !!!"}\n"
        )
    }
    companion object Factory {
        private var lastid : Int = -1
        fun makeUser(fullName:String?): User {
            lastid++

          val (firstName , lastName) = Utils.parseFullName(fullName)

            return User(id= "$lastid", firstName = firstName , lastName = lastName)
        }

    }
}
