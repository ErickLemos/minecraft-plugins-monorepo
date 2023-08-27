package org.cabradati.reinos.services

import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentReference
import com.google.cloud.firestore.QuerySnapshot
import com.google.cloud.firestore.WriteResult
import com.google.firebase.cloud.FirestoreClient
import org.cabradati.reinos.models.reino.Reino
import org.cabradati.reinos.utils.getFirestore

class ReinosService {

    private val collection = "reinos"

    fun getByName(nome: String): ApiFuture<QuerySnapshot> {
        return getFirestore().collection(collection)
            .whereEqualTo("nome", nome)
            .get()
    }

    fun getByLider(uid: String): ApiFuture<QuerySnapshot> {
        return getFirestore().collection(collection)
            .whereEqualTo("uidPlayerLider", uid)
            .get()
    }

    fun add(reino: Reino): ApiFuture<DocumentReference> {
        return getFirestore().collection(collection)
            .add(reino)
    }

    fun remove(uid: String): ApiFuture<WriteResult> {
        return getFirestore().collection(collection)
            .document(uid)
            .delete()
    }

}