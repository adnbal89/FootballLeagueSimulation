package domain.initializer

import data.model.Team

class TeamInitializer(private val team: Team) : Initializer<Team> {
    override fun initialize(name: String): Team {

        return team
    }
}