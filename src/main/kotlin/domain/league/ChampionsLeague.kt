package domain.league

import data.model.Team
import domain.draw.GroupDrawPot
import domain.generator.GroupFixtureGenerator
import domain.runner.MatchRunner
import domain.stage.*
import domain.stage.League

class ChampionsLeague : League() {
    private val tempTeamList = Team.teamList.toMutableList()
    private val championsLeague = ChampionsLeague()
    private val fixtureGenerator = GroupFixtureGenerator()
    private val matchRunner = MatchRunner()
    private val drawPot = GroupDrawPot()


    private val preliminaryRound: KnockoutStage = PlayOffRound()
    private val prePlayOffRound: KnockoutStage = PlayOffRound()
    private val groupRound: GroupStage = GroupRound(fixtureGenerator, matchRunner, drawPot)
    private val last16Round: KnockoutStage = PlayOffRound()
    private val quarterFinal: KnockoutStage = PlayOffRound()
    private val semiFinal: KnockoutStage = PlayOffRound()
    private val final: KnockoutStage = PlayOffRound()


}