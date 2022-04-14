package fr.epf.min1.gestionclient

import android.content.Intent
import android.graphics.Bitmap
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import fr.epf.min1.gestionclient.model.Client

private const val TAG = "DetailsClientActivity"


class DetailsClientActivity : AppCompatActivity() {

    private var clientImageview : ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_client)

        val position = intent.getIntExtra("client_id", -1)

        val client = Client.bdd(40)[position]
        val lastname = client.lastname

        val lastnameTextView =
            findViewById<TextView>(R.id.details_client_lastname_textview)

        lastnameTextView.text = lastname

        clientImageview = findViewById<ImageView>(R.id.details_client_imageview)
        clientImageview?.setClient(client)
        clientImageview?.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 1234)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode){
            1234 -> {
                val bitmap = data?.getParcelableExtra<Bitmap>("data")
                clientImageview?.setImageBitmap(bitmap)
            }
        }
        return super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.details_client,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.delete_client_action -> deleteClient()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteClient() {
        val builder = AlertDialog.Builder(this)
            .setTitle(R.string.confirm_delete_dialog_title)
            .setMessage(R.string.confirm_delete_dialog_message)
            .setPositiveButton(R.string.yes){
                _,_ ->
                finish()
                Toast.makeText(this,R.string.toast_client_deleted, Toast.LENGTH_LONG).show()
            }
            .setNegativeButton(R.string.no){
                a,b ->
                Log.d(TAG, "deleteClient: ")
                Log.i(TAG, "deleteClient: ")
                Log.d(TAG, "deleteClient() called with: a = $a, b = $b")
            }
            .show()
    }
}