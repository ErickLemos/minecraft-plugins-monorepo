package org.cabradati.reinos.models.reino

import com.google.cloud.firestore.annotation.DocumentId
import com.google.cloud.firestore.annotation.PropertyName

data class Reino(

    @PropertyName("uid_player_lider")
    var uidPlayerLider: String = "",

    @PropertyName("nome")
    var nome: String = "",

    @PropertyName("aliancas")
    var aliancas: List<Alianca> = listOf(),

    @PropertyName("guerras")
    var guerras: List<Guerra> = listOf(),

    @PropertyName("membros")
    var membros: List<Membro> = listOf()

)