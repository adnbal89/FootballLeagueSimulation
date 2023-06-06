package domain.draw

import data.model.Team

interface DrawPot<T> {
    fun simulateDraw(teamList: List<Team>, potCount: Int, teamCountPerPot: Int) : List<T>
}