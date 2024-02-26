package com.example.webviewapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Button
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.webkit.WebView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        val webView = remember {
            WebView(this@MainScreen)
        }
        webView.loadUrl("https://www.solidledger.com/quantum.html")

        Button(
            modifier = Modifier.alignAs(webView).align(bottom = true),
            onClick = { setContent { MainScreen() } }
        ) {
            Text("Go Back to Home")
        }
    }
}