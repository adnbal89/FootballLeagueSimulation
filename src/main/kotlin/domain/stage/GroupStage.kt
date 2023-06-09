package domain.stage

import data.model.Fixture
import data.model.Match
import domain.util.GroupNames

interface GroupStage : Stage {
    fun getGroups(): List<Group>
}