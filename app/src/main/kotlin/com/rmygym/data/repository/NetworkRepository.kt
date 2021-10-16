package com.rmygym.data.repository

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.rmygym.domain.repository.NetworkRepository

class NetworkRepository(context: Context) : NetworkRepository {
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
}
