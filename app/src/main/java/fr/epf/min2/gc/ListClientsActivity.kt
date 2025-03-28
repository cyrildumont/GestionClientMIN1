package fr.epf.min2.gc

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.epf.min2.gc.model.Client
import kotlinx.coroutines.runBlocking

class ListClientsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_clients)

        val recyclerView = findViewById<RecyclerView>(R.id.list_clients_recyclerview)

        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)

        runBlocking {
            val clients = Client.getClient()
            recyclerView.adapter = ClientAdapter(clients)
        }
    }
}