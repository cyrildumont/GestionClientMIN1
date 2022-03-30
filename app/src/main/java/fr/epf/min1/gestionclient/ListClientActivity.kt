package fr.epf.min1.gestionclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.epf.min1.gestionclient.model.Client

class ListClientActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_client)

        val recyclerView =
            findViewById<RecyclerView>(R.id.list_clients_recyclerview)


        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        val clients = Client.bdd(40)
        recyclerView.adapter = ClientAdapter(clients)

    }
}