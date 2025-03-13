package fr.epf.min2.gc

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddClientActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_client)

        val lastNameEdittext = findViewById<EditText>(R.id.client_last_name_edittext)
        val button = findViewById<Button>(R.id.add_client_button)

        button.setOnClickListener {
            Log.d("EPF","Nom : ${lastNameEdittext.text}")
        }

    }
}