package domain.draw

import data.model.QualificationPairing
import data.model.Team

class KnockoutDrawPot : DrawPot<QualificationPairing> {
    override fun simulateDraw(teamList: List<Team>, potCount: Int, teamCountPerPot: Int): List<QualificationPairing> {
        val pairList = mutableListOf<QualificationPairing>()
        val tempTeamList = teamList.toMutableList()


        for (i in 0 until potCount) {
            val qualificationPairing = QualificationPairing()

            for (j in 0 until teamCountPerPot){
                val pickedTeam = tempTeamList.random()
                qualificationPairing.addTeam(pickedTeam)
                tempTeamList.remove(pickedTeam)
            }
            pairList.add(qualificationPairing)
        }

        return pairList
    }
}