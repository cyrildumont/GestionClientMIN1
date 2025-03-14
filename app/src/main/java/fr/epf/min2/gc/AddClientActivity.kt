package fr.epf.min2.gc

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "AddClientActivity"

class AddClientActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_client)

        val lastNameEdittext = findViewById<EditText>(R.id.client_last_name_edittext)
        val button = findViewById<Button>(R.id.add_client_button)
        val genderRadiogroup = findViewById<RadioGroup>(R.id.client_gender_radiogroup)
        genderRadiogroup.check(R.id.client_gender_woman_radiobutton)

        val ageSeekbar = findViewById<SeekBar>(R.id.client_age_seekbar)
        val ageTextview = findViewById<TextView>(R.id.client_age_textview)

        ageSeekbar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener{
            override fun onProgressChanged(seekbar: SeekBar?, progress: Int, p2: Boolean) {
                ageTextview.text = progress.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) = Unit
            override fun onStopTrackingTouch(p0: SeekBar?) = Unit
        })

        button.setOnClickListener {
            Log.d("EPF", "Nom : ${lastNameEdittext.text}")
            val gender =
                if (genderRadiogroup.checkedRadioButtonId == R.id.client_gender_woman_radiobutton) {
                    "F"
                } else {
                    "H"
                }
            Log.d(TAG, "genre: ${gender}")
            Toast.makeText(this,R.string.add_client_message,Toast.LENGTH_LONG).show()
        }

        button.setOnClickListener{
            Log.d(TAG, "onCreate: ")
        }
    }
}