package es.workinprocess.asignaturasdamretrofit.services

import es.workinprocess.asignaturasdamscaffold.clases.Clases
import retrofit2.Response
import retrofit2.http.GET

interface WebService {

    @GET("/damapi")
    suspend fun getCalendario(): Response<Clases>

}