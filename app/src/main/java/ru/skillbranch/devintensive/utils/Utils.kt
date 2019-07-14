package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{
        val parts : List<String>? = fullName?.split(" ")

        val firstName =parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
    return Pair(firstName, lastName)}

    fun transliteration(payload: String): String {
        val parts : List<String>? = payload.split(" ")
        val firstNameRUS = parts?.getOrNull(0)?.toLowerCase()?.split("")
        val lastNameRUS = parts?.getOrNull(1)?.toLowerCase()?.split("")
        val firstNameEng : MutableList<String> = listOf<String>().toMutableList()
        val lastNameEng : MutableList<String> = listOf<String>().toMutableList()

        val map  = mapOf(
            "а" to "a",
            "б" to  "b",
            "в" to "v",
            "г" to "g",
            "д" to "d",
            "е" to "e",
            "ё" to "e",
            "ж" to "zh",
            "з" to "z",
            "и" to "i",
            "й" to "i",
            "к" to "k",
            "л" to "l",
            "м" to "m",
            "н" to "n",
            "о" to "o",
            "п" to "p",
            "р" to "r",
            "с" to "s",
            "т" to "t",
            "у" to "u",
            "ф" to "f",
            "х" to "h",
            "ц" to "c",
            "ч" to "ch",
            "ш" to "sh",
            "щ" to "sh'",
            "ъ" to "",
            "ы" to "i",
            "ь" to "",
            "э" to "e",
            "ю" to "yu",
            "я" to "ya")

        for (char in firstNameRUS!!) {
            if (map.containsKey(char)) firstNameEng.add(map.getValue(char))
        }

        for (char in lastNameRUS!!) {
            if (map.containsKey(char)) lastNameEng.add(map.getValue(char))
        }
        val firstNamechar= firstNameEng[0].toUpperCase()
        firstNameEng[0] = firstNamechar


        if (lastNameEng[0]?.isNotEmpty()) {val lastNameChar: String = lastNameEng[0].toUpperCase();
        lastNameEng[0] = lastNameChar}
    return  "${firstNameEng.joinToString("")} ${lastNameEng.joinToString("")}"}

    fun toInitials(firstName: String?, lastName: String?) :String {
        val firstNameI = firstName?.split("")?.getOrNull(1)
        val lastNameI = lastName?.split("")?.getOrNull(1)
        return "$firstNameI$lastNameI"
    }
}