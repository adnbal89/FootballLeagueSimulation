package data.model

class Fixture() {
    private val matches: MutableList<Match> = mutableListOf()

    fun addMatch(match: Match) {
        matches.add(match)
    }

    fun getMatches(): List<Match> {
        return matches
    }

}