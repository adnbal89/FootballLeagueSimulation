package domain.initializer

interface Initializer<T> {
    fun initialize(): T
}