package com.rmygym.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.rmygym.domain.repository.NetworkRepository

class MockNetworkRepository : NetworkRepository {

    private var auth = FirebaseAuth.getInstance().signInAnonymously()
}