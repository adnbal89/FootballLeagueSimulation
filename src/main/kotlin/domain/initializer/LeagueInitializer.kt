package domain.initializer

import data.model.League

class LeagueInitializer(private val league: League) : Initializer<League> {
    override fun initialize(): League {

        return league
    }
}