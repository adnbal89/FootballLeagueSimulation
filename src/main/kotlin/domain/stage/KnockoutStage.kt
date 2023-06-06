package domain.stage

import data.model.Team

interface KnockoutStage : Stage {
    fun drawKnockoutPairings(list: List<Team>, pairCount: Int, teamCountPerKnockout: Int)
    fun simulateExtraTimeAndPenalties() // Simulates extra time and penalties for knockout matches if necessary
    fun generateKnockoutFixtures(isFinalStage: Boolean)

}