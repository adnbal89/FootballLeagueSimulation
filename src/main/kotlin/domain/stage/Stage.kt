package domain.stage

import data.model.Match
import data.model.Team


interface Stage {
    fun simulate()
    fun isCompleted(): Boolean
    fun simulateDraw(teamList: List<Team>) // draw simulation

}