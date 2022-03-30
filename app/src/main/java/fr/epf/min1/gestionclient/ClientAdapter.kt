package fr.epf.min1.gestionclient

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.epf.min1.gestionclient.model.Client
import fr.epf.min1.gestionclient.model.Gender

class ClientAdapter(val clients : List<Client>) :
    RecyclerView.Adapter<ClientAdapter.ClientViewHolder>() {

    class ClientViewHolder(val view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val clientView = inflater.inflate(R.layout.adapter_client, parent, false)
        return ClientViewHolder(clientView)
    }

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        val client = clients[position]

        holder.view.setOnClickListener {
            val context = it.context
            val intent = Intent(context, DetailsClientActivity::class.java)
            intent.putExtra("client_id", position)
            context.startActivity(intent)
        }

        val clientTextview =
            holder.view.findViewById<TextView>(R.id.adapter_cient_textview)

        clientTextview.text = client.name

        val clientImageview =
            holder.view.findViewById<ImageView>(R.id.adapter_client_imageview)

        clientImageview.setImageResource(
            when(client.gender){
                Gender.MAN -> R.drawable.man
                Gender.WOMAN -> R.drawable.woman
            }
        )

    }

    override fun getItemCount() =  clients.size

}

/*
    class ClientViewHolder extends RecyclerView.ViewHolder {

        private View view;
        public ClientViewHolder(View view){
            super(view)
            this.view = view;
        }
    }

 */


fun Client.nomComplet() : String {
    return "${this.firstname} ${this.lastname}"
}

val Client.name
    get() = "${this.firstname} ${this.lastname}"