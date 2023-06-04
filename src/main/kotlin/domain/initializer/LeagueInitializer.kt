package domain.initializer

import domain.stage.Group
import data.model.League
import data.model.LeagueLevel

class LeagueInitializer(
    private val level: LeagueLevel,
    private val groupList: List<Group>
) :
    Initializer<League> {
    override fun initialize(name: String): League {
        val league = League()

        league.setName(name)
        league.setLevel(level)
        groupList.forEach { group ->
            league.addGroup(group)
        }

        return league
    }
}