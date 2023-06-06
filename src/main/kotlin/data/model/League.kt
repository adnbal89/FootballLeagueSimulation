package data.model

import domain.stage.Group
import domain.util.QualifyingNames

class League(
    private val name: String,
    private var level: Enum<LeagueLevel>
) {

}
