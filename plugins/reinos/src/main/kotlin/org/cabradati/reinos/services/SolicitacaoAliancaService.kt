package org.cabradati.reinos.services

import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentReference
import com.google.cloud.firestore.QuerySnapshot
import com.google.firebase.cloud.FirestoreClient
import org.cabradati.reinos.models.SolicitacaoAlianca
import org.cabradati.reinos.models.enums.StatusSolicitacao

class SolicitacaoAliancaService {

    private val collection = "reinos_soliticacoes_alianca"
    private val firestore = FirestoreClient.getFirestore()

    fun getSolicitacoesByReinoSolicitante(uid: String): ApiFuture<QuerySnapshot> {
        return firestore.collection(collection)
            .whereEqualTo("uid_reino_solicitante", uid)
            .get()
    }

    fun getSolicitacoesByReinoConvidado(uid: String): ApiFuture<QuerySnapshot> {
        return firestore.collection(collection)
            .whereEqualTo("uid_reino_convidado", uid)
            .get()
    }

    fun enviarSolicitacao(uidSolicitante: String, uidConvidado: String): ApiFuture<DocumentReference> {
        return firestore.collection(collection)
            .add(SolicitacaoAlianca(
                uidReinoSolicitante = uidSolicitante,
                uidReinoConvidado = uidConvidado,
                StatusSolicitacao.PENDENTE
            ))
    }

}