package com.projectBase.ui.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.projectBase.components.PrimaryTextField

@Preview(showBackground = true, heightDp = 700)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(
        RegisterState(
            "varo95m@gmail.com",
            "123123",
            "varo95m",
            weight = "80",
            height = "183"
        ),
        null
    )
}

@Composable
fun RegisterScreen(data: RegisterState, listeners: RegisterListeners?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PrimaryTextField(
            modifier = Modifier.fillMaxWidth(),
            value = data.username,
            onValueChange = { listeners?.onUsernameChange(it) },
            label = "Usuario"
        )
        PrimaryTextField(
            modifier = Modifier.fillMaxWidth(),
            value = data.email,
            onValueChange = { listeners?.onEmailChange(it) },
            label = "Email"
        )
        PrimaryTextField(
            modifier = Modifier.fillMaxWidth(),
            value = data.password,
            onValueChange = { listeners?.onPasswordChange(it) },
            label = "Password"
        )
        Row {
            PrimaryTextField(
                value = data.height,
                onValueChange = { listeners?.onHeightChange(it) },
                label = "Altura",
                modifier = Modifier
                    .padding(end = 16.dp)
                    .weight(2f),
            )
            PrimaryTextField(
                value = data.weight,
                onValueChange = { listeners?.onWeightChange(it) },
                label = "Peso",
                modifier = Modifier.weight(1f)
            )
        }
        Button(
            modifier = Modifier.padding(top = 16.dp),
            onClick = { listeners?.onRegister() }
        ) {
            Text(text = "Registrarme")
        }
    }
}

interface RegisterListeners {
    fun onUsernameChange(username: String)
    fun onEmailChange(email: String)
    fun onPasswordChange(password: String)
    fun onWeightChange(weight: String)
    fun onHeightChange(height: String)
    fun onRegister()
}