package org.cabradati.reinos.models

import com.google.gson.annotations.SerializedName
import org.cabradati.reinos.models.enums.StatusSolicitacao

data class SolicitacaoAlianca(

    @field:SerializedName("uid_reino_solicitante")
    val uidReinoSolicitante: String = "",

    @field:SerializedName("uid_reino_convidado")
    val uidReinoConvidado: String = "",

    @field:SerializedName("status")
    val status: StatusSolicitacao = StatusSolicitacao.PENDENTE

)