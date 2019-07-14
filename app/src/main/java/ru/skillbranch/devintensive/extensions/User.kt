package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.utils.Utils
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import java.util.*

fun User.toUserView(): UserView {
    val nickName = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status = if(lastVisit == null) "Еще ни разу не был" else if (isOnline) "online"
    else "Последний раз был ${lastVisit.humanizeDiff(Date())}"

    return UserView(
        id,
        fullName = "$firstName $lastName",
        nickName = nickName,
        initials = initials,
        status = status
    )
}

fun Date.humanizeDiff(date: Date = Date()): String {
        var diff = this.time - date.time
    return when (diff) {
        in 0..1000 -> "был только что"
        in 1000..45000 -> "несколько секунд назад"

        else -> "хрень"

    }

}
