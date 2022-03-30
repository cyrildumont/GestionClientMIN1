package fr.epf.min1.gestionclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import fr.epf.min1.gestionclient.model.Client

class DetailsClientActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_client)

        val position = intent.getIntExtra("client_id", -1)

        val lastname = Client.bdd(40)[position].lastname

        val lastnameTextView =
            findViewById<TextView>(R.id.details_client_lastname_textview)

        lastnameTextView.text = lastname
    }
}