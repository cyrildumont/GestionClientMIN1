package fr.epf.min2.gc

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.epf.min2.gc.model.Client
import fr.epf.min2.gc.model.Gender

const val CLIENT_DATA = "client.data"

//public class ClientViewHolder extends RecyclerView.ViewHolder{
//
//    public ClientViewHolder(View view){
//        super(view)
//    }
//}
class ClientViewHolder(view: View) : RecyclerView.ViewHolder(view)

class ClientAdapter(val clients: List<Client>) : RecyclerView.Adapter<ClientViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.client_view, parent, false)
        return ClientViewHolder(view)
    }

    override fun getItemCount() = clients.size


    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        val client = clients[position]
        val (_, _, gender) = client

        val itemView = holder.itemView


        itemView.click {
            with(itemView.context){
                val intent = Intent(this, DetailsClientActivity::class.java).apply {
                    putExtra(CLIENT_DATA, client)
                }
                startActivity(intent)
            }
        }
        itemView.findViewById<TextView>(R.id.client_full_name_textview).apply {
//            text = "${client.firstName} ${client.lastName}"
            text = client.fullName
        }

        itemView.findViewById<ImageView>(R.id.client_imageview).let {

//            it.setImageResource(client.image)
            if(client.imageUrl.isBlank()){
                Glide.with(itemView).load(client.image).into(it)
            }else{
                Glide.with(itemView).load(client.imageUrl).into(it)
            }

//            it.setImageResource(
//                when (gender) {
//                    Gender.MAN -> R.drawable.man
//                    Gender.WOMAN -> R.drawable.woman
//                }
//            )
        }

//        val clientTextview = itemView.findViewById<TextView>(R.id.client_full_name_textview)
//        clientTextview.text= client.lastName
    }
}

val Client.fullName: String
    get() = "${firstName} ${lastName}"

//fun Client.getFullName() : String {
//    return "${firstName} ${lastName}"
//}

val Client.image: Int
    get() = when (gender) {
        Gender.MAN -> R.drawable.man
        Gender.WOMAN -> R.drawable.woman
    }