package fr.epf.min2.gc.model

import android.util.Log
import fr.epf.min2.gc.ClientService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

enum class Gender {
    MAN, WOMAN
}

//fun getClient() :List<Client> {
//    return listOf()
//}

private const val TAG = "Client"

data class Client(
    val firstName: String,
    val lastName: String,
    val gender: Gender
) {

    companion object Utils {

        suspend fun getClient(): List<Client> {
            val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            val client = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(" https://randomuser.me/")
                .addConverterFactory(MoshiConverterFactory.create())
                .client(client)
                .build()

            val clientService = retrofit.create(ClientService::class.java)

            val getUsersResponse = clientService.loadClients()
            Log.i(TAG, "getClient: ${getUsersResponse}")
            val clients = getUsersResponse.results.map {
                Client(
                    it.name.first, it.name.last,
                    if (it.gender == "male") Gender.MAN else Gender.WOMAN
                )
            }
            return clients
        }

    }
}