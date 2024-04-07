package es.workinprocess.asignaturasdamretrofit.navigation

sealed class Paths(val path: String) {
    object Main: Paths("Main")
}