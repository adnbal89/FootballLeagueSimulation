package domain.initializer

import data.model.League
import data.model.LeagueLevel
import domain.stage.Group

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