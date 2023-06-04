package domain.util

import data.model.Match
import data.model.Score
import data.model.Team
import java.time.LocalDateTime

class QualifyingMatchGenerator {

    fun generateMatches(list: List<Team>): List<Match> {
        val matchList = mutableListOf<Match>()

        if (list.size == 2) {
            val match1 = Match(list[0], list[1], LocalDateTime.now(), Score())
            val match2 = Match(list[1], list[0], LocalDateTime.now().plusDays(7), Score())

            matchList.add(match1)
            matchList.add(match2)
        } else {
            println("List size error.")
        }

        return matchList
    }

}