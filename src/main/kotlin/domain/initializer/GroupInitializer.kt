package domain.initializer

import data.model.Standing
import data.model.Team
import domain.stage.Group
import domain.generator.GroupFixtureGenerator

class GroupInitializer :
    Initializer<Group> {

    private lateinit var matchGenerator: GroupFixtureGenerator
    private lateinit var standing: Standing
    private lateinit var group: Group
    private lateinit var teamList: List<Team>

    override fun initialize(name: String): Group {
        group = Group(name)
        standing = Standing()

        matchGenerator = GroupFixtureGenerator()

        val fixture = matchGenerator.generateFixture(teamList, isFinalStage = false)

        teamList.forEach {
            group.addTeam(it)
            standing.addTeam(it)
        }
        //group.setFixture(fixture)
        group.setStanding(standing)

        return group
    }

    fun setTeamList(teamList: List<Team>) {
        this.teamList = teamList
    }
}


/*val groupList = mutableListOf<Group>()

//initialize group members and create group
groupNamesList.forEach {
    var group = Group(it.toString())

    while (group.getTeams().size < teamCountPerGroup) {
        val randomTeam = randomPicker.pickRandomlyFromList(tempTeamList)
        group.addTeam(randomTeam)
        tempTeamList.remove(randomTeam)
    }
    groupList.add(group)
}*/
