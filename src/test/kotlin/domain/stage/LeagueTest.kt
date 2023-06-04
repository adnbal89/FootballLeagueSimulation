package domain.stage

import domain.league.ChampionsLeague
import org.junit.Test
import kotlin.test.assertEquals


class LeagueTest {
    private val rounds = arrayListOf<Stage>()
    private val league = ChampionsLeague("Champions League", rounds)

    @Test
    fun getName() {
        assertEquals("Champions League", league.name)
    }

    @Test
    fun getRounds() {
        assertEquals(league.rounds?.size, 0)
    }


}