package domain.stage

import data.model.Team
import domain.util.Constants
import domain.util.GroupNames
import org.junit.Test
import kotlin.test.assertEquals

class GroupRoundTest {
    private val groupRound = GroupRound()
    private var tempTeamList = Team.teamList.toMutableList()

    @Test
    fun simulateDraw() {

    }

    @Test
    fun simulateDrawGroupSizeIsCorrect() {
        groupRound.simulateDraw(tempTeamList)
        assertEquals(groupRound.getGroups().size, Constants.GROUP_COUNT)
    }

    @Test
    fun simulateDrawTeamSizePerGroupIsCorrect() {
        groupRound.simulateDraw(tempTeamList)
        assertEquals(groupRound.getGroups().size, Constants.TEAM_COUNT_PER_GROUP)
    }

    @Test
    fun simulateDrawTeamsAreUniqueInAGroup() {
        groupRound.simulateDraw(tempTeamList)
        //Team uniqueness check
        groupRound.getGroups().forEach {
            val num = it.getTeams().distinct().size
            assertEquals(num, Constants.TEAM_COUNT_PER_GROUP)
        }
    }

    //TODO
    fun simulateDrawAGroupDoesNotIncludeTeamsFromSameCountry() {

    }
}