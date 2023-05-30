package domain.score

import domain.util.Randomizer
import kotlin.random.Random

class ScoreRandomizer : Randomizer {
    override fun randomize(range: Int): Int {
        return Random.nextInt(0, range)
    }

}
