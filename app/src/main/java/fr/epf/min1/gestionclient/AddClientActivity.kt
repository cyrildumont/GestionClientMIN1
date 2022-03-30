package fr.epf.min1.gestionclient

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class AddClientActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_client)
        val lastNameEdittext = findViewById<EditText>(R.id.last_name_edittext)
        val addButton = findViewById<Button>(R.id.add_client_button)
        val levelSpinner = findViewById<Spinner>(R.id.level_spinner)


        addButton.setOnClickListener {

            Log.d("EPF", "Nom : ${lastNameEdittext.text}")
            Log.d("EPF", "Niveau : ${levelSpinner.selectedItem}")
            finish()
        }
    }
}