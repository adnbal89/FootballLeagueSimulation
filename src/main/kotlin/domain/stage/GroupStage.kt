package domain.stage

import data.model.Fixture
import data.model.Team
import domain.util.GroupNames

interface GroupStage : Stage {
    fun getGroups(): List<Group>
    fun updateStandings()
    fun getFixtureByGroupName(groupName: String): Fixture

}