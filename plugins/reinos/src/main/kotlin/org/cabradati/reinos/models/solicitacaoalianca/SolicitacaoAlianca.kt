package org.cabradati.reinos.models.solicitacaoalianca

import com.google.gson.annotations.SerializedName

data class SolicitacaoAlianca(

    @field:SerializedName("nome_reino_solicitante")
    val nomeReinoSolicitante: String = "",

    @field:SerializedName("uid_reino_solicitante")
    val uidReinoSolicitante: String = "",

    @field:SerializedName("uid_reino_convidado")
    val uidReinoConvidado: String = "",

    @field:SerializedName("status")
    val status: StatusSolicitacao = StatusSolicitacao.PENDENTE

)