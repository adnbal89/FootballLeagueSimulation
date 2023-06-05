package domain.league

import domain.stage.*
import domain.stage.League

class ChampionsLeague(override val name: String, override val rounds: MutableList<Stage>) : League(name, rounds) {
    private lateinit var preliminaryRound: PreliminaryRound
    private lateinit var prePlayOffRound: PlayOffRound
    private lateinit var groupRound: GroupRound
    private lateinit var last16Round: PlayOffRound
    private lateinit var quarterFinal: QuarterFinal
    private lateinit var semiFinal: SemiFinal
    private lateinit var final: Final
    private lateinit var stagesList: List<Stage>
    fun createChampionsLeagueRounds() {
        preliminaryRound = PreliminaryRound()
        prePlayOffRound = PlayOffRound(arrayListOf())
        groupRound = GroupRound()
        last16Round = PlayOffRound(arrayListOf())
        quarterFinal = QuarterFinal()
        semiFinal = SemiFinal()
        final = Final()
        stagesList =
            arrayListOf(preliminaryRound, prePlayOffRound, groupRound, last16Round, quarterFinal, semiFinal, final)

        //Create default rounds if not specified.
        if (rounds.size == 0)
            rounds.addAll(stagesList)
    }
}