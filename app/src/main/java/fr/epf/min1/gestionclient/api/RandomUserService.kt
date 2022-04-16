package fr.epf.min1.gestionclient.api

import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserService {

    @GET("/api")
    suspend fun getUsers(@Query("results") size : Int = 20) : GetUsersResult
}

data class GetUsersResult(val results : List<User>)
data class User(val gender: String, val email: String, val name: Name)
data class Name(val last: String, val first: String)

