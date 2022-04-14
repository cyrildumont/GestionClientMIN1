package fr.epf.min1.gestionclient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.list_clients, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when(id){
            R.id.add_client_action -> {
                startActivity(Intent(this, AddClientActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}