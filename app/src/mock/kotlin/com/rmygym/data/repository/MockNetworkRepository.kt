package com.rmygym.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.rmygym.domain.model.UserModel
import com.rmygym.domain.model.request.RequestLoginModel
import com.rmygym.domain.model.request.RequestRegisterModel
import com.rmygym.domain.repository.NetworkRepository

class MockNetworkRepository : NetworkRepository {

    private var auth = FirebaseAuth.getInstance().signInAnonymously()

    override suspend fun login(request: RequestLoginModel) {
        auth.addOnCompleteListener {
            request.onSuccess?.invoke(UserModel())
        }
    }

    override suspend fun register(request: RequestRegisterModel) {
        auth.addOnCompleteListener {
            request.onSuccess?.invoke(null)
        }
    }
}
