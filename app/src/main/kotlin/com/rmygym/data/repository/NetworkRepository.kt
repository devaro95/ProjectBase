package com.rmygym.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.rmygym.data.repository.Collection.USERS
import com.rmygym.data.repository.Field.EMAIL
import com.rmygym.data.repository.Field.USERNAME
import com.rmygym.domain.exceptions.Register.UsernameExistsException
import com.rmygym.domain.model.UserModel
import com.rmygym.domain.model.request.RequestLoginModel
import com.rmygym.domain.model.request.RequestRegisterModel
import com.rmygym.domain.repository.NetworkRepository

class NetworkRepository : NetworkRepository {

    private val auth = FirebaseAuth.getInstance()

    private val db = Firebase.firestore

    override suspend fun login(request: RequestLoginModel) {
        auth.signInWithEmailAndPassword(request.email, request.password).addOnSuccessListener {
            db.collection(USERS).whereEqualTo(EMAIL, request.email).get().addOnSuccessListener {
                it.documents.firstOrNull()?.toObject(UserModel::class.java)?.let { user ->
                    request.onSuccess?.invoke(user)
                } ?: request.onError?.invoke(Exception())
            }
        }.addOnFailureListener {
            request.onError?.invoke(it.handleError())
        }
    }

    override suspend fun register(request: RequestRegisterModel) {
        db.collection(USERS).whereEqualTo(USERNAME, request.username).get().addOnSuccessListener {
            if (it.documents.isEmpty()) {
                auth.createUserWithEmailAndPassword(request.email, request.password).addOnSuccessListener {
                    db.collection(USERS).add(request.toDataModel()).addOnSuccessListener { document ->
                        document.get().addOnSuccessListener { user ->
                            request.onSuccess?.invoke(user.toObject(UserModel::class.java))
                        }
                    }.addOnFailureListener { error ->
                        request.onError?.invoke(error.handleError())
                    }
                }.addOnFailureListener { error ->
                    request.onError?.invoke(error.handleError())
                }
            } else request.onError?.invoke(UsernameExistsException())
        }.addOnFailureListener { error ->
            request.onError?.invoke(error.handleError())
        }
    }
}
