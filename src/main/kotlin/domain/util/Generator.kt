package domain.util

import data.model.Fixture
import data.model.Team

interface FixtureGenerator {
    fun generateFixture(list: List<Team>): Fixture
}