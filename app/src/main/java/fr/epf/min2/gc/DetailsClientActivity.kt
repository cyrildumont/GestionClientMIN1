package fr.epf.min2.gc

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import fr.epf.min2.gc.model.Client
import fr.epf.min2.gc.model.Gender

class DetailsClientActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_client)

        val imageView = findViewById<ImageView>(R.id.details_client_imageview)
        val fullNameTextview = findViewById<TextView>(R.id.details_client_full_name_textview)

        val extras = intent.extras

        val client =  extras?.getParcelable(CLIENT_DATA) as? Client
            ?: Client("NR", "NR",Gender.MAN)

        client.let {
                fullNameTextview.text = it.fullName
                Glide.with(this).load(it.imageUrl).into(imageView)
        }

//        extras?.getParcelable(CLIENT_DATA, Client::class.java)?.let {
//            fullNameTextview.text = it.fullName
//            Glide.with(this).load(it.imageUrl).into(imageView)
//        }


    }
}