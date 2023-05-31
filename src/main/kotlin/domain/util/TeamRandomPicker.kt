package domain.util

class RandomPickerImpl : RandomPicker {
    override fun <T> pickRandomlyFromList(list: List<T>): T {
        return list.random()
    }
}