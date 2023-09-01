package com.example.moviesapp.profile_feature.presentation.screens.signInScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

@Composable
fun SignInScreen(){
    SignInScreenContent()
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun SignInScreenContent() {
  val state = rememberWebViewState(url = "https://www.themoviedb.org/signup")
    WebView(
        state = state,
        modifier = Modifier.fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight()
    )
}
