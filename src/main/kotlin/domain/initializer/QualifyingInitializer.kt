package domain.initializer

import data.model.Fixture
import data.model.QualifyingStage
import data.model.Team
import domain.util.GroupMatchGenerator
import domain.util.QualifyingMatchGenerator

class QualifyingInitializer : Initializer<QualifyingStage> {

    private lateinit var teamList: List<Team>
    private lateinit var matchGenerator: QualifyingMatchGenerator
    private lateinit var qualifyingStage: QualifyingStage
    override fun initialize(name: String): QualifyingStage {
        qualifyingStage = QualifyingStage(name)
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