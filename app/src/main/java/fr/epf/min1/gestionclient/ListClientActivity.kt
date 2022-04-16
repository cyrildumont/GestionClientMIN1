package fr.epf.min1.gestionclient

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.epf.min1.gestionclient.api.RandomUserService
import fr.epf.min1.gestionclient.model.Client
import fr.epf.min1.gestionclient.model.Gender
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val TAG = "ListClientActivity"

class ListClientActivity : AppCompatActivity() {

    val clients: MutableList<Client> = mutableListOf()

    private var clientAdapter : ClientAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_client)

        val recyclerView =
            findViewById<RecyclerView>(R.id.list_clients_recyclerview)


        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


//        val clients = Client.bdd(40)
        clientAdapter = ClientAdapter(clients)
        recyclerView.adapter = clientAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.list_clients, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.add_client_action -> {
                startActivity(Intent(this, AddClientActivity::class.java))
            }
            R.id.synchro_api_action -> {
                synchroApi()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun synchroApi() {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()


        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()

        val service = retrofit.create(RandomUserService::class.java)

        runBlocking {
            val result = service.getUsers(5)
            Log.d(TAG, "synchroApi: ${result}")
            val users = result.results
            users.map {
                val (gender, email, name) = it
                val (last, first) = name

                Client(
                    last, first, email,
                    "Débutant", 30,
                    if (gender == "female") Gender.WOMAN else Gender.MAN
                )
            }
                .map {
                    clients.add(it)
                }
        }

        clientAdapter?.notifyDataSetChanged()

    }
}