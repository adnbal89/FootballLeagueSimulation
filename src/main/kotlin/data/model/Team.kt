package data.model

data class Team(
    val name: String,
    val country: String,
    val nameShort: String,
    val stadium: Stadium,
    val squad: List<Player>,
    val previousResults: HashMap<League, Match>
) {
    companion object TeamList {
        //TEAM
        val teamList = arrayListOf(
            Team("Galatasaray", "TR", "GSR", Stadium("ASY", "IST", 50000), arrayListOf(), hashMapOf()),
            Team("Real Madrid", "ESP", "RMA", Stadium("ASY", "MAD", 50000), arrayListOf(), hashMapOf()),
            Team("Man City", "ENG", "MAC", Stadium("ASY", "MAN", 50000), arrayListOf(), hashMapOf()),
            Team("Man Utd", "ENG", "MAN", Stadium("ASY", "MAN", 50000), arrayListOf(), hashMapOf()),
            Team("Liverpool", "ENG", "LIV", Stadium("ASY", "LIV", 50000), arrayListOf(), hashMapOf()),
            Team("Inter", "IT", "INT", Stadium("ASY", "MIL", 50000), arrayListOf(), hashMapOf()),
            Team("Milan", "IT", "MIL", Stadium("ASY", "MIL", 50000), arrayListOf(), hashMapOf()),
            Team("Basel", "SUI", "BAS", Stadium("ASY", "BAS", 50000), arrayListOf(), hashMapOf()),
            Team("Bayern FC", "GER", "BAY", Stadium("ASY", "MUN", 50000), arrayListOf(), hashMapOf()),
            Team("B Dortmund", "GER", "BOR", Stadium("DOR", "IST", 50000), arrayListOf(), hashMapOf()),
            Team("Chelsea", "ENG", "CHE", Stadium("ASY", "CHE", 50000), arrayListOf(), hashMapOf()),
            Team("Juventus", "IT", "JUV", Stadium("ASY", "TOR", 50000), arrayListOf(), hashMapOf()),
            Team("Beşiktaş", "TR", "BJK", Stadium("ASY", "IST", 50000), arrayListOf(), hashMapOf()),
            Team("Porto", "POR", "POR", Stadium("ASY", "POR", 50000), arrayListOf(), hashMapOf()),
            Team("Leipzig", "GER", "LEI", Stadium("ASY", "LEI", 50000), arrayListOf(), hashMapOf()),
            Team("Ajax", "NED", "AJX", Stadium("ASY", "AMS", 50000), arrayListOf(), hashMapOf()),
            Team("Feyenoord", "NED", "FEY", Stadium("ASY", "ROT", 50000), arrayListOf(), hashMapOf()),
            Team("Club Brugge", "BEL", "CBU", Stadium("ASY", "BRU", 50000), arrayListOf(), hashMapOf()),
            Team("PSGermain", "PSG", "PSG", Stadium("PAR", "IST", 50000), arrayListOf(), hashMapOf()),
            Team("Lyon", "TR", "LYO", Stadium("ASY", "LYO", 50000), arrayListOf(), hashMapOf()),

            Team("Eintracht Frankfurt", "GER", "EIF", Stadium("ASY", "FRN", 50000), arrayListOf(), hashMapOf()),
            Team("A Madrid", "ESP", "MAD", Stadium("DOR", "MAD", 50000), arrayListOf(), hashMapOf()),
            Team("Sevilla", "ESP", "SEV", Stadium("ASY", "SEV", 50000), arrayListOf(), hashMapOf()),
            Team("Salzburg", "AUT", "SAL", Stadium("ASY", "AUT", 50000), arrayListOf(), hashMapOf()),
            Team("T Hotspur", "ENG", "TOT", Stadium("ASY", "ENG", 50000), arrayListOf(), hashMapOf()),
            Team("Napoli", "ITA", "NAP", Stadium("ASY", "ITA", 50000), arrayListOf(), hashMapOf()),
            Team("Benfica", "POR", "BEN", Stadium("ASY", "BEN", 50000), arrayListOf(), hashMapOf()),
            Team("Rangers", "SCO", "RAN", Stadium("ASY", "RAN", 50000), arrayListOf(), hashMapOf()),
            Team("Celtic", "SCO", "CEL", Stadium("ASY", "CEL", 50000), arrayListOf(), hashMapOf()),
            Team("Copenhagen", "DEN", "COP", Stadium("ASY", "COP", 50000), arrayListOf(), hashMapOf()),
            Team("Marseille", "FRA", "MAR", Stadium("PFR", "MAR", 50000), arrayListOf(), hashMapOf()),
            Team("V Plzen", "CZE", "VPL", Stadium("ASY", "PLZ", 50000), arrayListOf(), hashMapOf()),
        )
    }
}
