package domain.runner

interface Runner<T> {
    fun run(runnable: T): T
}