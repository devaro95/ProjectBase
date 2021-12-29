package com.rmygym.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.rmygym.domain.repository.NetworkRepository

class NetworkRepository() : NetworkRepository {
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
}
