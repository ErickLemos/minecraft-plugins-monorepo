package org.cabradati.reinos.services

import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentReference
import com.google.cloud.firestore.QuerySnapshot
import org.cabradati.reinos.models.solicitacaoalianca.SolicitacaoAlianca
import org.cabradati.reinos.utils.getFirestore

class SolicitacaoAliancaService {

    private val collection = "reinos_soliticacoes_alianca"

    fun getSolicitacoesByReinoSolicitante(uid: String): ApiFuture<QuerySnapshot> {
        return getFirestore().collection(collection)
            .whereEqualTo("uid_reino_solicitante", uid)
            .get()
    }

    fun getSolicitacoesByReinoConvidado(uid: String): ApiFuture<QuerySnapshot> {
        return getFirestore().collection(collection)
            .whereEqualTo("uidReinoConvidado", uid)
            .get()
    }

    fun enviarSolicitacao(solicitacaoAlianca: SolicitacaoAlianca): ApiFuture<DocumentReference> {
        return getFirestore().collection(collection)
            .add(solicitacaoAlianca)
    }

}