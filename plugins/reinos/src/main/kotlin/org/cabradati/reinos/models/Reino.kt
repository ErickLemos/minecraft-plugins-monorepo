package org.cabradati.reinos.models

import com.google.gson.annotations.SerializedName

data class Reino(

    @field:SerializedName("uid_player_lider")
    val uidPlayerLider: String = "",

    @field:SerializedName("nome")
    val nome: String = "",

    @field:SerializedName("aliancas")
    val aliancas: List<Alianca> = listOf(),

    @field:SerializedName("guerras")
    val guerras: List<Guerra> = listOf()

)