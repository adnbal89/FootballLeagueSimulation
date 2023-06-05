package domain.stage

abstract class League(open val name: String, open val rounds: MutableList<Stage>)
