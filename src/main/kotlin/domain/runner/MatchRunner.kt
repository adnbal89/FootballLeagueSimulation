package domain.runner

import data.model.Match
import data.model.Score
import domain.score.ScoreRandomizer

class MatchRunner : Runner<Match> {
    private val randomizer: ScoreRandomizer = ScoreRandomizer()
    private lateinit var _score: Score
    override fun run(match: Match): Match {
        val homeScore = randomizer.randomize(7)
        val awayScore = randomizer.randomize(7)
        _score = Score(homeScore, awayScore)

        match.score = _score
        return match
    }
}