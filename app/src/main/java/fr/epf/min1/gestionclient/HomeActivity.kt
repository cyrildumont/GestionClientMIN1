package fr.epf.min1.gestionclient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<Button>(R.id.home_add_client_button)
            .setOnClickListener {
                val intent = Intent(this, AddClientActivity::class.java)
                startActivity(intent)
            }

        findViewById<Button>(R.id.home_list_clients_button)
            .setOnClickListener {
                val intent = Intent(this, ListClientActivity::class.java)
                startActivity(intent)
            }

    }
}