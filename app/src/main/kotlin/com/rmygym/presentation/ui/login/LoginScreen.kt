package com.rmygym.presentation.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rmygym.R
import com.rmygym.presentation.components.PrimaryTextField

@Preview(showBackground = true, heightDp = 700)
@Composable
fun LoginScreenPreview() {
    LoginScreen(LoginState("alvaro.montero@hotmail.es", "123123"), null)
}

@Composable
fun LoginScreen(data: LoginState, listeners: LoginListeners?) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        PrimaryTextField(
            value = data.email,
            onValueChange = { listeners?.onEmailChange(it) },
            label = stringResource(R.string.login_email_hint),
        )
        PrimaryTextField(
            modifier = Modifier.padding(top = 8.dp),
            value = data.password,
            onValueChange = { listeners?.onPasswordChange(it) },
            label = stringResource(R.string.login_password_hint),
        )
        Button(
            onClick = { listeners?.onLogin() },
            modifier = Modifier
                .padding(top = 50.dp)
        ) {
            Text(
                text = stringResource(R.string.login_button_login),
                modifier = Modifier.padding(horizontal = 10.dp)
            )
        }
        ClickableText(
            text = AnnotatedString(stringResource(R.string.login_button_register)),
            onClick = { listeners?.onRegister() },
            modifier = Modifier.padding(top = 20.dp)
        )
    }
}

interface LoginListeners {
    fun onEmailChange(email: String)
    fun onPasswordChange(password: String)
    fun onLogin()
    fun onRegister()
}