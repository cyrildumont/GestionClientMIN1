package fr.epf.min1.gestionclient

import android.widget.ImageView
import fr.epf.min1.gestionclient.model.Client
import fr.epf.min1.gestionclient.model.Gender

fun ImageView.setClient(client: Client)  =
    this.setImageResource(
        when(client.gender){
            Gender.MAN -> R.drawable.man
            Gender.WOMAN -> R.drawable.woman
        }
    )
