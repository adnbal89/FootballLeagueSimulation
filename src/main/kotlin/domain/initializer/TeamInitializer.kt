package domain.initializer

import data.model.Team

class TeamInitializer(private val team: Team) : Initializer<Team> {
    override fun initialize(): Team {

        return team
    }
}