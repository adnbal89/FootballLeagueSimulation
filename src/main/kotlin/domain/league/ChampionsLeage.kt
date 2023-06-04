package domain.league

import domain.stage.*

class ChampionsLeague(override val name: String, override val rounds: MutableList<Stage>) : League {

    fun createChampionsLeagueRounds() {
        val preliminaryRound = PreliminaryRound()
        val prePlayOffRound = PlayOffRound(arrayListOf())
        val groupRound = GroupRound()
        val last16Round = PlayOffRound(arrayListOf())
        val quarterFinal = QuarterFinal()
        val semiFinal = SemiFinal()
        val final = Final()
        val stagesList =
            arrayListOf(preliminaryRound, prePlayOffRound, groupRound, last16Round, quarterFinal, semiFinal, final)

        //Create default rounds if not specified.
        if (rounds.size == 0)
            rounds.addAll(stagesList)
    }
}