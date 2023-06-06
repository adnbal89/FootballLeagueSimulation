package domain.initializer

import data.model.Fixture
import data.model.QualificationPairing
import data.model.Team
import domain.generator.QualifyingMatchGenerator

class QualifyingInitializer : Initializer<QualificationPairing> {

    private lateinit var teamList: List<Team>
    private lateinit var matchGenerator: QualifyingMatchGenerator
    private lateinit var qualifyingStage: QualificationPairing
    override fun initialize(name: String): QualificationPairing {
        qualifyingStage = QualificationPairing()
        matchGenerator = QualifyingMatchGenerator()
        var tempListDrawPot = teamList.toMutableList()
        val fixture = Fixture()

        while (tempListDrawPot.isNotEmpty()) {
            val pickedRivalTeamsForThisRound = tempListDrawPot.take(2)

            matchGenerator.generateMatches(pickedRivalTeamsForThisRound).forEach {
                fixture.addMatch(it)
            }

            tempListDrawPot.removeAll(tempListDrawPot.take(2))
        }
        qualifyingStage.setFixture(fixture)

        return qualifyingStage
    }

    fun setTeamList(teamList: List<Team>) {
        this.teamList = teamList
    }
}