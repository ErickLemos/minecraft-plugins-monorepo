package org.cabradati.reinos.models.reino

import com.google.cloud.firestore.annotation.DocumentId
import com.google.cloud.firestore.annotation.PropertyName

data class Reino(

    @DocumentId
    var uid: String = "",

    @PropertyName("uid_player_lider")
    val uidPlayerLider: String = "",

    @PropertyName("nome")
    val nome: String = "",

    @PropertyName("aliancas")
    val aliancas: List<Alianca> = listOf(),

    @PropertyName("guerras")
    val guerras: List<Guerra> = listOf(),

    @PropertyName("membros")
    val membros: List<Membro> = listOf()

)