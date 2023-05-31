package domain.initializer

interface Initializer<T> {
    fun initialize(name: String): T

    //fun <E> inititialize(t: List<E>): T
}