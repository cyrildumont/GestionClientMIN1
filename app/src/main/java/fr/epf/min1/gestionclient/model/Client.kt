package fr.epf.min1.gestionclient.model

enum class Gender{
    MAN,WOMAN
}

data class Client(
    val lastname: String,
    val firstname: String,
    val email: String?,
    val level: String,
    val age: Int,
    val gender: Gender
) {
    companion object {
        fun bdd(nb : Int = 30) =
             (1..nb).map {
                val gender = if (it % 2 == 0) Gender.MAN else Gender.WOMAN
                Client(
                    "nom$it", "prenom$it",
                    "mail$it@epf.fr", "Débutant", 20 + it,
                    gender
                )
            }

    }
}