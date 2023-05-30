package domain.date

import java.util.*

class DateAdvancer(private val date: Date) {
    fun advanceDate(dayCountToAdvance: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.DATE, dayCountToAdvance)

        return calendar.time
    }
}