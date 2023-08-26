package org.cabradati.reinos.services

import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentReference
import com.google.cloud.firestore.QuerySnapshot
import com.google.cloud.firestore.WriteResult
import com.google.firebase.cloud.FirestoreClient
import org.cabradati.reinos.models.Reino

class ReinosService {

    private val collection = "reinos"
    private val firestore = FirestoreClient.getFirestore()

    fun getByName(nome: String): ApiFuture<QuerySnapshot> {
        return firestore.collection(collection)
            .whereEqualTo("nome", nome)
            .get()
    }

    fun add(reino: Reino): ApiFuture<DocumentReference>? {
        return firestore.collection(collection)
            .add(reino)
    }

    fun remove(uid: String): ApiFuture<WriteResult> {
        return firestore.collection(collection)
            .document(uid)
            .delete()
    }

}