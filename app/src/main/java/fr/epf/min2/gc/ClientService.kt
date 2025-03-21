package fr.epf.min2.gc

import retrofit2.http.GET
import retrofit2.http.Query

interface ClientService {

    @GET("api")
    suspend fun loadClients(@Query("results") size : Int = 20) : GetUsersResponse
}

data class GetUsersResponse(val results : List<User>)
data class User(val gender: String, val name: Name)
data class Name(val last: String, val first: String)
