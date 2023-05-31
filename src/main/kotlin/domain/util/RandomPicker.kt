package domain.util

interface RandomPicker {
    fun <T> pickRandomlyFromList(list: List<T>): T
}