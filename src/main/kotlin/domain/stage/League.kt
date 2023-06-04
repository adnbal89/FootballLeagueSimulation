package domain.stage

interface League {
    val name: String
    val rounds: MutableList<Stage>
}
