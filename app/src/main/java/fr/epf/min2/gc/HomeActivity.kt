package fr.epf.min2.gc

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import fr.epf.min2.gc.model.Client

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val addButton = findViewById<Button>(R.id.home_add_client_button)
        val listButton = findViewById<Button>(R.id.home_list_clients_button)

        addButton.setOnClickListener {
            val intent = Intent(this, AddClientActivity::class.java)
            startActivity(intent)
        }

        listButton.click {
            val intent = Intent(this, ListClientsActivity::class.java)
            startActivity(intent)
        }

//        listButton.setOnClickListener {
//            Client.getClient()
//        }
    }
}

fun View.click(action : (View) -> Unit){
    Log.d("EPF", "click !")
    setOnClickListener(action)
}
