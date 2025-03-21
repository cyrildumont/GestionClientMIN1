package fr.epf.min2.gc.model

import android.util.Log
import fr.epf.min2.gc.ClientService
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

enum class Gender{
    MAN, WOMAN
}

//fun getClient() :List<Client> {
//    return listOf()
//}

private const val TAG = "Client"

data class Client(val firstName: String,
             val lastName: String,
             val gender: Gender){

    companion object Utils{

        fun getClient() :List<Client> {
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
            runBlocking {
                val clients = clientService.loadClients()
                Log.i(TAG, "getClient: ${clients}")
            }
            return listOf()
        }

    }
}