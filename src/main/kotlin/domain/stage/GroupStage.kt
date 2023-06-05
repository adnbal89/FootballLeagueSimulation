package domain.stage

import data.model.Fixture
import data.model.Match
import domain.util.GroupNames

interface GroupStage : Stage {
    fun getGroups(): List<Group>
    fun generateGroupFixtures()
    fun getFixtureByGroupName(groupName: String): Fixture
    fun getMatchesByGroup(groupName: GroupNames): List<Match>

}